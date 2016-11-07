package com.twobig.sivale.actions;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TReportMovements;

@ParentPackage(value = "json-default")
@Namespace("/")
public class AccountStatusAction extends ActionSupport implements SessionAware {
	

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	
	private List<TReportMovements> listTReportMovements;
	
	private static final Logger logger = LogManager.getLogger(AccountStatusAction.class);
	
	@SuppressWarnings("unchecked")
	@Action(value = "getListRMAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listTReportMovements", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListRMAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String campaignJSON = request.getParameter("campaign");

		TCampaign campaign;
		
		campaign = (TCampaign) session.get("campaign");

		if (campaign == null) {
			logger.info("La campaña es nula");
			return ERROR;
		}
		else{
			logger.info(campaign.toString());
		}
		
//		if (!campaignJSON.equals("undefined")) {
//
//			campaign = new TCampaign();
//			try {
//				campaign = new ObjectMapper().readValue(campaignJSON, TCampaign.class);
//			} catch (IOException e) {
//				e.printStackTrace();
//				return ERROR;
//			}
//
//			session.put("campaign", campaign);
//		} else {
//			campaign = (TCampaign) session.get("campaign");
//
//			if (campaign == null) {
//				return ERROR;
//			}
//		}
		
		
		System.out.println("ACTION PARA TENER LISTA DE RM");
		
		return SUCCESS;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<TReportMovements> getListTReportMovements() {
		return listTReportMovements;
	}

	public void setListTReportMovements(List<TReportMovements> listTReportMovements) {
		this.listTReportMovements = listTReportMovements;
	}

}
