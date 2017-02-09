package com.domain;

/**
 * Inventory entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Inventory implements java.io.Serializable {

	// Fields

	private String itemid;
	private Long qty;

	// Constructors

	/** default constructor */
	public Inventory() {
	}

	/** full constructor */
	public Inventory(String itemid, Long qty) {
		this.itemid = itemid;
		this.qty = qty;
	}

	// Property accessors

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public Long getQty() {
		return this.qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

}