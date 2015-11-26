package com.twobig.sivale.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TPublication;
import com.xm.sivale.services.test.ServicesUser;

@ParentPackage(value = "json-default")
@Namespace("/")
public class CampaingAction extends ActionSupport implements SessionAware {

	private List<Map> classifications;

	private List<Map> campaings;
			
	private List<TPublication> publications;
	
	private Map publication;
	
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}
	
	
	@SuppressWarnings("unchecked")
	@Action(value= "getMyClassificationsAction", results = @Result(name = SUCCESS, type = "json", params = {
					"root", "classifications", "excludeNullProperties", "true", "noCache", "true" }))
	public String getMyClassificationsAction(){
		
		
		// IMPORTANT -- ONLY TEST PURPOSES -- SHOULD BE DISABLED IN PRODUCTION
		classifications = new ServicesUser().getMyClassifications(1);
		return SUCCESS; 
		
	}
	
	@SuppressWarnings("unchecked")
	@Action(value= "getCampaingsAction", results = @Result(name = SUCCESS, type = "json", params = {
					"root", "campaings", "excludeNullProperties", "true", "noCache", "true" }))
	public String getCampaingsAction(){
		
		// IMPORTANT -- ONLY TEST PURPOSES -- SHOULD BE DISABLED IN PRODUCTION
		campaings = new ServicesUser().getCampaings(1, 1);
		return SUCCESS; 
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Action(value= "getPubliationsAction", results = @Result(name = SUCCESS, type = "json", params = {
					"root", "publications", "excludeNullProperties", "true", "noCache", "true" }))
	public String getPubliationsAction(){
		
		// IMPORTANT -- ONLY TEST PURPOSES -- SHOULD BE DISABLED IN PRODUCTION
		publications = new ServicesUser().getPubliations(1, 1);
		return SUCCESS; 
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Action(value= "showPublicationAction", results = @Result(name = SUCCESS, type = "json", params = {
					"root", "publication", "excludeNullProperties", "true", "noCache", "true" }))
	public String showPublicationAction(){
		
		// IMPORTANT -- ONLY TEST PURPOSES -- SHOULD BE DISABLED IN PRODUCTION
		publication = new ServicesUser().showPublication(1, 1);
		return SUCCESS; 
	}


	
	public List<Map> getClassifications() {
		return classifications;
	}

	public List<Map> getCampaings() {
		return campaings;
	}

	public List<TPublication> getPublications() {
		return publications;
	}

	public Map getPublication() {
		return publication;
	}
	
}
