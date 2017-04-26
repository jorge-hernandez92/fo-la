package com.twobig.sivale.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
import org.apache.struts2.interceptor.ServletRequestAware;
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
public class AccountStatusAction extends ActionSupport implements SessionAware, ServletRequestAware {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private List<AccountStatusBean> listAccountStatusBean;
	Map<String, Object> reportMap;
	
	@Autowired
	private TReportMovementsService tReportMovementsService;
	private static final Logger logger = LogManager.getLogger(AccountStatusAction.class);
	private HttpServletRequest request;
	
	@Action(value = "getListRMAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListRMAction() {
		TUser user;
		user = (TUser) session.get("user");
		if(user == null){
			logger.error("No existe una sesión");
			return ERROR; 
		}
		listAccountStatusBean = tReportMovementsService.getAllAccountStatusByCompanyId(user.getCompany(), null);
		return SUCCESS;
	}
	
	@Action(value = "getListRMPendingAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListRMPendingAction() {
		TUser user;
		user = (TUser) session.get("user");
		if(user == null){
			logger.error("No existe una sesión");
			return ERROR; 
		}
		listAccountStatusBean = tReportMovementsService.getAccountStatusPendingByCompanyId(user.getCompany(), null);
		return SUCCESS;
	}
	
	@Action(value = "getListRMNoPendingAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListRMNoPendingAction() {
		TUser user;
		user = (TUser) session.get("user");
		if(user == null){
			logger.error("No existe una sesión");
			return ERROR; 
		}
		listAccountStatusBean = tReportMovementsService.getAccountStatusWithoutPendingByCompanyId(user.getCompany(), null);
		return SUCCESS;
	}
	
	
	@Action(value = "searchAccountStatusAdminAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String searchAccountStatusAdminAction() {
		final HttpServletRequest request = ServletActionContext.getRequest();
		TUser user;
		user = (TUser) session.get("user");
		if(user == null){
			logger.error("No existe una sesión");
			return ERROR; 
		}
		String searchAccountStatusJSON = request.getParameter("searchAccountStatusvar");
		AccountStatusFilterBean accountStatusFilterBean; 
		if(!searchAccountStatusJSON.equals("undefined")){
			accountStatusFilterBean = new AccountStatusFilterBean();
			try {
				accountStatusFilterBean = new ObjectMapper().readValue(searchAccountStatusJSON, AccountStatusFilterBean.class);
				listAccountStatusBean = tReportMovementsService.getAccountStatusByCompanyIdAndFilter(user.getCompany(), accountStatusFilterBean, null);
			} catch (IOException e) {
				logger.error("Error al generar JSON");
				e.printStackTrace();
				return ERROR; 	
			}
		}
		else{
			logger.error("ERROR EN EL JSON");
		}
		return SUCCESS; 
	}
	
