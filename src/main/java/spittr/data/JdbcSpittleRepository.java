package spittr.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spittr.domain.Spittle;
@Repository
public class JdbcSpittleRepository implements SpittleRepository {
	
	private JdbcOperations jdbc;
	@Autowired
	public JdbcSpittleRepository(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		String sql="select id,message,created_at,longitude,latitude from spittle"
				+ " where id< ? order by created_at desc limit 20";
		return jdbc.query(sql, new SpittleRowMapper(),max);
	}
	private static class SpittleRowMapper implements RowMapper<Spittle>{

		@Override
		public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new Spittle(rs.getLong("id"),
					rs.getString("message"),
					rs.getDate("created_at"),
					rs.getDouble("longitude"),
					rs.getDouble("latitude"));
		}
		
	}
	@Override
	public Spittle findOne(long id) {
		return jdbc.queryForObject("select id,message,created_at,longitude,latitude"
				+ " from spittle"
				+ " where id=?", new SpittleRowMapper(),id);
	}

	@Override
	public List<Spittle> findRecentSpittles() {
		return jdbc.query("select id,message,created_at,longitude,latitude"
				+ " from spittle order by created_at desc limit 20", new SpittleRowMapper());
	}

	@Override
	public void save(Spittle spittle) {
		jdbc.update("insert into Spittle(message,created_at,latitude,longitude) values(?,?,?,?)",
				spittle.getMessage(),
				spittle.getTime(),
				spittle.getLatitude(),
				spittle.getLongitude());
		
	}
}
