package com.verizon.app.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.EnumType;

@Entity
@Table(name = "tickets")
public class Tickets {

	@Id
	private long tId;

	private String tSub;
	private String tDesc;
	private long empid;

	@Enumerated
	private TStatus status;

	@Enumerated()
	private Priority priority;
	private String startTime;// time when ticket was raised
	private String actionTime;// approval or rejection timestamp
	private String endTime;// when ticket was compeltely addressed

	public long gettId() {
		return tId;
	}

	public void settId(long tId) {
		this.tId = tId;
	}

	public String gettSub() {
		return tSub;
	}

	public void settSub(String tSub) {
		this.tSub = tSub;
	}

	public String gettDesc() {
		return tDesc;
	}

	public void settDesc(String tDesc) {
		this.tDesc = tDesc;
	}

	public long getEmpid() {
		return empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}

	public TStatus getStatus() {
		return status;
	}

	public void setStatus(TStatus status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getActionTime() {
		return actionTime;
	}

	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Tickets() {
		super();
	}

	public Tickets(long tId, String tSub, String tDesc, long empid, TStatus status, Priority priority, String startTime,
			String actionTime, String endTime) {
		super();
		this.tId = tId;
		this.tSub = tSub;
		this.tDesc = tDesc;
		this.empid = empid;
		this.status = status;
		this.priority = priority;
		this.startTime = startTime;
		this.actionTime = actionTime;
		this.endTime = endTime;
	}

}
