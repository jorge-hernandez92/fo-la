package com.twobig.sivale.actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.bd.to.TUser;
import com.xm.sivale.services.test.ServicesUser;

@ParentPackage(value = "json-default")
@Namespace("/")
public class CampaignAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private List<Map> classifications;

	private List<Map> campaigns;

	private List<TPublication> publications;

	private Map publication;


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "updateSessionAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"session", "excludeNullProperties", "true", "noCache", "true" }) )
	public String updateSessionAction() {

		return SUCCESS;

	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "getMyClassificationsAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"classifications", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getMyClassificationsAction() {

		TUser user = (TUser)session.get("user");

		if (user==null) {
			return ERROR;
		}

		// IMPORTANT -- ONLY TEST PURPOSES -- SHOULD BE DISABLED IN PRODUCTION
		classifications = new ServicesUser().getMyClassifications(user.getUserId());
		return SUCCESS;

	}

	@SuppressWarnings("unchecked")
	@Action(value = "getCampaignsAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"campaigns", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getCampaignsAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String classificationCmpJSON = request.getParameter("classificationCmp");
		
		
		CatClassificationCampaign classificationCmp;

		if (!classificationCmpJSON.equals("undefined")) {

			classificationCmp = new CatClassificationCampaign();
			try {
				classificationCmp = new ObjectMapper().readValue(classificationCmpJSON,
						CatClassificationCampaign.class);
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}

			session.put("classificationCmp", classificationCmp);
		} else {
			classificationCmp = (CatClassificationCampaign) session.get("classificationCmp");

			if (classificationCmp == null) {
				return ERROR;
			}
		}

		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}

		// IMPORTANT -- ONLY TEST PURPOSES -- SHOULD BE DISABLED IN PRODUCTION
		campaigns = new ServicesUser().getCampaigns(user.getUserId(),
				classificationCmp.getCatClassificationCampaignsId());
		return SUCCESS;

	}

	@SuppressWarnings("unchecked")
	@Action(value = "getPublicationsAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"publications", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getPubliationsAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String campaignJSON = request.getParameter("campaign");

		TCampaign campaign;

		if (!campaignJSON.equals("undefined")) {

			campaign = new TCampaign();
			try {
				campaign = new ObjectMapper().readValue(campaignJSON, TCampaign.class);
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}

			session.put("campaign", campaign);
		} else {
			campaign = (TCampaign) session.get("campaign");

			if (campaign == null) {
				return ERROR;
			}
		}

		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}

		// IMPORTANT -- ONLY TEST PURPOSES -- SHOULD BE DISABLED IN PRODUCTION
		publications = new ServicesUser().getPubliations(user.getUserId(), campaign.getCampaignId());
		return SUCCESS;

	}

	@SuppressWarnings("unchecked")
	@Action(value = "showPublicationAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"publication", "excludeNullProperties", "true", "noCache", "true" }) )
	public String showPublicationAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String publicationJSON = request.getParameter("publication");
		
		TPublication pub;

		if (!publicationJSON.equals("undefined")) {

			pub = new TPublication();
			try {
				pub = new ObjectMapper().readValue(publicationJSON, TPublication.class);
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}

			session.put("publication", pub);
		} else {
			pub = (TPublication) session.get("publication");

			if (pub == null) {
				return ERROR;
			}

		}

		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}

		// IMPORTANT -- ONLY TEST PURPOSES -- SHOULD BE DISABLED IN PRODUCTION
		this.publication = new ServicesUser().showPublication(user.getUserId(), pub.getPublicationId());
		return SUCCESS;
	}

	public List<Map> getClassifications() {
		return classifications;
	}

	public List<Map> getCampaigns() {
		return campaigns;
	}

	public List<TPublication> getPublications() {
		return publications;
	}

	public Map getPublication() {
		return publication;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	
}
