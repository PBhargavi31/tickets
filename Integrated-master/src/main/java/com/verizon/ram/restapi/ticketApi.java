package com.verizon.ram.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.ram.model.Hardware;
import com.verizon.ram.model.Priority;

import com.verizon.ram.model.TStatus;
import com.verizon.ram.model.Tickets;
import com.verizon.ram.model.Trtype;
import com.verizon.ram.service.TicketService;


@RestController
//@CrossOrigin
@RequestMapping("/tickets")


public class ticketApi {
	
	@Autowired
	private TicketService tService;

	
	@GetMapping
	public ResponseEntity<List<Tickets>> listTickets(){
		ResponseEntity<List<Tickets>> resp=null;
		
		List<Tickets> tickets = tService.getAllTickets();
		if(tickets != null && tickets.size() >0)
			resp = new ResponseEntity<List<Tickets>>(tickets, HttpStatus.OK);
		else
			resp = new ResponseEntity<List<Tickets>>(tickets,HttpStatus.NOT_FOUND);
		return resp;
		
	}
@PostMapping("/addTicket")
public ResponseEntity<Tickets> addTicketsAction(@RequestBody Tickets ticket) {
	ticket.setStatus(TStatus.CREATED);//Default Status
	ResponseEntity<Tickets> resp=new ResponseEntity<Tickets>(ticket, HttpStatus.NOT_ACCEPTABLE);
	if(ticket!=null && tService.existsByTid(ticket.getTid()))return resp;
	tService.addTicket(ticket);
	resp = new ResponseEntity<Tickets>(ticket, HttpStatus.OK);
	return resp;

}
	
	@GetMapping("/tid/{id}")
	public ResponseEntity <Tickets> getTicketId(@PathVariable("id") long tId) {
		
		ResponseEntity<Tickets> resp=null;
		Tickets tickets =tService.getTicketById(tId);
		if (tickets == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<>(tickets, HttpStatus.OK);
		return resp;
		
	}
	
	@PutMapping("/{tId}/{tstatus}")
	public ResponseEntity <Tickets> updateTicketState(@PathVariable("tstatus") String tstatus,@PathVariable("tId") long tId){
		tService.setStatusById(tstatus, tId);
		Tickets t = tService.getTicketById(tId);
		ResponseEntity<Tickets> resp=null;
		Tickets tickets =tService.getTicketById(tId);
		resp = new ResponseEntity<>(HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/status/{tstatus}")
	public ResponseEntity<List<Tickets>> getTicketStatus(@PathVariable("tstatus") String tstatus) {
		ResponseEntity<List<Tickets>> resp = null;
		List<Tickets> tickets = tService.getTicketsByStatus(tstatus);
		if (tickets == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<List<Tickets>>(tickets, HttpStatus.OK);
		return resp;
	}
	
	
	@GetMapping("/priority/{priority}")
	

	public ResponseEntity<List<Tickets>> getTicketPriority(@PathVariable("priority") Priority priority) {
		ResponseEntity<List<Tickets>> resp = null;
		List<Tickets> tickets = tService.getTicketsByPriority(priority);
		if (tickets == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<List<Tickets>>(tickets, HttpStatus.OK);
		return resp;
	}	
	//TODO: to be changed to be 
	@GetMapping("/uid/{uid}")
	public ResponseEntity <Tickets> getTicketuId(@PathVariable("uid") long uid) {
		
		ResponseEntity<Tickets> resp=null;
		Tickets tickets =tService.getTicketByUid(uid);
		if (tickets == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		else
			resp = new ResponseEntity<>(tickets, HttpStatus.OK);
		return resp;
		
	}
//	@GetMapping("/TicketByManagerId/{mid}")
//	public ResponseEntity <Tickets> ticketByManagerId(@PathVariable("mid") long mid){
//		ResponseEntity<List<Tickets>> resp=null;
//		List<Users> ul=uService.findAllByMid(mid);
//		List<Tickets> t = null;
//		ul.forEach(i->{
//			System.out.println(tService.getTicketByUid(i.getUid()).gettId());
//			});
//		resp = new ResponseEntity<>(t, HttpStatus.OK);
//		return resp;
//	}

	
	@GetMapping("/Trtype/{type}")
	public ResponseEntity<List<Tickets>> ticketByType(@PathVariable("type") Trtype type){
		ResponseEntity<List<Tickets>> resp = null;
		List<Tickets> tickets = tService.getTicketsByTrtype(type);
		if (tickets == null)
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			resp = new ResponseEntity<List<Tickets>>(tickets, HttpStatus.OK);
		return resp;
	}
	
//	
//	@GetMapping("/Hardware/{hard}")
//	public ResponseEntity<List<Tickets>> ticketByType(@PathVariable("hard") String h){
//		ResponseEntity<List<Tickets>> resp = null;
//		List<Tickets> tickets = tService.getTicketsByHtype(h);
//		if (tickets == null)
//			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		else
//			resp = new ResponseEntity<List<Tickets>>(tickets, HttpStatus.OK);
//		return resp;
//	}
//	
	
	

}

















































