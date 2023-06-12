package com.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.booking.model.TicketModel;
public interface TicketRepository extends JpaRepository<TicketModel, Integer> {
	
	public List<TicketModel> findByMovienameStartingWith(String prefix);
	public List<TicketModel> findByMovienameEndingWith(String suffix);
	public List<TicketModel> findByGenre(String genre);
	@Query("select l from TicketModel l where l.moviename=?1 and l.genre=?2")
	public List<TicketModel> getByMovieName(String moviename,String genre);
	//named parameter
	@Query("select l from TicketModel l where l.leadactor=:leadactor")
	public List<TicketModel> getByLeadActor(String leadactor);
	//DML
	@Modifying
	@Query("delete from TicketModel l where l.moviename=?1")
	public int deleteByMovieName(String moviename);
	@Modifying
	@Query("update TicketModel l set l.leadactor=?1 where l.id=?2")
	public int updateByLeadactor(String leadactor,int id);
}

