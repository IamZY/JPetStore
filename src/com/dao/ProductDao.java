package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.domain.Product;
import com.hibernate.HibernateSessionFactory;

public class ProductDao {

	/**
	 * 查询每个种类下面的商品信息
	 */
	public List findCategory(String category,int rows,int currentpages){
		System.out.println(category);
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Product where category=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, category);
		
		//分页
		query.setFirstResult((currentpages - 1)*rows);  //设置第一条记录开始的位置
		query.setMaxResults(rows);   //设置返回的纪录总条数
		
		List list = query.list();
		
		session.close();
		return list;
	}
	
	
	/**
	 * 计算每个商品的总数
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
	 * 查询商品的描述
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
	 * 通过最喜欢的动物查找种类下面商品的名称
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
