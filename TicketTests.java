package com.verizon.ram;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.ram.model.Priority;
import com.verizon.ram.model.TStatus;
import com.verizon.ram.model.Tickets;
import com.verizon.ram.model.Trtype;
import com.verizon.ram.restapi.ticketApi;
import com.verizon.ram.service.TicketService;
import com.verizon.ram.test.TestUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ticketApi.class)
public class TicketTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private TicketService tsmock;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockMvc = null;
	}

	@Test
	public void testGetAllResources() throws Exception {
		assertThat(this.tsmock).isNotNull();

		List<Tickets> tickList = new ArrayList<>();
		tickList.add(new Tickets());

		when(tsmock.getAllTickets()).thenReturn(tickList);

		mockMvc.perform(get("/tickets")).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	public void testGetResourcesById() throws Exception {
		assertThat(this.tsmock).isNotNull();
		long tid = 13;
	
		Tickets t1 = new Tickets();
		t1.setTid(1);
		t1.setTsub("MONITOR");
		t1.setTdesc("need monitor");

		t1.setUid(10);

		t1.setRid(0);
		t1.setTpriority(Priority.HIGH);
		t1.setTtype(Trtype.HARDWARE);
		t1.setAcmnt("approved");
		t1.setEnd("10:10");
		t1.setMcmnt("thanks");
		t1.setmtime("10:05");
		t1.setStart("10:00");
		when(tsmock.getTicketById(tid)).thenReturn(t1);
	
		mockMvc.perform(get("/tickets/tid/13")).andExpect(status().isOk()).andDo(print());

		
	}
	
	@Test
	public void testAddTicket() throws Exception {
		assertThat(this.tsmock).isNotNull();

		Tickets t1 = new Tickets();
		t1.setTid(1);
		t1.setTsub("MONITOR");
		t1.setTdesc("need monitor");

		t1.setUid(10);

		t1.setRid(0);
		t1.setTpriority(Priority.HIGH);
		t1.setTtype(Trtype.HARDWARE);
		t1.setAcmnt("approved");
		t1.setEnd("10:10");
		t1.setMcmnt("thanks");
		t1.setmtime("10:05");
		t1.setStart("10:00");

		
		System.out.println(t1);
		
		
		Tickets t2 = new Tickets();
		t2.setTid(2);
		t2.setTsub("ROUTER");
		t2.setTdesc("need router");

		t2.setUid(10);

		t2.setRid(0);
		t2.setTpriority(Priority.HIGH);
		t2.setTtype(Trtype.HARDWARE);
		t2.setAcmnt("approved");
		t2.setEnd("10:10");
		t2.setMcmnt("thanks");
		t2.setmtime("10:05");
		t2.setStart("10:00");

		
		when(tsmock.addTicket(Mockito.any(Tickets.class))).thenReturn(t2);

		mockMvc.perform(post("/tickets/addTicket").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(t1))).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));
		
		
	}
	
	
	
	@Test
	public void  testGetTicketByTstatus() throws Exception{
		
		assertThat(this.tsmock).isNotNull();
		
		String ts = "REJECTED";
		List<Tickets> tickList = new ArrayList<>();
		tickList.add(new Tickets());
		TStatus tstatus = TStatus.valueOf(ts);
		when(tsmock.getTicketsByTstatus(ts)).thenReturn(tickList);
		
	}

	
	@Test
	public void  testGetTicketByPriority() throws Exception{
		
		assertThat(this.tsmock).isNotNull();
		
		Priority pr = Priority.LOW;
		List<Tickets> tickList = new ArrayList<>();
		tickList.add(new Tickets());
		when(tsmock.getTicketsByTpriority(pr)).thenReturn(tickList);
		
	}
	
	@Test
	public void  testGetTicketByTrtype() throws Exception{
		
		assertThat(this.tsmock).isNotNull();
		
		Trtype ttype = Trtype.SOFTWARE;
		List<Tickets> tickList = new ArrayList<>();
		tickList.add(new Tickets());
		when(tsmock.getTicketsByTtype(ttype)).thenReturn(tickList);
		
	}
	

}
	
	
	
	
	
	

