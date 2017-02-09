package com.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.dao.ProductDao;
import com.dao.goodsDao;
import com.dao.inventoryDao;
import com.dao.itemDao;

public class GoodsAction {
	private String itemid;
	private String name;
	private String productid;
	private String desn;
	private String attr;
	private long qty;
	private List goodsList;
	private String category;
	
	private itemDao itemDao = new itemDao();
	private ProductDao productDao = new ProductDao();
	private inventoryDao inventoryDao = new inventoryDao();
	
	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesn() {
		return desn;
	}

	public void setDesn(String desn) {
		this.desn = desn;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}

	public long getQty() {
		return qty;
	}

	public void setQty(long qty) {
		this.qty = qty;
	}

	public List getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List goodsList) {
		this.goodsList = goodsList;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public String findGoods(){
		//System.out.println(itemid);
		try {
			name = new String(name.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(name);
		//System.out.println(productid);
		
		String desc = productDao.findDesc(productid);
		desn = desc;
		
		List list = itemDao.findGoods(itemid);
		goodsList = list;
		
		long kc = inventoryDao.findQty(itemid);
		qty = kc;
		
		return "success";
	}

	

	
	
}
