package com.oracle.entity;

import javax.persistence.*;

@Entity
@Table(name="checks")
public class checks {
	@Id
	@Column(name="checkid")
	private String checkid;   //�����ţ�����
	@Column(name="manager")
	private String manager;   //��������Ա
	public String getCheckid() {
		return checkid;
	}
	public void setCheckid(String checkid) {
		this.checkid = checkid;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBooks() {
		return books;
	}
	public void setBooks(String books) {
		this.books = books;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public float getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(float totalmoney) {
		this.totalmoney = totalmoney;
	}
	@Column(name="username")
	private String username; //�˿��û���
	@Column(name="bname")
	private String bname;   //�ջ�������
	@Column(name="address")
	private String address;   //�ջ��˵�ַ
	@Column(name="tel")
	private String tel;    //�ջ��˵绰����
	@Column(name="books")
	private String books;   //���ﳵ���µ�����Ʒ
	@Column(name="member")
	private String member;   //��Ʒ����
	@Column(name="totalmoney")
	private float totalmoney;   //�ܼ�
	@Column(name="state")
	private int state;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
