package com.verizon.app.service;

import java.util.List;

import com.verizon.app.model.Priority;
import com.verizon.app.model.TStatus;
import com.verizon.app.model.Tickets;


public interface TicketService {

	public List<Tickets> getAllTickets();

	public void addTicket(Tickets ticket);

	public boolean existsByTId(long tId);
	public Tickets getTicketById(long tId);
	public List<Tickets> getTicketsByStatus(TStatus tstatus);
	public List<Tickets> getTicketsByPriority(Priority priority);

	


}
