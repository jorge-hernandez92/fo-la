package com.twobig.sivale.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.beans.TUserLogin;

@ParentPackage(value = "json-default")
@Namespace("/")
public class EstatusUserAction extends ActionSupport implements SessionAware, ServletRequestAware{

	 
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private HttpServletRequest request;
	private static final Logger logger = LogManager.getLogger(EstatusUserAction.class);
	private TUserLogin tUser;
	Map<String, Object> reportMap;

	@Action(value = "getUserStatusAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"tUser", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getUserStatusAction() {
		logger.info("getUserStatusAction");
		TUserLogin us = (TUserLogin) session.get("user");
		
		if(us == null){
			return ERROR; 
		}
		
		
		tUser = us;
		
		return SUCCESS; 
	}
	
	

	public TUserLogin gettUser() {
		return tUser;
	}



	public void settUser(TUserLogin tUser) {
		this.tUser = tUser;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

}
