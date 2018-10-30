package com.verizon.ram.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long uid;
	
	private String emailid;
	
	private String pwd;
	
	@Enumerated
	private Role role;
	
	private String name;
	
	private long mid;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Users() {
		super();
	}

	public long getMid() {
		return mid;
	}

	public void setMid(long mid) {
		this.mid = mid;
	}

	public Users(long uid, String emailid, String pwd, Role role, String name, long mid) {
		super();
		this.uid = uid;
		this.emailid = emailid;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.mid = mid;
	}

	
	
	
}
