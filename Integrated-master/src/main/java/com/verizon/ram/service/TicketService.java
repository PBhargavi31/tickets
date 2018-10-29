package com.verizon.ram.service;

import java.util.List;

import com.verizon.ram.model.Hardware;
import com.verizon.ram.model.Priority;
import com.verizon.ram.model.Software;
import com.verizon.ram.model.Tickets;
import com.verizon.ram.model.Trtype;


public interface TicketService {

	public List<Tickets> getAllTickets();

	public void addTicket(Tickets ticket);

	public boolean existsByTid(long tid);
	public boolean existsByUid(long uid);
	public Tickets getTicketById(long tid);
	public Tickets getTicketByUid(long uid);
//	public Tickets getTicketByMid(long mid);
	
	public List<Tickets> getTicketsByStatus(String tstatus);
	public List<Tickets> getTicketsByPriority(Priority priority);
	public void setStatusById(String status,long tid);
	//	List<Resourcer> findAllByRtype(Rtype rtype);

	public List<Tickets> getTicketsByTrtype(Trtype type);
	//public List<Tickets> getTicketsByHtype(String htype);
	//public List<Tickets> findAllBySwtype(Software stype);

	
	

	
	
}
