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
	//每一页的金额
	private double sum;
	private String category;
	private int rows;
	private int currentpages;
	private cartDao cartDao = new cartDao();
	private long quantity;
	private Map cart;
	//商品的总金额
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
			//临时购物车]
			addTempCart();
			return "false";
		}else {
			//永久购物车
			addCartByUserId();
			return "success";
		}
	}
	
	/**
	 * 临时购物车
	 */
	public void addTempCart(){
		//临时购物车
		Map<String, Object> session = ActionContext.getContext().getSession();
		cart = (Map) session.get("cart");
		
		//如果商品没有写入过session 则将商品写入session
		if(cart == null){
			cart = new HashMap();
			session.put("cart", cart);
		}else {
			//判断商品是否在购物车中
			Goods goods = (Goods) cart.get(itemid);
			double sumprice = 0;
			
			if(goods != null){
				goods.setQuantity(goods.getQuantity() + 1);
				goods.setTotalprice(goods.getQuantity()*goods.getPrice());
			}else {
				//商品不存在购物车
				Goods g = new Goods();
				//通过itemid查询商品信息(item+product两表查询)
				List list = cartDao.findTempCart(itemid);   //唯一的itemid
				
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
				
		//遍历session中的cart 获取总金额
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
	 * 永久购物车
	 */
	public void addCartByUserId(){
		System.out.println("addCartByUserId....");
		System.out.println(userid);
		//通过用户编号和商品编号查询商品的数量
		Long quantity = cartDao.findCartCount(userid, itemid);
		
		/**
		 * 如果购物车某一用户不存在商品，增加
		 * 否则更新
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
		rows = 3;  //设置每一页显示的个数
		//查询总数，计算出最大页数
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
							
		//根据userid查询购物车的信息
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
		rows = 3;  //设置每一页显示的个数
		//查询总数，计算出最大页数
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
							
		//根据userid查询购物车的信息
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
			//临时购物车
			Map<String, Object> session = ActionContext.getContext().getSession();
			cart = (Map) session.get("cart");
			if(quantity == 1){
				//删除
				cart.remove(itemid);
				session.put("cart", cart);
			}else {	
				//更新	
				Goods goods = (Goods) cart.get(itemid);		
				goods.setQuantity(goods.getQuantity() - 1);
				goods.setTotalprice(goods.getQuantity()*goods.getPrice());
				cart.put(itemid, goods);
				session.put("cart", cart);
			}
			
			//遍历session中的cart 获取总金额
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
			//永久购物车
			//判断去quantity的数量，数量大于1->数量-1 数量等于1->删掉
			if(quantity == 1){
				//删除
				cartDao.delCart(itemid);
			}else {
				//更新
				cartDao.delUpdateCart(itemid);
			}
				
			return "success";
		}
		
		
		
		
	}
	
	
	
	/**
	 * 显示购物车信息
	 * @return
	 */
	public String showCart(){
		//System.out.println(userid);
		
		if(userid.equals("null")){
			//临时购物车 付款时返回登录界面
			return "false";
		}else {
			//永久购物车
			showMyCart();
			return "success";
		}
				
	}
	
	/**
	 * 永久购物车显示界面
	 */
	public void showMyCart(){
		if(currentpages == 0){
			currentpages = 1;
		}
		rows = 5;  //设置每一页显示的个数
		//查询总数，计算出最大页数
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
		
		
		//根据userid查询购物车的信息
		List list = cartDao.findCart(userid,rows,currentpages);
		//根据userid查询购物车商品总金额
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
