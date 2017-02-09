package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.domain.Account;
import com.hibernate.HibernateSessionFactory;

public class accountDao {


	/**
	 * 插入账户表
	 */
	public void addAccount(Account account){
		System.out.println("addAccount..");
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(account);
		tx.commit();
		session.close();
	}
	
	/**
	 * 删除账户信息
	 * @param userid
	 */
	public void delAccount(String userid){
		System.out.println("delAccount..");
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		try {
			String hql = "delete from Account where userid=?";
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
	public List findMyAccount(String userid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from Account where userid=?";
		Query query = session.createQuery(hql);
		
		query.setParameter(0, userid);
		
		List list = query.list();
		
		session.close();
		return list;
	}
	
}
