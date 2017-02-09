package com.action;

import java.util.List;

import com.dao.MyAccInfoDao;

public class MyAccInfoAction {
	private String userid;
	private List myorderList;
	private MyAccInfoDao myAccInfoDao = new MyAccInfoDao();
	
	
	
	public List getMyorderList() {
		return myorderList;
	}

	public void setMyorderList(List myorderList) {
		this.myorderList = myorderList;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}





	public String findMyOrders(){
		System.out.println(userid);
		
		List list = myAccInfoDao.findMyOrders(userid);
		
		myorderList = list;
		
		return "success";
	}
}
