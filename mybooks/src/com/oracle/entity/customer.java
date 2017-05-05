package com.oracle.entity;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class customer {
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="userpass")
	private String userpass;
	@Column(name="tel")
	private String tel;
	@Column(name="email")
	private String email;
}
