package com.verizon.app.controller;

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

import com.verizon.app.model.Priority;
import com.verizon.app.model.TStatus;
import com.verizon.app.model.Tickets;
import com.verizon.app.service.TicketService;

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
	if(ticket!=null && tService.existsByTId(ticket.gettId()))return resp;
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
	
//	@PutMapping("/{tId}/{tstatus}")
//	public ResponseEntity<Tickets> updateTicketState(@PathVariable("tstatus") String tstatus,@PathVariable("tId") long tId){
//		ResponseEntity<Tickets> resp=null;
////		System.out.println("================================PANICHESTADI===================================");
////		System.out.println("Ticket Id is+++++++++++++++++++++++++++++"+tId);
////		System.out.println("Ticket Status+++++++++++++++++++++++++++++"+s);
//		Tickets t = tService.setStatusById(tstatus, tId);
//		return new ResponseEntity<>(t, HttpStatus.OK);
//	}
	
	@GetMapping("//{tstatus}")
	public ResponseEntity<List<Tickets>> getTicketStatus(@PathVariable("tstatus") TStatus tstatus) {
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


}

















































