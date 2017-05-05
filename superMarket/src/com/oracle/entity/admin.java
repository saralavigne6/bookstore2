package com.oracle.entity;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class admin {
	@Id
	@Column(name="username")
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	@Column(name="userpass")
	private String userpass;
	@Column(name="realname")
	private String realname;
	
}
