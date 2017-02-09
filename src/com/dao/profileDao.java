package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.domain.Profile;
import com.hibernate.HibernateSessionFactory;

public class profileDao {

	/**
	 * 插入个人爱好表
	 */
	public void addProfile(Profile profile){
		System.out.println("addProfile..");
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(profile);
		tx.commit();
		session.close();
	}
	
	/**
	 * 删除个人爱好表
	 * @param userid
	 */
	public void delProfile(String userid){
		System.out.println("delProfile..");
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();

		try {
			String hql = "delete from Profile where userid=?";
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
	 * 通过userid查找个人爱好表
	 * @param userid
	 * @return
	 */
	public List findMyProfile(String userid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from Profile where userid=?";
		Query query = session.createQuery(hql);
		
		query.setParameter(0, userid);
		
		List list = query.list();
		
		session.close();
		return list;
	}
	
	
	public String findFavAnimalURL(String userid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select b.bannername from Bannerdata b,Profile p where b.favcategory=p.favcategory and userid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		
		String URL = (String) query.uniqueResult();
		
		session.close();
		return URL;
	}
	
	
	public String findFavCate(String userid){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select p.favcategory from Profile p where p.userid=?";
		Query query = session.createQuery(hql);
		
		query.setParameter(0, userid);
		String favCate = (String) query.uniqueResult();
		
		session.close();
		return favCate;
	}
	
	
	
	
	public static void main(String[] args) {
		profileDao dao = new profileDao();
//		System.out.println(dao.findFavAnimalURL("j2ee"));
		System.out.println(dao.findFavCate("j2ee"));
	}
	
}
