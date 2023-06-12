package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.booking.model.TicketModel;
import com.booking.repository.TicketRepository;


import jakarta.transaction.Transactional;


@Service
public class TicketService {
	@Autowired
	TicketRepository tr;
	
	public List<TicketModel> getMovieDetails(){
		return tr.findAll();
	}
	public TicketModel saveDetails(TicketModel s)
	{
		return tr.save(s);
	}
	
	public TicketModel updateDetails(TicketModel r)
	{
		return tr.save(r);
		
	}
	public TicketModel editDetails(TicketModel id)
	{
		 return tr.save(id);
	}
	public void deleteDetails(int movieid)
	{
		tr.deleteById(movieid);
	}
	
	public TicketModel findMovieById(int id)
	{
		return tr.findById(id).orElse(null);
	}
	public List<TicketModel> sortmoviename(String field)
	{
		return tr.findAll(Sort.by(field));
	}
//	return lr.findAll(Sort.by(Direction.DESC, field));

	public List<TicketModel> subsort(String field1, String field2) {
		
		return tr.findAll(Sort.by(field1).and (Sort.by(field2)));
	}
	public List<TicketModel> pagingmovie(int offset,int pagesize)
	{
		Page<TicketModel> paging=tr.findAll(PageRequest.of(offset, pagesize));
		
		return paging.getContent();
	}
	public Page<TicketModel> pagingmov(int offset,int pagesize)
	{
		Page<TicketModel> page=tr.findAll(PageRequest.of(offset, pagesize));
		
		return page;
	}
	public List<TicketModel> pagesortmovie(int offset,int pagesize,String field)
	{
		Page<TicketModel> paging=tr.findAll(PageRequest.of(offset, pagesize).withSort(Sort.by(field)));
		
		return paging.getContent();
	}
	public List<TicketModel> getByMovieName(String prefix)
	{
		return tr.findByMovienameStartingWith(prefix);
	}
	public List<TicketModel> get1ByMovieName(String suffix)
	{
		return tr.findByMovienameEndingWith(suffix);
	}
	public List<TicketModel> getByGenre(String genre)
	{
		return tr.findByGenre(genre);
	}
	public List<TicketModel> getByMovie(String moviename,String genre)
	{
		return tr.getByMovieName(moviename,genre);
	}
	public List<TicketModel> getByActor(String leadactor)
	{
		return tr.getByLeadActor(leadactor);
	}
	@Transactional
	public int deleteMovieName(String moviename)
	{
		return tr.deleteByMovieName(moviename);
	}
	@Transactional
	public int updateLeadActor(String leadactor,int id)
	{
		return tr.updateByLeadactor(leadactor, id);
	}
public TicketModel getMovieById(int id) {
		
		return tr.findById(id).orElse(null);
	}
	
}
