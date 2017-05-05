package com.oracle.entity;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class employee {
	@Id 
	@Column(name = "username")
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Column(name="userpass")
	private String userpass;
	@Column(name="id")
	private String id;
	@Column(name="tel")
	private String tel;
	@Column(name="realname")
	private String realname;
	@Column(name="salary")
	private float salary;
	
	/*@OneToOne(mappedBy = "employ")
	   public goods good;
	*/
	   
	
}
