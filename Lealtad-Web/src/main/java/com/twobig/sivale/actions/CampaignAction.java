package com.twobig.sivale.actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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

	private String key;

	private String value;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
		//----------------- This code is only for Test ------------------
		TUser user = new TUser();
		user.setUserId(101);
		
		CatClassificationCampaign classification = new CatClassificationCampaign();
		classification.setCatClassificationCampaignsId(202);
		
		this.session.put("user", user);
		this.session.put("classificationCmp", classification);
		//----------------------------------------------------------------
	}

	@SuppressWarnings("unchecked")
	@Action(value = "getMyClassificationsAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"classifications", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getMyClassificationsAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String userJSON = request.getParameter("user");
		TUser user;

		if (!userJSON.equals("undefined")) {

			user = new TUser();
			try {
				user = new ObjectMapper().readValue(userJSON, TUser.class);
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}

			session.put("user", user);
		} else {
			user = (TUser) session.get("user");

			if (user == null) {
				return ERROR;
			}
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

		//
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

		TPublication publication;

		if (!publicationJSON.equals("undefined")) {

			publication = new TPublication();
			try {
				publication = new ObjectMapper().readValue(publicationJSON, TPublication.class);
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}

			session.put("publication", publication);
		} else {
			publication = (TPublication) session.get("publication");

			if (publication == null) {
				return ERROR;
			}

		}

		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}

		// IMPORTANT -- ONLY TEST PURPOSES -- SHOULD BE DISABLED IN PRODUCTION
		this.publication = new ServicesUser().showPublication(user.getUserId(), publication.getPublicationId());
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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
