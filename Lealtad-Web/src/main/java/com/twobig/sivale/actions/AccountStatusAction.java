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
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.beans.AccountStatusBean;
import com.twobig.sivale.service.TReportMovementsService;

@ParentPackage(value = "json-default")
@Namespace("/")
public class AccountStatusAction extends ActionSupport implements SessionAware {
	

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	
	private List<AccountStatusBean> listAccountStatusBean;
	
	@Autowired
	private TReportMovementsService tReportMovementsService;
	
	private static final Logger logger = LogManager.getLogger(AccountStatusAction.class);
	
	@SuppressWarnings("unchecked")
	@Action(value = "getListRMAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListRMAction() {

		TCampaign campaign;
		
		campaign = (TCampaign) session.get("campaign");

		if (campaign == null) {
			logger.info("La campaña es nula");
			return ERROR;
		}
		else{
			logger.info(campaign.toString());
		}
		
		listAccountStatusBean = tReportMovementsService.getAllAccountStatusByCampaignId(campaign.getCampaignId());
		
		return SUCCESS;

	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "getListRMPendingAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListRMPendingAction() {
		
		logger.info("getListRMPendingAction");

		TCampaign campaign;
		
		campaign = (TCampaign) session.get("campaign");

		if (campaign == null) {
			logger.info("La campaña es nula");
			return ERROR;
		}
		else{
			logger.info(campaign.toString());
		}
		
		listAccountStatusBean = tReportMovementsService.getAccountStatusPendingByCampaignId(campaign.getCampaignId());
		
		return SUCCESS;

	}
	
	

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<AccountStatusBean> getListAccountStatusBean() {
		return listAccountStatusBean;
	}

	public void setListAccountStatusBean(List<AccountStatusBean> listAccountStatusBean) {
		this.listAccountStatusBean = listAccountStatusBean;
	}

}
