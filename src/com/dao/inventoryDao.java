package com.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.HibernateSessionFactory;

public class inventoryDao {

	/**
	 * ≤È—Ø…Ã∆∑ø‚¥Ê
	 */
	public long findQty(String itemid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select qty from Inventory where itemid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, itemid);
		
		long qty = (Long) query.uniqueResult();
		
		session.close();
		return qty;
		
	}
	
	public static void main(String[] args) {
		inventoryDao dao = new inventoryDao();
		System.out.println(dao.findQty("EST-1"));
	}
}
