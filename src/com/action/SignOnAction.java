package com.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.ProductDao;
import com.dao.SignOnDao;
import com.dao.profileDao;
import com.domain.Product;
import com.domain.Signon;

public class SignOnAction {
	
	private Signon signon;
	private InputStream ajaxInputStream;
	private SignOnDao dao = new SignOnDao();
	private profileDao profileDao = new profileDao();
	private Map cateMap = new HashMap();
	
	public Map getCateMap() {
		return cateMap;
	}

	public void setCateMap(Map cateMap) {
		this.cateMap = cateMap;
	}

	public InputStream getAjaxInputStream() {
		return ajaxInputStream;
	}

	public void setAjaxInputStream(InputStream ajaxInputStream) {
		this.ajaxInputStream = ajaxInputStream;
	}

	public SignOnAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}
	
	
	
	public String sign(){
		String result=null;
			
		//查询数据库
		result = dao.findSignOn(signon);
		
		System.out.println("账号验证结果->" + result);
		
		if(result.equals("true")){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("userid", signon.getUserid());		
			//通过喜好查询喜爱的动物图片
			String URL = profileDao.findFavAnimalURL(signon.getUserid());
			session.setAttribute("favcategory", URL);
			
			//通过userid查找最喜欢的动物
			String myFavCate = profileDao.findFavCate(signon.getUserid());
			//通过最喜欢的动物查找种类下面商品的名称
			List list = new ProductDao().findCateToName(myFavCate);
			for (Object object : list) {
				Object[] o = (Object[]) object;
				cateMap.put((String)o[0], new Product((String)o[0],(String)o[2],(String)o[1],null));		
			}
			session.setAttribute("cateMap", cateMap);			
		}
	
		ajaxInputStream = new StringBufferInputStream(result);
		
		return "success";
	}
	
	public String exit(){
		System.out.println("exit..");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("userid");	
		session.removeAttribute("favcategory");
		return "success";
	}
	
	
	
}
