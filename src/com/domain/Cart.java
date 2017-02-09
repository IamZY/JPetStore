package com.domain;



/**
 * Cart entity. @author MyEclipse Persistence Tools
 */

public class Cart  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String itemid;
     private Long quantity;
     private String userid;


    // Constructors

    /** default constructor */
    public Cart() {
    }

	/** minimal constructor */
    public Cart(String itemid, String userid) {
        this.itemid = itemid;
        this.userid = userid;
    }
    
    /** full constructor */
    public Cart(String itemid, Long quantity, String userid) {
        this.itemid = itemid;
        this.quantity = quantity;
        this.userid = userid;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getItemid() {
        return this.itemid;
    }
    
    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public Long getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
   








}