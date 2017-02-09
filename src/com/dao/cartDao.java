package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Cart;
import com.domain.Goods;
import com.domain.Item;
import com.hibernate.HibernateSessionFactory;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class cartDao {

	/**
	 * 将商品加入购物车
	 */
	public void addCart(String userid,String itemid,long quantity){
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		try {

			Cart cart = new Cart();
			cart.setItemid(itemid);
			cart.setUserid(userid);
			cart.setQuantity(quantity);
			
			session.save(cart);
			
			tx.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 增加:更新购物车
	 */
	public void updateCart(String userid,String itemid,long quantity){
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		try {
			String hql = "update Cart set quantity = ? where userid=? and itemid=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, quantity);
			query.setParameter(1, userid);
			query.setParameter(2, itemid);

			query.executeUpdate();
			
			tx.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过用户编号和商品编号查询数量信息
	 */
	public Long findCartCount(String userid,String itemid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select quantity from Cart where userid=? and itemid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		query.setParameter(1, itemid);
		
		Long count = (Long)query.uniqueResult();
		
		session.close();
		return count;
	
	}
	
	
	/**
	 * 根据userid查询购物车信息 两表查询
	 * @param args
	 */
	public List findCart(String userid,int rows,int currentpages){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select i.itemid,i.productid,i.attr1,c.quantity,i.listprice,p.name,p.category from Cart c,Item i,Product p where c.itemid=i.itemid and i.productid=p.productid and c.userid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		
		//分页
		query.setFirstResult((currentpages - 1)*rows);  //设置第一条记录开始的位置
		query.setMaxResults(rows);   //设置返回的纪录总条数
		
		
		List list = query.list();
		
		session.close();
		return list;
	}
	
	
	/**
	 * 查询购物车总数
	 * @param args
	 */
	public long countCart(String userid){
		
		Session session = HibernateSessionFactory.getSession();
		String hql = "select count(*) from Cart where userid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		
		Long sum = (Long) query.uniqueResult();
		
		session.close();
		return sum;
	}
		
	
	/**
	 * 删除
	 */
	public void delCart(String itemid){
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
			
		try {
			
			String hql = "delete from Cart where itemid=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, itemid);
			
			query.executeUpdate();
			
			tx.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 删除：更新购物车
	 */
	public void delUpdateCart(String itemid){
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		try {
			String hql = "update Cart set quantity=quantity-1 where itemid=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, itemid);

			query.executeUpdate();
			
			tx.commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}
	
	}
	
	
	/**
	 * 临时购物车：两表查询
	 */
	public List findTempCart(String itemid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select i.itemid,i.productid,i.attr1,p.name,i.listprice,p.category from Product p,Item i where i.productid = p.productid and itemid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, itemid);
		
		List list = query.list();
		
		session.close();
		return list;
	}
	
	
	/**
	 * 查询购物车商品总金额
	 * @param userid
	 * @return
	 */
	public double findTotalPrice(String userid){
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select i.listprice,c.quantity from Cart c,Item i where c.itemid=i.itemid and c.userid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
				
		List list = query.list();
		double totalprice = 0;
		for(int i =0;i<list.size();i++){
			Object[] o = (Object[]) list.get(i);
			totalprice += (Double)o[0]*(Long)o[1];
		}
		
		session.close();
		return totalprice;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		cartDao dao = new cartDao();
		
		//System.out.println(dao.findCartCount("j2ee", "EST-1"));
	
		//dao.addCart("j2ee", "EST-3", 1);
		//dao.updateCart("j2ee", "EST-1", 2);
		//dao.delCart("EST-1");
//		dao.delUpdateCart("EST-6");
//		List list = dao.findCart("j2ee",3,2);
//		System.out.println(dao.countCart("j2ee"));
//		/*for (Object object : list) {
//			//Item i = (Item)object;
//			Object[] r = (Object[]) object;
//			System.out.println(r[0] + ":::" + r[1] + ":::" + r[2] + ":::" + r[3] + ":::" + r[4]);
//			//System.out.println(i.getProductid() + ":::" + i.getAttr1());		
//		}*/
//		
//		//System.out.println(list.size());
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
//		
//		System.out.println(sum);
//		
//		System.out.println("-------------------");
//		for(Object o : cartList){
//			Goods i = (Goods) o;
//			System.out.println(i.getItemid() + ":::" + i.getAttr() + 
//					":::" + i.getProductid() + ":::" + i.getQuantity() + 
//					":::" + i.getPrice() + ":::" + i.getTotalprice() + 
//					":::" + i.getName() + ":::" +i.getCategory());
//			
//		}
		
//		List list = dao.findTempCart("EST-1");
//		for(int i = 0;i<list.size();i++){
//			Object[] o = (Object[]) list.get(i);
//			System.out.println(o[0] + ":::" + o[1] + ":::" + o[2] + ":::" + o[3] + ":::" + o[4] + ":::" + o[5]);
//		}
//		double totalprice = 0;
//		List list = dao.findTotalPrice("j2ee");
//		for(int i =0;i<list.size();i++){
//			Object[] o = (Object[]) list.get(i);
//		//	System.out.println(o[0] + ":::" + o[1]);
//			totalprice += (Double)o[0]*(Long)o[1];
//		}
//		
		System.out.println(dao.findTotalPrice("j2ee"));
		
	}
}
