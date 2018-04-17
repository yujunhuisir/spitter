package spittr.data;

import java.util.List;

import spittr.domain.Spittle;

public interface SpittleRepository {
	List<Spittle>findSpittles(long max,int count);
	Spittle findOne(long spittleId);
	List<Spittle>findRecentSpittles();
	void save(Spittle spittle);
	
}
