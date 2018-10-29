package com.verizon.ram.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tickets")
public class Tickets {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tid;

	private String tsub;
	private String tdesc;
	private long uid;
	@Enumerated(EnumType.STRING)
	private TStatus status;

	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@Enumerated(EnumType.STRING)
	private Trtype trtype;
	
	@Enumerated(EnumType.STRING)
	private Hardware hard;
	
	@Enumerated(EnumType.STRING)
	private Software soft;

	private String startTime;// time when ticket was raised
	private String mTime;// approval or rejection timestamp
	private String endTime;// when ticket was compeltely addressed

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
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

	public Trtype getTrtype() {
		return trtype;
	}

	public void setTrtype(Trtype trtype) {
		this.trtype = trtype;
	}

	public Hardware getHard() {
		return hard;
	}

	public void setHard(Hardware hard) {
		this.hard = hard;
	}

	public Software getSoft() {
		return soft;
	}

	public void setSoft(Software soft) {
		this.soft = soft;
	}

	public Tickets() {
		super();
	}

	public Tickets(long tid, String tsub, String tdesc, long uid, TStatus status, Priority priority, Trtype trtype,
			Hardware hard, Software soft, String startTime, String mTime, String endTime) {
		super();
		this.tid = tid;
		this.tsub = tsub;
		this.tdesc = tdesc;
		this.uid = uid;
		this.status = status;
		this.priority = priority;
		this.trtype = trtype;
		this.hard = hard;
		this.soft = soft;
		this.startTime = startTime;
		this.mTime = mTime;
		this.endTime = endTime;
	}

	
	

}
