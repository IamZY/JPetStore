package com.domain;

/**
 * Item entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields

	private String itemid;
	private String productid;
	private Double listprice;
	private Double unitcost;
	private Long supplier;
	private String status;
	private String attr1;
	private String attr2;
	private String attr3;
	private String attr4;
	private String attr5;

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(String itemid, String productid) {
		this.itemid = itemid;
		this.productid = productid;
	}

	/** full constructor */
	public Item(String itemid, String productid, Double listprice,
			Double unitcost, Long supplier, String status, String attr1,
			String attr2, String attr3, String attr4, String attr5) {
		this.itemid = itemid;
		this.productid = productid;
		this.listprice = listprice;
		this.unitcost = unitcost;
		this.supplier = supplier;
		this.status = status;
		this.attr1 = attr1;
		this.attr2 = attr2;
		this.attr3 = attr3;
		this.attr4 = attr4;
		this.attr5 = attr5;
	}

	
	
	
	// Property accessors

	public Item(String itemid, String productid, Double listprice, String attr1) {
		super();
		this.itemid = itemid;
		this.productid = productid;
		this.listprice = listprice;
		this.attr1 = attr1;
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public Double getListprice() {
		return this.listprice;
	}

	public void setListprice(Double listprice) {
		this.listprice = listprice;
	}

	public Double getUnitcost() {
		return this.unitcost;
	}

	public void setUnitcost(Double unitcost) {
		this.unitcost = unitcost;
	}

	public Long getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Long supplier) {
		this.supplier = supplier;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttr1() {
		return this.attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return this.attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String getAttr3() {
		return this.attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	public String getAttr4() {
		return this.attr4;
	}

	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}

	public String getAttr5() {
		return this.attr5;
	}

	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}

}