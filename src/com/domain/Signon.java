package com.domain;

/**
 * Signon entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Signon implements java.io.Serializable {

	// Fields

	private String userid;
	private String password;

	// Constructors

	/** default constructor */
	public Signon() {
	}

	/** full constructor */
	public Signon(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}