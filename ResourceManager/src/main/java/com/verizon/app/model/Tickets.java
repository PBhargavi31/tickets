package com.verizon.app.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.EnumType;

@Entity
@Table(name = "tickets")
public class Tickets {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tId;

	private String tsub;
	private String tdesc;
	private long uid;

	@Enumerated
	private TStatus status;

	@Enumerated()
	private Priority priority;
	private String startTime;// time when ticket was raised
	private String mTime;// approval or rejection timestamp
	private String endTime;// when ticket was compeltely addressed

	public long gettId() {
		return tId;
	}

	public void settId(long tId) {
		this.tId = tId;
	}

	


	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
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

	
	public String getTsub() {
		return tsub;
	}

	public void setTsub(String tsub) {
		this.tsub = tsub;
	}

	public String getTdesc() {
		return tdesc;
	}

	public void setTdesc(String tdesc) {
		this.tdesc = tdesc;
	}

	public String getmTime() {
		return mTime;
	}

	public void setmTime(String mTime) {
		this.mTime = mTime;
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

	public Tickets(long tId, String tsub, String tdesc, long uid, TStatus status, Priority priority, String startTime,
			String mTime, String endTime) {
		super();
		this.tId = tId;
		this.tsub = tsub;
		this.tdesc = tdesc;
		this.uid = uid;
		this.status = status;
		this.priority = priority;
		this.startTime = startTime;
		this.mTime = mTime;
		this.endTime = endTime;
	}

}
