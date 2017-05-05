package com.oracle.entity;

import javax.persistence.*;

@Entity
@Table(name="goods")
public class goods {
	@Id
	@Column(name="goodsname")
	private String goodsname;
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="price")
	private float price;
	@Column(name="picture")
	private String picture;
	@Column(name="detail")
	private String detail;
	@Column(name="username")
	private String username;
	@Column(name="total")
	private int total;   //ø‚¥Ê¡ø
	/*@OneToOne
	@JoinColumn(name = "employ_username")
	public employee employ;
	*/
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
