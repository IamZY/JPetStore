package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Signon;
import com.hibernate.HibernateSessionFactory;

public class SignOnDao {

	/**
	 * 验证账号是否存在
	 * @param signon
	 * @return
	 */
	public String findSignOn(Signon signon){
		String result = null;
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from Signon where userid=? and password=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, signon.getUserid());
		query.setParameter(1, signon.getPassword());

		List list = query.list();
		
		if(list.isEmpty()){
			result = "false";
		}else {
			result = "true";
		}
				
		session.close();
		return result;
	}
	
	
	/**
	 * 插入登录表
	 * @param args
	 */
	public void addSignon(Signon signon){
		System.out.println("signon..");
		System.out.println(signon.getUserid());
		System.out.println(signon.getPassword());
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(signon);
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 删除账户
	 * @param userid
	 */
	public void delSignon(String userid){
		System.out.println("delSignon..");
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		try {
			String hql = "delete from Signon where userid=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, userid);
			query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
		}
		
		tx.commit();
		session.close();
	}
	
	
	/**
	 * 通过userid查找账户信息
	 * @param userid
	 * @return
	 */
	public List findMySignon(String userid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from Signon where userid=?";
		Query query = session.createQuery(hql);
		
		query.setParameter(0, userid);
		
		List list = query.list();
		
		session.close();
		return list;
	}
	
	
}
