package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import com.dao.cartDao;
import com.domain.Goods;
import com.opensymphony.xwork2.ActionContext;

public class CartAction {
	private String userid;
	private String itemid;
	private List cartList;
	//ÿһҳ�Ľ��
	private double sum;
	private String category;
	private int rows;
	private int currentpages;
	private cartDao cartDao = new cartDao();
	private long quantity;
	private Map cart;
	//��Ʒ���ܽ��
	private double totalprice;
		
	
	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public Map getCart() {
		return cart;
	}

	public void setCart(Map cart) {
		this.cart = cart;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCurrentpages() {
		return currentpages;
	}

	public void setCurrentpages(int currentpages) {
		this.currentpages = currentpages;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public List getCartList() {
		return cartList;
	}

	public void setCartList(List cartList) {
		this.cartList = cartList;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}



	public String addCart(){
		
		if(userid.equals("null")){
			//��ʱ���ﳵ]
			addTempCart();
			return "false";
		}else {
			//���ù��ﳵ
			addCartByUserId();
			return "success";
		}
	}
	
	/**
	 * ��ʱ���ﳵ
	 */
	public void addTempCart(){
		//��ʱ���ﳵ
		Map<String, Object> session = ActionContext.getContext().getSession();
		cart = (Map) session.get("cart");
		
		//�����Ʒû��д���session ����Ʒд��session
		if(cart == null){
			cart = new HashMap();
			session.put("cart", cart);
		}else {
			//�ж���Ʒ�Ƿ��ڹ��ﳵ��
			Goods goods = (Goods) cart.get(itemid);
			double sumprice = 0;
			
			if(goods != null){
				goods.setQuantity(goods.getQuantity() + 1);
				goods.setTotalprice(goods.getQuantity()*goods.getPrice());
			}else {
				//��Ʒ�����ڹ��ﳵ
				Goods g = new Goods();
				//ͨ��itemid��ѯ��Ʒ��Ϣ(item+product�����ѯ)
				List list = cartDao.findTempCart(itemid);   //Ψһ��itemid
				
				for(int i =0;i<list.size();i++){
					Object[] o = (Object[]) list.get(i);
					g.setItemid((String)o[0]);
					g.setProductid((String)o[1]);
					g.setAttr((String)o[2]);
					g.setName((String)o[3]);
					g.setPrice((Double)o[4]);
					g.setQuantity(1);
					g.setTotalprice(g.getPrice()*g.getQuantity());
					g.setCategory((String)o[5]);
				}
				
				cart.put(itemid, g);
				session.put("cart", cart);
				
			}
			
	
		}
				
		//����session�е�cart ��ȡ�ܽ��
		double sumprice = 0;
		cart = (Map) session.get("cart");
		Iterator ite = cart.entrySet().iterator();
		while(ite.hasNext()){
			Map.Entry entry = (Map.Entry) ite.next();
			Goods goods = (Goods) entry.getValue();
			sumprice += goods.getTotalprice();
			
		}
		sum = sumprice;
		
	}
	
	
	/**
	 * ���ù��ﳵ
	 */
	public void addCartByUserId(){
		System.out.println("addCartByUserId....");
		System.out.println(userid);
		//ͨ���û���ź���Ʒ��Ų�ѯ��Ʒ������
		Long quantity = cartDao.findCartCount(userid, itemid);
		
		/**
		 * ������ﳵĳһ�û���������Ʒ������
		 * �������
		 */
		if(quantity == null){
			quantity = (long)1;
			cartDao.addCart(userid, itemid, quantity);
		}else {
			quantity = quantity + 1;
			cartDao.updateCart(userid, itemid, quantity);
		}
		
		
		if(currentpages == 0){
			currentpages = 1;
		}
		rows = 3;  //����ÿһҳ��ʾ�ĸ���
		//��ѯ��������������ҳ��
		long sumpages = cartDao.countCart(userid);
		
		if(sumpages%rows == 0){
			if(currentpages > sumpages/rows){
				currentpages = (int)(sumpages/rows);
			}
		}else {
			if(currentpages > (sumpages/rows + 1)){
				currentpages = (int)(sumpages/rows + 1);
			}
		}
							
		//����userid��ѯ���ﳵ����Ϣ
		List list = cartDao.findCart(userid,rows,currentpages);
		
		List goodsList = new ArrayList();
		double sumprice = 0;
		for(int i = 0;i < list.size();i++){

			Object[] r = (Object[]) list.get(i);
			sumprice += (Long)r[3]*(Double)r[4];
			goodsList.add(new Goods((String)r[0],(String)r[1],
									(String)r[2],(Long)r[3],
									(Double)r[4],(Long)r[3]*(Double)r[4],
									(String)r[5],(String)r[6]));
		}
		
		cartList = goodsList;
		sum = sumprice;
		
		
	}
	
	public String findCart(){
		//System.out.println(currentpages);
		if(currentpages == 0){
			currentpages = 1;
		}
		rows = 3;  //����ÿһҳ��ʾ�ĸ���
		//��ѯ��������������ҳ��
		long sumpages = cartDao.countCart(userid);
		
		if(sumpages%rows == 0){
			if(currentpages > sumpages/rows){
				currentpages = (int)(sumpages/rows);
			}
		}else {
			if(currentpages > (sumpages/rows + 1)){
				currentpages = (int)(sumpages/rows + 1);
			}
		}
							
		//����userid��ѯ���ﳵ����Ϣ
		List list = cartDao.findCart(userid,rows,currentpages);
		
		
		List goodsList = new ArrayList();
		double sumprice = 0;
		for(int i = 0;i < list.size();i++){

			Object[] r = (Object[]) list.get(i);
			sumprice += (Long)r[3]*(Double)r[4];
			goodsList.add(new Goods((String)r[0],(String)r[1],
									(String)r[2],(Long)r[3],
									(Double)r[4],(Long)r[3]*(Double)r[4],
									(String)r[5],(String)r[6]));
		}
		
		cartList = goodsList;
		sum = sumprice;
		
		return "success";
	}
	
	
	
	
	public String delCart(){
//		System.out.println(userid);
//		System.out.println(itemid);
//		System.out.println(quantity);
		
		
		if(userid.equals("null")){
			//��ʱ���ﳵ
			Map<String, Object> session = ActionContext.getContext().getSession();
			cart = (Map) session.get("cart");
			if(quantity == 1){
				//ɾ��
				cart.remove(itemid);
				session.put("cart", cart);
			}else {	
				//����	
				Goods goods = (Goods) cart.get(itemid);		
				goods.setQuantity(goods.getQuantity() - 1);
				goods.setTotalprice(goods.getQuantity()*goods.getPrice());
				cart.put(itemid, goods);
				session.put("cart", cart);
			}
			
			//����session�е�cart ��ȡ�ܽ��
			double sumprice = 0;
			cart = (Map) session.get("cart");
			Iterator ite = cart.entrySet().iterator();
			while(ite.hasNext()){
				Map.Entry entry = (Map.Entry) ite.next();
				Goods goods = (Goods) entry.getValue();
				sumprice += goods.getTotalprice();
				
			}
			sum = sumprice;
			
				
			return "false";
		}else {
			//���ù��ﳵ
			//�ж�ȥquantity����������������1->����-1 ��������1->ɾ��
			if(quantity == 1){
				//ɾ��
				cartDao.delCart(itemid);
			}else {
				//����
				cartDao.delUpdateCart(itemid);
			}
				
			return "success";
		}
		
		
		
		
	}
	
	
	
	/**
	 * ��ʾ���ﳵ��Ϣ
	 * @return
	 */
	public String showCart(){
		//System.out.println(userid);
		
		if(userid.equals("null")){
			//��ʱ���ﳵ ����ʱ���ص�¼����
			return "false";
		}else {
			//���ù��ﳵ
			showMyCart();
			return "success";
		}
				
	}
	
	/**
	 * ���ù��ﳵ��ʾ����
	 */
	public void showMyCart(){
		if(currentpages == 0){
			currentpages = 1;
		}
		rows = 5;  //����ÿһҳ��ʾ�ĸ���
		//��ѯ��������������ҳ��
		long sumpages = cartDao.countCart(userid);
		
		if(sumpages%rows == 0){
			if(currentpages > sumpages/rows){
				currentpages = (int)(sumpages/rows);
			}
		}else {
			if(currentpages > (sumpages/rows + 1)){
				currentpages = (int)(sumpages/rows + 1);
			}
		}
		
		
		//����userid��ѯ���ﳵ����Ϣ
		List list = cartDao.findCart(userid,rows,currentpages);
		//����userid��ѯ���ﳵ��Ʒ�ܽ��
		double count = cartDao.findTotalPrice(userid);
		List goodsList = new ArrayList();
		double sumprice = 0;
		for(int i = 0;i < list.size();i++){

			Object[] r = (Object[]) list.get(i);
			sumprice += (Long)r[3]*(Double)r[4];
			goodsList.add(new Goods((String)r[0],(String)r[1],
									(String)r[2],(Long)r[3],
									(Double)r[4],(Long)r[3]*(Double)r[4],
									(String)r[5],(String)r[6]));
		}
		
		cartList = goodsList;
		sum = sumprice;
		totalprice = count;	
	}
}
