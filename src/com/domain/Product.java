package com.domain;

/**
 * Product entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private String productid;
	private String category;
	private String name;
	private String descn;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String productid, String category) {
		this.productid = productid;
		this.category = category;
	}

	/** full constructor */
	public Product(String productid, String category, String name, String descn) {
		this.productid = productid;
		this.category = category;
		this.name = name;
		this.descn = descn;
	}

	// Property accessors

	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescn() {
		return this.descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

}