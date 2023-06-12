package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.model.TicketModel;
import com.booking.service.TicketService;


import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
public class TicketController {
	@Autowired
	TicketService ts;
	@Tag(name="Show Movies",description="get movie details")
	@GetMapping("/moviedetails")
	public List<TicketModel> getMovieDetails()
	{
		return ts.getMovieDetails();
	}
//	@GetMapping("/moviedetails/{id}")
//    public TicketModel getProductById(@PathVariable int id)
//    {
//    	return ts.getMovieById(id);
//    }
	@PostMapping("/save")
	public String saveall(@RequestBody TicketModel id)
	{
		ts.saveDetails(id);
		return "Id details Saved";
	}
	@PutMapping("/update")
    public TicketModel updateDetails(@RequestBody TicketModel r)
    {
    	return ts.updateDetails(r);
    }
	@PutMapping("/edit/{movieid}")
    public TicketModel editDetails(@RequestBody TicketModel movieid)
    {
    	return ts.editDetails(movieid);
    }
	@DeleteMapping("/delete/{id}")
    public String deleteDetails(@PathVariable int id)
    {
    	ts.deleteDetails(id);
    	return "deleted";
    }
	@GetMapping("/moviedetails/{id}")
	public TicketModel findMovieById(@PathVariable int id)
    {
    	return ts.findMovieById(id);
    }
    @GetMapping("/sortdetail")
    public List<TicketModel> sortmovie(@RequestParam String field) 
    {
    	return ts.sortmoviename(field);
    }
    @GetMapping("/subsort")
    public List<TicketModel> subsort(@RequestParam String field1,@RequestParam String field2){
    	
    	return ts.subsort(field1,field2);
    }
    //List
    @GetMapping("/pageable")
    public List<TicketModel> pagingmovie(@RequestParam int offset,@RequestParam int pagesize)
    {
    	return ts.pagingmovie(offset,pagesize);
    }
    //page
    @GetMapping("/page")
    public Page<TicketModel> pagingproduct1(@RequestParam int offset,@RequestParam int pagesize)
    {
    	return ts.pagingmov(offset,pagesize);
    }
    @GetMapping("/pagesort")
    public List<TicketModel> pagesortproduct(@RequestParam int offset,@RequestParam int pagesize,@RequestParam String field)
    {
    	return ts.pagesortmovie(offset,pagesize,field);
    }
    @GetMapping("/movienamestartingwith")
    public List<TicketModel> getByMovieName(@RequestParam String prefix)
    {
    	return ts.getByMovieName(prefix);
    }
    @GetMapping("/movienameendingwith")
    public List<TicketModel> get1ByMovieName(@RequestParam String suffix)
    {
    	return ts.get1ByMovieName(suffix);
    }
    @GetMapping("/genre")
    public List<TicketModel> getBygenre(@RequestParam String genre)
	{
		return ts.getByGenre(genre);
	}
    @GetMapping("/getByMovie")
    public List<TicketModel> getByMovie(@RequestParam String moviename,@RequestParam String genre)
	{
		return ts.getByMovie(moviename,genre);
	}
    @GetMapping("/getbyLeadActor")
    public List<TicketModel> getProductname(@RequestParam String leadactor)
    {
    	return ts.getByActor(leadactor);
    }
    @DeleteMapping("/deletebymoviename")
    public String deleteproduct(@RequestParam String moviename)
    {
    	int result= ts.deleteMovieName(moviename);
    	if(result>0)
    	{
    		return "Movie Details Deleted";
    	}
    	else
    	{
    		return "Problem occured while deleting";
    	}		
    }
    @PutMapping("/updateleadactorname/{leadactor}/{id}")
   	public String updatecustname(@PathVariable String leadactor,@PathVariable int id)
   	{
   	     int result= ts.updateLeadActor(leadactor, id);
   	     if(result>0)
   	     {
   	    	 return "Updated Successfully";
   	     }
   	     else
   	     {
   	    	 return "Problem occured while updating";
   	     }
   	}

}
