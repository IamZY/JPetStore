package com.domain;

/**
 * Profile entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Profile implements java.io.Serializable {

	// Fields

	private String userid;
	private String langpref;
	private String favcategory;
	private Long mylistopt;
	private Long banneropt;

	// Constructors

	/** default constructor */
	public Profile() {
	}

	/** minimal constructor */
	public Profile(String userid, String langpref) {
		this.userid = userid;
		this.langpref = langpref;
	}

	/** full constructor */
	public Profile(String userid, String langpref, String favcategory,
			Long mylistopt, Long banneropt) {
		this.userid = userid;
		this.langpref = langpref;
		this.favcategory = favcategory;
		this.mylistopt = mylistopt;
		this.banneropt = banneropt;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLangpref() {
		return this.langpref;
	}

	public void setLangpref(String langpref) {
		this.langpref = langpref;
	}

	public String getFavcategory() {
		return this.favcategory;
	}

	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}

	public Long getMylistopt() {
		return this.mylistopt;
	}

	public void setMylistopt(Long mylistopt) {
		this.mylistopt = mylistopt;
	}

	public Long getBanneropt() {
		return this.banneropt;
	}

	public void setBanneropt(Long banneropt) {
		this.banneropt = banneropt;
	}

}