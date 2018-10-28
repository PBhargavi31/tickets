package com.verizon.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.verizon.app.dao.TicketDao;
import com.verizon.app.model.Priority;
import com.verizon.app.model.TStatus;
import com.verizon.app.model.Tickets;

@Component 
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao tdao;
	
	@Override
	public List<Tickets> getAllTickets() {
		return tdao.findAll();//findAll is inbuilt in jpa repo
	}

	@Override
	public void addTicket(Tickets ticket) {
		tdao.save(ticket);//save is inbuilt, to insert or add values
	}


	@Override
	public Tickets getTicketById(long tId) {
		
		Optional<Tickets> opt = tdao.findById(tId);
		return opt.isPresent()?opt.get():null;
				
	}

	@Override
	public List<Tickets> getTicketsByStatus(TStatus tstatus) {
		return tdao.findAllByStatus(tstatus);
	}

	@Override
	public List<Tickets> getTicketsByPriority(Priority priority) {
		
		return tdao.findAllByPriority(priority);
	}

	@Override
	public boolean existsByTId(long tId) {
		return tdao.existsByTId(tId);
	}

	

}
