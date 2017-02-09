package com.action;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import antlr.collections.impl.LList;

import com.dao.orderDao;
import com.domain.Account;
import com.domain.Goods;
import com.domain.Lineitem;
import com.domain.LineitemId;
import com.domain.Orders;
import com.domain.Orderstatus;
import com.domain.OrderstatusId;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;

public class OrderAction {
	private String userid;
	private double totalprice;
	private List accList;
	private Orders orders;
	private orderDao orderDao = new orderDao();
	private List myCartList;
	
	public List getMyCartList() {
		return myCartList;
	}

	public void setMyCartList(List myCartList) {
		this.myCartList = myCartList;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public List getAccList() {
		return accList;
	}

	public void setAccList(List accList) {
		this.accList = accList;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}



	/**
	 * ��ѯ�˻���Ϣ
	 * @return
	 */
	public String showOrderAccount(){
		
		List list = orderDao.findMyAccount(userid);
		
		accList = list;
		
		return "success";
	}
	
	/**
	 * ���Ӷ���
	 * @return
	 */
	public String addOrder(){
		System.out.println("addOrders...");

		List list = orderDao.findMyAccount(orders.getUserid());
		for(int i =0;i<list.size();i++){
			
			Account acc = (Account) list.get(i);
			//�ջ��˵���Ϣ
			orders.setShipaddr1(acc.getAddr1());
			orders.setShipaddr2(acc.getAddr2());
			orders.setShipcity(acc.getCity());
			orders.setShipcountry(acc.getCountry());
			orders.setShipzip(acc.getZip());
			orders.setShiptofirstname(acc.getFirstname());
			orders.setShipstate(acc.getState());
		}
		
		orders.setCourier("EMS");
		
		//��ȡϵͳ��ǰ����
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String nowdate = dateFormat.format(now);
		
		try {
			Date date = dateFormat.parse(nowdate);
			orders.setOrderdate(date);
			
			//��Ӷ�����Ϣ->orders
			orderDao.addOrders(orders);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//��ѯĳ�û��Ĺ��ﳵ��Ʒ
		List myList = orderDao.findMyCart(orders.getUserid());
		
		List cartList = new ArrayList();
		double sum = 0;
		for(int i = 0;i < myList.size();i++){
			Object[] r = (Object[]) myList.get(i);
			cartList.add(new Goods((String)r[0],(String)r[1],
						(String)r[2],(Long)r[3],(Double)r[4],
						(Long)r[3]*(Double)r[4],(String)r[5],
						(String)r[6]));
			
			//ͬ��������Ʒ��
			orderDao.addLineItem(new Lineitem(new LineitemId(orders.getOrderid(),(String)r[0]),(Long)r[3],(Double)r[4]));
		}
//		System.out.println("ordersid->" + orders.getOrderid());
		
		myCartList = cartList;
		
		//ͬ�����Ӷ���״̬��
		orderDao.addOrderStatus(new Orderstatus(new OrderstatusId(orders.getOrderid(),orderDao.fingSumQuantity(orders.getOrderid())),orders.getOrderdate(),"P") );
		
		//�����������û����ﳵ���
		orderDao.delCart(orders.getUserid());
		
		return "success";
	}
	

	public String findOnesOrders(){
		System.out.println("findOnesOrders....");
		System.out.println(orders.getOrderid());
		
		//ͨ��������Ų�ѯ������Ϣ
		List list = orderDao.findOnesOrders(orders.getOrderid());
		
		orders = (Orders) list.get(0);
		
		//ͨ��������Ų�ѯ��������Ʒ��Ϣ
		List orderList = orderDao.findOrderToItem(orders.getOrderid());
		
		
		List cartList = new ArrayList();
		double sum = 0;
		for(int i = 0;i < orderList.size();i++){
			Object[] r = (Object[]) orderList.get(i);
			cartList.add(new Goods((String)r[0],null,(String)r[1],(Long)r[3],(Double)r[4],(Long)r[3]*(Double)r[4],(String)r[2],null));
			
		}
		
		myCartList = cartList;
				
		return "success";
	}
	
	
}
