package com.domain;

import java.util.Date;


public class MyOrders implements java.io.Serializable{

	private long orderid;
	private Date date;
	private double totalprice;
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public MyOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyOrders(long orderid, Date date, double totalprice) {
		super();
		this.orderid = orderid;
		this.date = date;
		this.totalprice = totalprice;
	}
	
	
	
	
	
	
	
}
