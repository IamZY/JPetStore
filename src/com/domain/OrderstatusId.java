package com.domain;

/**
 * OrderstatusId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class OrderstatusId implements java.io.Serializable {

	// Fields

	private Long orderid;
	private Long linenum;

	// Constructors

	/** default constructor */
	public OrderstatusId() {
	}

	/** full constructor */
	public OrderstatusId(Long orderid, Long linenum) {
		this.orderid = orderid;
		this.linenum = linenum;
	}

	// Property accessors

	public Long getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Long getLinenum() {
		return this.linenum;
	}

	public void setLinenum(Long linenum) {
		this.linenum = linenum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderstatusId))
			return false;
		OrderstatusId castOther = (OrderstatusId) other;

		return ((this.getOrderid() == castOther.getOrderid()) || (this
				.getOrderid() != null
				&& castOther.getOrderid() != null && this.getOrderid().equals(
				castOther.getOrderid())))
				&& ((this.getLinenum() == castOther.getLinenum()) || (this
						.getLinenum() != null
						&& castOther.getLinenum() != null && this.getLinenum()
						.equals(castOther.getLinenum())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrderid() == null ? 0 : this.getOrderid().hashCode());
		result = 37 * result
				+ (getLinenum() == null ? 0 : this.getLinenum().hashCode());
		return result;
	}

}