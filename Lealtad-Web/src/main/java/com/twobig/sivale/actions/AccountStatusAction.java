package com.twobig.sivale.actions;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.beans.AccountStatusBean;
import com.twobig.sivale.beans.AccountStatusFilterBean;
import com.twobig.sivale.service.TReportMovementsService;
import com.twobig.sivale.utils.ExportReport;

@ParentPackage(value = "json-default")
@Namespace("/")
public class AccountStatusAction extends ActionSupport implements SessionAware {
	

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	
	private List<AccountStatusBean> listAccountStatusBean;
	
	Map<String, Object> reportMap;
	
	@Autowired
	private TReportMovementsService tReportMovementsService;
	
	private static final Logger logger = LogManager.getLogger(AccountStatusAction.class);
	
	@SuppressWarnings("unchecked")
	@Action(value = "getListRMAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListRMAction() {
		
		TUser user;
		
		user = (TUser) session.get("user");
		
		if(user == null){
			return ERROR; 
		}

		listAccountStatusBean = tReportMovementsService.getAllAccountStatusByCompanyId(user.getCompany());
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "getListRMPendingAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListRMPendingAction() {
		
		logger.info("getListRMPendingAction");
		
		TUser user;
		
		user = (TUser) session.get("user");
		
		if(user == null){
			return ERROR; 
		}
		
		listAccountStatusBean = tReportMovementsService.getAccountStatusPendingByCompanyId(user.getCompany());
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "getListRMNoPendingAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListRMNoPendingAction() {
		
		logger.info("getListRMNoPendingAction");
		
		TUser user;
		
		user = (TUser) session.get("user");
		
		if(user == null){
			return ERROR; 
		}
		
		listAccountStatusBean = tReportMovementsService.getAccountStatusWithoutPendingByCompanyId(user.getCompany());
		
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "searchAccountStatusAdminAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String searchAccountStatusAdminAction() {
		
		logger.info("searchAccountStatusAdminAction");
		
		final HttpServletRequest request = ServletActionContext.getRequest();

		TUser user;
		
		user = (TUser) session.get("user");
		
		if(user == null){
			return ERROR; 
		}
		
		String searchAccountStatusJSON = request.getParameter("searchAccountStatusvar");
		
		AccountStatusFilterBean accountStatusFilterBean; 
		
		if(!searchAccountStatusJSON.equals("undefined")){
			accountStatusFilterBean = new AccountStatusFilterBean();
			
			try {
				
				accountStatusFilterBean = new ObjectMapper().readValue(searchAccountStatusJSON, AccountStatusFilterBean.class);
				logger.info(accountStatusFilterBean.toString());
				listAccountStatusBean = tReportMovementsService.getAccountStatusByCompanyIdAndFilter(user.getCompany(), accountStatusFilterBean);
				
				for (AccountStatusBean accountStatusBean : listAccountStatusBean) {
					logger.info(accountStatusBean.toString());
				}
				
		
			} catch (IOException e) {
				
				e.printStackTrace();
				return ERROR; 	
			}
			
		}
		else{
			logger.info("ERROR EN EL JSON");
		}
		
		return SUCCESS; 
	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "getRMXLSPendingAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"reportMap", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getRMXLSPendingAction() {
		
		logger.info("getRMXLSPendingAction");
		
		TUser user;
		
		user = (TUser) session.get("user");
		
		if(user == null){
			return ERROR; 
		}
		
		reportMap = new HashMap<>();
		
		listAccountStatusBean = tReportMovementsService.getAccountStatusPendingByCompanyId(user.getCompany());
		
		String[] cabecera 		=  {"Nombre de la Campaña", "Nombre", "ID STARS", "Compañia", "BID", "Monto", "Movimiento", "Observaciones" };
		String[] atributos 		=  {"campaignName",			"nombre", "idStars",  "compania", "bid", "monto", "movements",  "observaciones"};
		String nombreArchivo 	=  "Reporte_de_Movimientos";
		
		List<Object> objectList = new ArrayList<Object>(listAccountStatusBean);
		
		byte[] reportFileBytes = null;
		
		try {
			
			reportFileBytes = ExportReport.exportReportToFile(objectList, cabecera, atributos, nombreArchivo,"1", nombreArchivo);
			reportMap.put("valueCode", reportFileBytes);
			reportMap.put("resultCode", "100");
			reportMap.put("fileName", nombreArchivo);
			
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | IOException e) {
			
			e.printStackTrace();
		} finally{
			
		}
		
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

	public List<AccountStatusBean> getListAccountStatusBean() {
		return listAccountStatusBean;
	}

	public void setListAccountStatusBean(List<AccountStatusBean> listAccountStatusBean) {
		this.listAccountStatusBean = listAccountStatusBean;
	}

}
