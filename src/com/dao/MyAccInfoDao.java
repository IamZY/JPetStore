package com.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.domain.MyOrders;
import com.hibernate.HibernateSessionFactory;

public class MyAccInfoDao {

	
	/**
	 * 通过userid查询订单状况
	 */
	public List findMyOrders(String userid){
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select o.orderid,o.orderdate,o.totalprice from Orders o where userid=? order by o.orderid";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		
		List list = query.list();
		
		List myOrderList = new ArrayList();
		for (Object object : list) {
			Object[] o = (Object[]) object;
			//System.out.println(o[0] + ":::" + o[1] + ":::" + o[2]);
		
			myOrderList.add(new MyOrders((Long)o[0],(Date)o[1],(Double)o[2]));
		
		}
		
		session.close();
		return myOrderList;
	}
	
	
	public static void main(String[] args) {
		MyAccInfoDao dao = new MyAccInfoDao();
		List list = dao.findMyOrders("j2ee");
		
		System.out.println(list);
		
		
		for (Object object : list) {
			
			MyOrders myOrders = (MyOrders) object;
			System.out.println(myOrders.getOrderid() + ":::" + myOrders.getDate() + ":::" + myOrders.getTotalprice());
			
			
		}
		
	}
	
}
