package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Goods;
import com.domain.Lineitem;
import com.domain.Orders;
import com.domain.Orderstatus;
import com.hibernate.HibernateSessionFactory;

public class orderDao {

	
	/**
	 * 根据账号查询账号信息
	 */
	public List findMyAccount(String userid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from Account where userid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		
		List list = query.list();
		
		session.close();
		return list;
	}
		
	/**
	 * 添加订单信息->orders
	 */
	public void addOrders(Orders orders){
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		try {
			
			session.save(orders);
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}
		
		tx.commit();
		session.close();
	}
		
	/**
	 * 查询用户购物车信息
	 */
	public List findMyCart(String userid){
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select i.itemid,i.productid,i.attr1,c.quantity,i.listprice,p.name,p.category from Cart c,Item i,Product p where c.itemid=i.itemid and i.productid=p.productid and c.userid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		
		List list = query.list();
		
		session.close();
		return list;
	}
		
	/**
	 * 清空购物车
	 * @param userid
	 */
	public void delCart(String userid){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "delete from Cart where userid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		
		query.executeUpdate();
		
		tx.commit();
		session.close();
	}
	
	/**
	 * 同步订单状态表
	 */
	public void addOrderStatus(Orderstatus status){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
			
		try {
			
			session.save(status);
			tx.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}
			
	}
	
	/**
	 * 同步单项商品表
	 * @param lineitem
	 */
	public void addLineItem(Lineitem lineitem){
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
			
		try {
			
			session.save(lineitem);
			tx.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 订单中商品的总数
	 */
	public long fingSumQuantity(long orderid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select sum(quantity) from Lineitem where orderid=?";
		Query query = session.createQuery(hql);
		
		query.setParameter(0, orderid);
		long count = (Long)query.uniqueResult();
		
		session.close();
		return count;
	}
	
	
	/**
	 * 通过订单编号查询订单信息
	 * @param orderid
	 * @return
	 */
	public List findOnesOrders(long orderid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from Orders where orderid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, orderid);
		
		List list = query.list();
		
		
		session.close();
		return list;
	}
	
	
	public List findOrderToItem(long orderid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select i.itemid,i.attr1,p.name,l.quantity,l.unitprice " +
				"from Lineitem l,Product p,Item i " +
				"where l.id.itemid=i.itemid and i.productid=p.productid and l.id.orderid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, orderid);
		
		List list = query.list();
		
		
		session.close();
		return list;
	}
	
	
	
	
	
	public static void main(String[] args) {
		orderDao dao = new orderDao();
//		List list = dao.findMyAccount("j2ee");
//		for (Object object : list) {
//			Account account = (Account) object;
//			
//			System.out.println(account.getAddr1());
//			
//			
//		}
		
//		List list = dao.findMyCart("j2ee");
		
//		List cartList = new ArrayList();
//		double sum = 0;
//		for(int i = 0;i < list.size();i++){
//
//			Object[] r = (Object[]) list.get(i);
//			System.out.println(r[0] + ":::" + r[1] + ":::" + r[2] + ":::" + r[3] + ":::" + r[4] + ":::" + r[5] + ":::" + r[6]);
//		
//			sum += (Long)r[3]*(Double)r[4];
//			cartList.add(new Goods((String)r[0],(String)r[1],
//						(String)r[2],(Long)r[3],(Double)r[4],
//						(Long)r[3]*(Double)r[4],(String)r[5],
//						(String)r[6]));
//		
//		}
		
		
		List list = dao.findOrderToItem(34);
		for (Object object : list) {
			Object[] o = (Object[]) object;
			System.out.println(o[0]+":::"+o[1]+":::"+o[2]+":::"+o[3]+":::"+o[4]);
			
			
		}
		
		
	}
}
