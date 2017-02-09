package com.domain;

/**
 * Lineitem entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Lineitem implements java.io.Serializable {

	// Fields

	private LineitemId id;
	private Long quantity;
	private Double unitprice;

	// Constructors

	/** default constructor */
	public Lineitem() {
	}

	/** full constructor */
	public Lineitem(LineitemId id, Long quantity, Double unitprice) {
		this.id = id;
		this.quantity = quantity;
		this.unitprice = unitprice;
	}

	// Property accessors

	public LineitemId getId() {
		return this.id;
	}

	public void setId(LineitemId id) {
		this.id = id;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

}