package com.twobig.sivale.actions;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.beans.TUserLogin;

@ParentPackage(value = "json-default")
@Namespace("/")
public class EstatusUserAction extends ActionSupport implements SessionAware{
 
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private static final Logger logger = LogManager.getLogger(EstatusUserAction.class);
	Map<String, Object> reportMap;

	@Action(value = "getUserStatusAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"reportMap", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getUserStatusAction() {
		TUserLogin us = (TUserLogin) session.get("user");
		if(us == null){
			logger.error("No existe una sesión");
			return ERROR; 
		}
		reportMap = new HashMap<>();
		reportMap.put("user", us);
		return SUCCESS; 
	}
	
	public Map<String, Object> getReportMap() {
		return reportMap;
	}

	public void setReportMap(Map<String, Object> reportMap) {
		this.reportMap = reportMap;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
