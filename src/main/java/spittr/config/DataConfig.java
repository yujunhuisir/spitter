package spittr.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DataConfig {

  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("schema.sql")
            .addScripts("test-data.sql")
            .build();
  }
 /* @Bean
  public DataSource dataSource() {
	  DriverManagerDataSource ds = new DriverManagerDataSource();
	  ds.setDriverClassName("com.mysql.jdbc.Driver");
	  ds.setUrl("jdbc:mysql://localhost:3306/first?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&&useSSL=false");
	  ds.setUsername("root");
	  ds.setPassword("root");
	  return ds;
  }*/
  
  @Bean
  public JdbcOperations jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

}
