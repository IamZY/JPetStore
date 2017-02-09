package com.domain;

/**
 * LineitemId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class LineitemId implements java.io.Serializable {

	// Fields

	private Long orderid;
	private String itemid;

	// Constructors

	/** default constructor */
	public LineitemId() {
	}

	/** full constructor */
	public LineitemId(Long orderid, String itemid) {
		this.orderid = orderid;
		this.itemid = itemid;
	}

	// Property accessors

	public Long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LineitemId))
			return false;
		LineitemId castOther = (LineitemId) other;

		return ((this.getOrderid() == castOther.getOrderid()) || (this
				.getOrderid() != null
				&& castOther.getOrderid() != null && this.getOrderid().equals(
				castOther.getOrderid())))
				&& ((this.getItemid() == castOther.getItemid()) || (this
						.getItemid() != null
						&& castOther.getItemid() != null && this.getItemid()
						.equals(castOther.getItemid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrderid() == null ? 0 : this.getOrderid().hashCode());
		result = 37 * result
				+ (getItemid() == null ? 0 : this.getItemid().hashCode());
		return result;
	}

}