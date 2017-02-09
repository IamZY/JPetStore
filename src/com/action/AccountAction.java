package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.ProductDao;
import com.dao.SignOnDao;
import com.dao.accountDao;
import com.dao.profileDao;
import com.domain.Account;
import com.domain.Product;
import com.domain.Profile;
import com.domain.Signon;

public class AccountAction {

	private Account account;
	private Signon signon;
	private Profile profile;
	private String userid;
	private SignOnDao signOnDao = new SignOnDao();
	private accountDao accountDao = new accountDao();
	private profileDao profileDao = new profileDao();
	private Map cateMap = new HashMap();
	

	public Map getCateMap() {
		return cateMap;
	}

	public void setCateMap(Map cateMap) {
		this.cateMap = cateMap;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * 注册账户
	 * @return
	 */
	public String register(){
		//System.out.println("register...");
		
		account.setUserid(signon.getUserid());
			
		if(profile.getBanneropt() == null){
			profile.setBanneropt(new Long(0));
		}
		
		if (profile.getMylistopt() == null) {
			profile.setMylistopt(new Long(0));
		}
		
		
		profile.setUserid(signon.getUserid());
		
		//插入信息
		signOnDao.addSignon(signon);
		accountDao.addAccount(account);
		profileDao.addProfile(profile);
		
		//根据喜好显示图片
		if(profile.getBanneropt() == 1){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();			
			//通过喜好查询喜爱的动物图片
			String URL = profileDao.findFavAnimalURL(signon.getUserid());
			session.setAttribute("favcategory", URL);		
		}else {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();			
			session.removeAttribute("favcategory");
		}
		
		//购物车推荐最喜爱的宠物
		if(profile.getMylistopt() == 1){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.removeAttribute("cateMap");
			//通过userid查找最喜欢的动物
			String myFavCate = profileDao.findFavCate(signon.getUserid());
			//通过最喜欢的动物查找种类下面商品的名称
			List list = new ProductDao().findCateToName(myFavCate);
			for (Object object : list) {
				Object[] o = (Object[]) object;
				cateMap.put((String)o[0], new Product((String)o[0],(String)o[2],(String)o[1],null));		
			}
			session.setAttribute("cateMap", cateMap);	
		}else {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.removeAttribute("cateMap");
		}
		
		
		
		return "success";
	}
	
	/**
	 * 更新账户
	 * @return
	 */
	public String updateAcc(){
		
		//System.out.println("updateAcc...");

		account.setUserid(signon.getUserid());
		
		
		if(profile.getBanneropt() == null){
			profile.setBanneropt(new Long(0));
		}
		
		if (profile.getMylistopt() == null) {
			profile.setMylistopt(new Long(0));
		}
		
		profile.setUserid(signon.getUserid());
		
		//删除信息
		accountDao.delAccount(signon.getUserid());
		signOnDao.delSignon(signon.getUserid());
		profileDao.delProfile(signon.getUserid());

		
		//插入信息
		signOnDao.addSignon(signon);
		accountDao.addAccount(account);
		profileDao.addProfile(profile);
		
		
		//根据喜好显示图片
		if(profile.getBanneropt() == 1){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			//删除原来的喜爱的图片
			session.removeAttribute("favcategory");
			//通过喜好查询喜爱的动物图片
			String URL = profileDao.findFavAnimalURL(signon.getUserid());
			session.setAttribute("favcategory", URL);			
		}else {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();			
			session.removeAttribute("favcategory");
		}
		
		//购物车推荐最喜爱的宠物
		if(profile.getMylistopt() == 1){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.removeAttribute("cateMap");
			//通过userid查找最喜欢的动物
			String myFavCate = profileDao.findFavCate(signon.getUserid());
			//通过最喜欢的动物查找种类下面商品的名称
			List list = new ProductDao().findCateToName(myFavCate);
			for (Object object : list) {
				Object[] o = (Object[]) object;
				cateMap.put((String)o[0], new Product((String)o[0],(String)o[2],(String)o[1],null));		
			}
			session.setAttribute("cateMap", cateMap);	
		}else {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.removeAttribute("cateMap");
		}
		
		return "success";
	}
	
	
	public String findMyAcc(){
		System.out.println(userid);
		
		signon = (Signon) signOnDao.findMySignon(userid).get(0);
		account = (Account) accountDao.findMyAccount(userid).get(0);
		profile = (Profile) profileDao.findMyProfile(userid).get(0);
		
		return "success";
	}
	
}
