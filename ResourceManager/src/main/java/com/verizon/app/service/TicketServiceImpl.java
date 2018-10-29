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
	public List<Tickets> getTicketsByStatus(String tstatus) {
		tstatus=tstatus.toUpperCase();
		TStatus ts = TStatus.valueOf(tstatus);
		return tdao.findAllByStatus(ts);
	}

	@Override
	public List<Tickets> getTicketsByPriority(Priority priority) {
		
		return tdao.findAllByPriority(priority);
	}

	
	@Override
	public void setStatusById(String status,long tId){
		status=status.toUpperCase();
		TStatus ts = TStatus.valueOf(status);
		Tickets t=tdao.getOne(tId);
		t.setStatus(ts);
		tdao.save(t);
	}

	
	@Override
	public boolean existsByUid(long uid) {
		
		return tdao.existsByUid(uid);
	}

	@Override
	public Tickets getTicketByUid(long uid) {
		
		
		Optional<Tickets> opt = tdao.findByUid(uid);
		return opt.isPresent()?opt.get():null;
		
		
		
		
	}

	@Override
	public boolean existsByTId(long tId) {
		return tdao.existsByTId(tId);
	}
	
	
	

	
	
	
}
