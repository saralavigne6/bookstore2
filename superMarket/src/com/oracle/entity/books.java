package com.oracle.entity;

import javax.persistence.*;

@Entity
@Table(name="books")
public class books {
	@Id
	@Column(name="booknumber")
	private String booknumber;
	@Column(name="price")
	private float price;
	@Column(name="author")
	private String author;
	@Column(name="copyright")
	private String copyright;
	@Column(name="detail")
	private String detail;
	public String getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(String booknumber) {
		this.booknumber = booknumber;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	@Column(name="total")
	private String total;
	@Column(name="bookname")
	private String bookname;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Column(name="picture")
	private String picture;
}
