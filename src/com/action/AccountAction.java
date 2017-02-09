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
	 * ע���˻�
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
		
		//������Ϣ
		signOnDao.addSignon(signon);
		accountDao.addAccount(account);
		profileDao.addProfile(profile);
		
		//����ϲ����ʾͼƬ
		if(profile.getBanneropt() == 1){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();			
			//ͨ��ϲ�ò�ѯϲ���Ķ���ͼƬ
			String URL = profileDao.findFavAnimalURL(signon.getUserid());
			session.setAttribute("favcategory", URL);		
		}else {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();			
			session.removeAttribute("favcategory");
		}
		
		//���ﳵ�Ƽ���ϲ���ĳ���
		if(profile.getMylistopt() == 1){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.removeAttribute("cateMap");
			//ͨ��userid������ϲ���Ķ���
			String myFavCate = profileDao.findFavCate(signon.getUserid());
			//ͨ����ϲ���Ķ����������������Ʒ������
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
	 * �����˻�
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
		
		//ɾ����Ϣ
		accountDao.delAccount(signon.getUserid());
		signOnDao.delSignon(signon.getUserid());
		profileDao.delProfile(signon.getUserid());

		
		//������Ϣ
		signOnDao.addSignon(signon);
		accountDao.addAccount(account);
		profileDao.addProfile(profile);
		
		
		//����ϲ����ʾͼƬ
		if(profile.getBanneropt() == 1){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			//ɾ��ԭ����ϲ����ͼƬ
			session.removeAttribute("favcategory");
			//ͨ��ϲ�ò�ѯϲ���Ķ���ͼƬ
			String URL = profileDao.findFavAnimalURL(signon.getUserid());
			session.setAttribute("favcategory", URL);			
		}else {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();			
			session.removeAttribute("favcategory");
		}
		
		//���ﳵ�Ƽ���ϲ���ĳ���
		if(profile.getMylistopt() == 1){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.removeAttribute("cateMap");
			//ͨ��userid������ϲ���Ķ���
			String myFavCate = profileDao.findFavCate(signon.getUserid());
			//ͨ����ϲ���Ķ����������������Ʒ������
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
