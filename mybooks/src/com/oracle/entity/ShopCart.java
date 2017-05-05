package com.oracle.entity;

import javax.persistence.*;

@Entity
@Table(name="shopcart")
public class ShopCart {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="username")
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(String booknumber) {
		this.booknumber = booknumber;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	@Column(name="booknumber")
	private String booknumber;
	@Column(name="bookname")
	private String bookname;
	@Column(name="price")
	private float price;
	@Column(name="counts")
	private int counts;
	@Column(name="totalMoney")
	private float totalMoney;
	public float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
}
