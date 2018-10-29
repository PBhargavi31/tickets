package com.verizon.ram.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.verizon.ram.dao.TicketDao;
import com.verizon.ram.model.Hardware;
import com.verizon.ram.model.Priority;
import com.verizon.ram.model.Resourcer;
import com.verizon.ram.model.Rtype;
import com.verizon.ram.model.Software;
import com.verizon.ram.model.TStatus;
import com.verizon.ram.model.Tickets;
import com.verizon.ram.model.Trtype;
import com.verizon.ram.model.Users;

@Component 
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao tdao;
	
	@Autowired
	private UserService uService;
	
	@Override
	public List<Tickets> getAllTickets() {
		return tdao.findAll();//findAll is inbuilt in jpa repo
	}

	@Override
	public void addTicket(Tickets ticket) {
		tdao.save(ticket);//save is inbuilt, to insert or add values
	}


	@Override
	public Tickets getTicketById(long tid) {
		
		Optional<Tickets> opt = tdao.findById(tid);
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
	public void setStatusById(String status,long tid){
		status=status.toUpperCase();
		TStatus ts = TStatus.valueOf(status);
		Tickets t=tdao.getOne(tid);
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
	public boolean existsByTid(long tid) {
		return tdao.existsByTid(tid);
	}

	@Override
	public List<Tickets> getTicketsByTrtype(Trtype type) {
//		type=type.toUpperCase();
//		Trtype trtype = Trtype.valueOf(type);
		return tdao.findAllByTrtype(type);

	}

//	@Override
//	public List<Tickets> getTicketsByHtype(String htype) {	
//		
//		htype=htype.toUpperCase();
//		Hardware ht = Hardware.valueOf(htype);
//		return tdao.findAllByHType(htype)(ht);
//	}
////
//	@Override
//	public List<Tickets> findAllBySwtype(Software swtype) {
//		return tdao.findAllBySwType(swtype);
//	}

//	@Override
//	public List<Tickets> findAllBySwtype(String stype) {
//		stype=stype.toUpperCase();
//		Software sw = Software.valueOf(stype);
//		return tdao.findAllBySwType(sw);	
//		
//	}


//	@Override
//	public Tickets getTicketByMid(long mid) {
//		List<Users> ul= uService.findAllByMid(mid);
//		return null;
//	}
//	
//	
//	

	
	
	
}
