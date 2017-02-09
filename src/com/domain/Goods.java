package com.domain;

public class Goods implements java.io.Serializable{
	
	private String itemid;
	private String productid;
	private String attr;
	private long quantity;
	private double price;
	private double totalprice;
	private String name;
	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getAttr() {
		return attr;
	}
	public void setAttr(String attr) {
		this.attr = attr;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(String itemid, String productid, String attr, long quantity,
			double price, double totalprice, String name, String category) {
		super();
		this.itemid = itemid;
		this.productid = productid;
		this.attr = attr;
		this.quantity = quantity;
		this.price = price;
		this.totalprice = totalprice;
		this.name = name;
		this.category = category;
	}
	
	
	
	
	
	
	
}
