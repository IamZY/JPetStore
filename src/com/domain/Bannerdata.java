package com.domain;

/**
 * Bannerdata entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Bannerdata implements java.io.Serializable {

	// Fields

	private String favcategory;
	private String bannername;

	// Constructors

	/** default constructor */
	public Bannerdata() {
	}

	/** minimal constructor */
	public Bannerdata(String favcategory) {
		this.favcategory = favcategory;
	}

	/** full constructor */
	public Bannerdata(String favcategory, String bannername) {
		this.favcategory = favcategory;
		this.bannername = bannername;
	}

	// Property accessors

	public String getFavcategory() {
		return this.favcategory;
	}

	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}

	public String getBannername() {
		return this.bannername;
	}

	public void setBannername(String bannername) {
		this.bannername = bannername;
	}

}