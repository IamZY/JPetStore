package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.domain.Item;
import com.hibernate.HibernateSessionFactory;

public class itemDao {

	/**
	 * 查询每个种类下的商品信息
	 */
	public List findItem(String productid,int rows,int currentpages){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from Item where productid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, productid);
		
		//分页
		query.setFirstResult((currentpages - 1)*rows);  //设置第一条记录开始的位置
		query.setMaxResults(rows);   //设置返回的纪录总条数
		
		
		List list = query.list();
		
		session.close();
		return list;
	}
	
	
	public List findGoods(String itemid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from Item where itemid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, itemid);
		
		List list = query.list();
		
		session.close();
		return list;
	}
	
	
	/**
	 * 查询某一种类下商品个数
	 * @param productid
	 * @return
	 */
	public long findCount(String productid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select count(*) from Item where productid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, productid);
		
		long sum = (Long)query.uniqueResult();
		
		session.close();
		return sum;
	}
	
	
	
	
	public static void main(String[] args) {
		itemDao dao = new itemDao();
		List list = dao.findItem("K9-BD-01",1,1);
	
		for(Object o : list){
			Item i = (Item) o;
			System.out.println(i.getItemid() + ":::" + i.getAttr1() + ":::" + i.getListprice());
		}
	
		//System.out.println(dao.findCount("K9-BD-01"));
	}
}
