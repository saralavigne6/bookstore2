package com.oracle.entity;

import javax.persistence.*;


@Entity
@Table(name="sales")
public class sales {
	@Id@GeneratedValue
	@Column(name="id")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="username")
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getSalesmoney() {
		return salesmoney;
	}
	public void setSalesmoney(float salesmoney) {
		this.salesmoney = salesmoney;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	@Column(name="salesmoney")
	private float salesmoney;
	@Column(name="dates")
	private String dates;
}