	@Action(value = "getRMXLSPendingAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"reportMap", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getRMXLSPendingAction() {
		String optionSelected = request.getParameter("reportSelectedCon");
		TUser user;
		user = (TUser) session.get("user");
		if(user == null){
			logger.error("No existe una sesión");
			return ERROR; 
		}
		reportMap = new HashMap<>();
		switch (optionSelected) {
		case "1":
			listAccountStatusBean = tReportMovementsService.getAccountStatusPendingByCompanyId(user.getCompany(), null);
			break;
		case "2":
			listAccountStatusBean = tReportMovementsService.getAccountStatusWithoutPendingByCompanyId(user.getCompany(), null);
			break;
		case "3":
			listAccountStatusBean = tReportMovementsService.getAllAccountStatusByCompanyId(user.getCompany(), null);
			break;
		default:
			listAccountStatusBean = tReportMovementsService.getAccountStatusPendingByCompanyId(user.getCompany(), null);
			break;
		}
		if(!listAccountStatusBean.isEmpty()){
			AccountStatusBean accountStatusBean = new AccountStatusBean();
			listAccountStatusBean.add(accountStatusBean);
			accountStatusBean = new AccountStatusBean();
			accountStatusBean.setObservaciones(String.valueOf(listAccountStatusBean.get(0).getPendiente()));
			accountStatusBean.setMovements("Pendiente");
			accountStatusBean.setMonto(listAccountStatusBean.get(0).getPagado());
			accountStatusBean.setBid("Total Pagado");
			accountStatusBean.setCompania((String.valueOf(listAccountStatusBean.get(0).getGanado())));
			accountStatusBean.setIdStars("Total Ganado");
			listAccountStatusBean.add(accountStatusBean);
		}
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
			logger.error("Error al generar archivo");
			e.printStackTrace();
		} finally{
		}
		return SUCCESS;
	}
	
	@Action(value = "getListRMTHAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListRMTHAction() {
		TUser user;
		user = (TUser) session.get("user");
		if(user == null){
			logger.error("No existe una sesión");
			return ERROR; 
		}
		listAccountStatusBean = tReportMovementsService.getAllAccountStatusByCompanyId(user.getCompany(), user.getTjCardNumber());
		return SUCCESS;
	}

	@Action(value = "getListRMPendingTHAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListRMPendingTHAction() {	
		TUser user;
		user = (TUser) session.get("user");
		if(user == null){
			logger.error("No existe una sesión");
			return ERROR; 
		}
		listAccountStatusBean = tReportMovementsService.getAccountStatusPendingByCompanyId(user.getCompany(), user.getTjCardNumber());
		return SUCCESS;
	}
	
	@Action(value = "getListRMNoPendingTHAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListRMNoPendingTHAction() {	
		TUser user;
		user = (TUser) session.get("user");
		if(user == null){
			logger.error("No existe una sesión");
			return ERROR; 
		}
		listAccountStatusBean = tReportMovementsService.getAccountStatusWithoutPendingByCompanyId(user.getCompany(), user.getTjCardNumber());
		return SUCCESS;
	}
	
	
	@Action(value = "searchAccountStatusTHAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAccountStatusBean", "excludeNullProperties", "true", "noCache", "true" }) )
	public String searchAccountStatusTHAction() {
		final HttpServletRequest request = ServletActionContext.getRequest();
		TUser user;
		user = (TUser) session.get("user");
		if(user == null){
			logger.error("No existe una sesión");
			return ERROR; 
		}
		String searchAccountStatusJSON = request.getParameter("searchAccountStatusvar");
		AccountStatusFilterBean accountStatusFilterBean; 
		if(!searchAccountStatusJSON.equals("undefined")){
			accountStatusFilterBean = new AccountStatusFilterBean();
			try {
				accountStatusFilterBean = new ObjectMapper().readValue(searchAccountStatusJSON, AccountStatusFilterBean.class);
				listAccountStatusBean = tReportMovementsService.getAccountStatusByCompanyIdAndFilter(user.getCompany(), accountStatusFilterBean, user.getTjCardNumber());
			} catch (IOException e) {
				logger.error("Error al generar JSON");
				e.printStackTrace();
				return ERROR; 	
			}
		}
		else{
			logger.error("ERROR EN EL JSON");
		}
		return SUCCESS; 
	}
	
	
	@Action(value = "getRMXLSPendingTHAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"reportMap", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getRMXLSPendingTHAction() {
		String optionSelected = request.getParameter("reportSelectedCon");
		TUser user;
		user = (TUser) session.get("user");
		if(user == null){
			logger.error("No existe una sesión");
			return ERROR; 
		}
		reportMap = new HashMap<>();
		switch (optionSelected) {
		case "1":
			listAccountStatusBean = tReportMovementsService.getAccountStatusPendingByCompanyId(user.getCompany(), user.getTjCardNumber());
			break;
		case "2":
			listAccountStatusBean = tReportMovementsService.getAllAccountStatusByCompanyId(user.getCompany(), user.getTjCardNumber());
			break;
		default:
			listAccountStatusBean = tReportMovementsService.getAccountStatusPendingByCompanyId(user.getCompany(), user.getTjCardNumber());
			break;
		}
		if(!listAccountStatusBean.isEmpty()){	
			AccountStatusBean accountStatusBean = new AccountStatusBean();
			listAccountStatusBean.add(accountStatusBean);
			accountStatusBean = new AccountStatusBean();
			accountStatusBean.setObservaciones(String.valueOf(listAccountStatusBean.get(0).getPendiente()));
			accountStatusBean.setMovements("Pendiente");
			accountStatusBean.setMonto(listAccountStatusBean.get(0).getPagado());
			accountStatusBean.setBid("Total Pagado");
			accountStatusBean.setCompania((String.valueOf(listAccountStatusBean.get(0).getGanado())));
			accountStatusBean.setIdStars("Total Ganado");
			listAccountStatusBean.add(accountStatusBean);
		}
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
			logger.error("Error al generar archivo");
			e.printStackTrace();
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
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
}
