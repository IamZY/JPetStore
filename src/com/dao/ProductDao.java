package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.domain.Product;
import com.hibernate.HibernateSessionFactory;

public class ProductDao {

	/**
	 * ��ѯÿ�������������Ʒ��Ϣ
	 */
	public List findCategory(String category,int rows,int currentpages){
		System.out.println(category);
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Product where category=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, category);
		
		//��ҳ
		query.setFirstResult((currentpages - 1)*rows);  //���õ�һ����¼��ʼ��λ��
		query.setMaxResults(rows);   //���÷��صļ�¼������
		
		List list = query.list();
		
		session.close();
		return list;
	}
	
	
	/**
	 * ����ÿ����Ʒ������
	 * @param args
	 */
	public long countProduct(String category){
		
		Session session = HibernateSessionFactory.getSession();
		String hql = "select count(*) from Product where category=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, category);
		
		Long sum = (Long) query.uniqueResult();
		
		session.close();
		return sum;
	}
	
	/**
	 * ��ѯ��Ʒ������
	 * @param args
	 */
	public String findDesc(String productid){
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select descn from Product where productid=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, productid);
		
		String descn = (String) query.uniqueResult();
		
		session.close();
		return descn;
	}
	
	
	/**
	 * ͨ����ϲ���Ķ����������������Ʒ������
	 */
	public List findCateToName(String category){
		
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "select p.productid,p.name,p.category from Product p where p.category=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, category);
		
		List list = query.list();
		
		session.close();
		return list;
	}
	
	
	
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		/*List list = dao.findCategory("FISH",3,1);
		
		for(Object o : list){	
			Product product = (Product) o;
			System.out.println(product.getProductid() + ":::" + product.getName());
		}*/
		//System.out.println(dao.countProduct("FISH"));
		
		//System.out.println(6%3);
		//System.out.println(dao.findDesc("AV-CB-01"));
		
		List list = dao.findCateToName("FISH");
		for (Object object : list) {
			Object[] o = (Object[]) object;
			System.out.println(o[0] + ":::" + o[1] + ":::" + o[2]);
		}
		
		
	}
}
