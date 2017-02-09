package com.action;

import java.util.List;

import com.dao.ProductDao;

public class ProductAction {
	private String category;
	private ProductDao productDao = new ProductDao();
	private List proList;
	private int rows;
	private int currentpages;
	
	public List getProList() {
		return proList;
	}

	public void setProList(List proList) {
		this.proList = proList;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

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


	/**
	 * 查询不同种类的商品信息
	 */
	public String findCategory(){
//		System.out.println("categoryaction....");
//		System.out.println(category);
//		System.out.println(currentpages);
		
		if(currentpages == 0){
			currentpages = 1;
		}
		rows = 3;  //设置每一页显示的个数
		//查询总数，计算出最大页数
		long sum = productDao.countProduct(category);
		
		if(sum%rows == 0){
			if(currentpages > sum/rows){
				currentpages = (int)(sum/rows);
			}
		}else {
			if(currentpages > (sum/rows + 1)){
				currentpages = (int)(sum/rows + 1);
			}
		}
	
		List list = productDao.findCategory(category,rows,currentpages);
	
		proList = list;
		
		return "success";
	}

	
	
	
}
