package com.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.dao.itemDao;

public class ItemAction {
	private String productid;
	private String name;
	private List itemList;
	private String category;
	private itemDao itemDao = new itemDao();
	private int rows;
	private int currentpages;
	
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCurrentpages() {
		return currentpages;
	}

	public void setCurrentpages(int currentpages) {
		this.currentpages = currentpages;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List getItemList() {
		return itemList;
	}

	public void setItemList(List itemList) {
		this.itemList = itemList;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String findItem(){
		//System.out.println(productid);
		//System.out.println(category);
		try {
			name = new String(name.getBytes("ISO8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(name);
		//System.out.println(currentpages);
		if(currentpages == 0){
			currentpages = 1;
		}
		rows = 3;  //设置每一页显示的个数
		//查询每一种类的总数，计算出最大页数
		long sum = itemDao.findCount(productid);
		
		if(sum%rows == 0){
			if(currentpages > sum/rows){
				currentpages = (int)(sum/rows);
			}
		}else {
			if(currentpages > (sum/rows + 1)){
				currentpages = (int)(sum/rows + 1);
			}
		}
		

		List list = itemDao.findItem(productid,rows,currentpages);
		
		itemList = list;
		
		return "success";
	}

	
	
}
