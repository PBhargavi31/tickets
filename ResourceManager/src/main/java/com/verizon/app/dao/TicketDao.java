package com.verizon.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.verizon.app.model.Priority;
import com.verizon.app.model.TStatus;
import com.verizon.app.model.Tickets;


@Repository
public interface TicketDao extends JpaRepository<Tickets, Long> {


	/*
	 * to add and get entire list of tickets without any condition, we can use
	 * save() and findAll() methods of Jparepository, hence we need not declare explicitly here.
	 */


	boolean existsByTId(long tid); // to check availability of tickets

	
	boolean existsByUid(long uid);
	
	Optional<Tickets> findByTId(long tId); // to find ticket using ticket Id

	
	Optional<Tickets> findByUid(long uid);
	
	
	List<Tickets> findAllByStatus(TStatus tstatus);   // finding tickets based on status

	List<Tickets> findAllByPriority(Priority priority);  

}
