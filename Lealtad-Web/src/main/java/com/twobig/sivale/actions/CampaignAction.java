package com.twobig.sivale.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.beans.CampaignDetailAdminBean;
import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.beans.FormNewCampaignBean;
import com.twobig.sivale.beans.PublicationBean;
import com.twobig.sivale.beans.SearchCampaignBean;
import com.twobig.sivale.beans.SelectClassificationCampaignBean;
import com.twobig.sivale.constants.PathConstants;
import com.twobig.sivale.service.CatClassificationCampaignService;
import com.twobig.sivale.service.FilterCampaignService;
import com.twobig.sivale.service.TCampaignsService;
import com.twobig.sivale.service.TPublicationService;
import com.twobig.sivale.service.ViewPublicationService;
import com.xm.sivale.services.test.ServicesUser;

@ParentPackage(value = "json-default")
@Namespace("/")
public class CampaignAction extends ActionSupport implements SessionAware {

	@Autowired
	CatClassificationCampaignService classificationCampaignService;
	
	@Autowired
	TCampaignsService campaignService;
	
	@Autowired
	FilterCampaignService filterCampaignService;
	
	@Autowired
	TPublicationService publicationService;
	
	@Autowired
	ViewPublicationService viewPublicationService;
	
	@Autowired
	CatClassificationCampaignService classificationService;
	
	private Map<String, Object> session;
	private List<CatClassificationCampaign> classifications;
	private List<CampaignDetailBean> campaigns;
	private List<CampaignDetailAdminBean> campaignsAdmin;
	private List<CampaignDetailBean> searchCampaigns;
	private List<TPublication> publications;
	private PublicationBean publication;
	private List<SelectClassificationCampaignBean> classificationLevel;
	private Integer campaignId;
	private Integer classificationId;

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
		//classifications = new ServicesUser().getMyClassifications(user.getUserId());
		
		classifications = classificationCampaignService.getCatClassificationCampaignByUserId(user.getUserId());
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
		//campaigns = new ServicesUser().getCampaigns(user.getUserId(),
		//		classificationCmp.getCatClassificationCampaignsId());
		
		//System.out.println("------userId: " + user.getUserId() + "  classId: " + classificationCmp.getCatClassificationCampaignsId());
		campaigns = campaignService.getCampaignByUserIdAndClassificationCampaignsId(user.getUserId(), classificationCmp.getCatClassificationCampaignsId());
		for (CampaignDetailBean campaignDetailBean2 : campaigns) {
			System.out.println(campaignDetailBean2.toString());
			System.out.println(campaignDetailBean2.getClassification());
		}
		return SUCCESS;

	}

	@SuppressWarnings("unchecked")
	@Action(value = "getCampaignsAdminAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"campaignsAdmin", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getCampaignsAdminAction() {

		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}

		// IMPORTANT -- ONLY TEST PURPOSES -- SHOULD BE DISABLED IN PRODUCTION
		//campaignsAdmin = new ServicesUser().getCampaignsAdmin();

		campaignsAdmin = campaignService.getCampaingsSuper(user.getUserId());

		for (CampaignDetailAdminBean campaignDetailAdminBean : campaignsAdmin) {
			System.out.println(campaignDetailAdminBean.toString());
		}
		
		return SUCCESS;

	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "searchCampaignsAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"searchCampaigns", "excludeNullProperties", "true", "noCache", "true" }) )
	public String searchCampaignsAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String searchCampaignJSON = request.getParameter("searchCampaign");
		
		
		SearchCampaignBean searchCampaign;

		if (!searchCampaignJSON.equals("undefined")) {

			searchCampaign = new SearchCampaignBean();
			try {
				searchCampaign = new ObjectMapper().readValue(searchCampaignJSON,
						SearchCampaignBean.class);
				CatClassificationCampaign classification = (CatClassificationCampaign) session.get("classificationCmp");
				
				if(classification == null)
					return ERROR;
				
				searchCampaign.setClassificationParentId(classification.getCatClassificationCampaignsId());
				System.out.println(searchCampaign.toString());
				
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}

		} else {
			return ERROR;
		}

		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}

		// IMPORTANT -- ONLY TEST PURPOSES -- SHOULD BE DISABLED IN PRODUCTION
		//searchCampaigns = new ServicesUser().searchCampaigns();
		
		searchCampaigns = filterCampaignService.FilterCampaign(user.getUserId(), searchCampaign);
		
		System.out.println(searchCampaigns.toString());
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
		//publications = new ServicesUser().getPubliations(user.getUserId(), campaign.getCampaignId());
		
		publications = publicationService.getTPublicationCampaignId(campaign.getCampaignId());
		
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
		//this.publication = new ServicesUser().showPublication(user.getUserId(), pub.getPublicationId());
		
		this.publication = viewPublicationService.showPublication(user.getUserId(), pub.getPublicationId());
		for (TAttachedFile files : publication.getListFiles()) {
			System.out.println(files.toString());
		}
		
		System.out.println(publication.getHtml());
		return SUCCESS;
	}
	
	
	@SuppressWarnings("unchecked")
	@Action(value = "deleteCampaignAction")
	public String deleteCampaignAction() {

		System.out.println("**** " + campaignId + " ****");
		campaignService.deleteCampaign(campaignId);
		return SUCCESS;

	}
	
	
	@SuppressWarnings("unchecked")
	@Action(value = "getClassificationLevelAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"classificationLevel", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getClassificationLevelAction() {
		
		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}
		
		if(classificationId < 0)
			classificationLevel = classificationService.getListClassificationParent(user.getUserId());
		else{
			classificationLevel = classificationService.getListClassificationChildren(classificationId);
			
			SelectClassificationCampaignBean first = new SelectClassificationCampaignBean();
			SelectClassificationCampaignBean last  = new SelectClassificationCampaignBean();
			
			first.setId(-1);
			first.setName("Ninguno");
			
			last.setId(-2);
			last.setName("Añadir nuevo");
			
			classificationLevel.add(0, first);
			classificationLevel.add(last);
		}
		return SUCCESS;

	}

	
	@SuppressWarnings("unchecked")
	@Action(value = "addCampaignAction")
	public String addCampaignAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String classificationCmpJSON = request.getParameter("formNewCampaign");
		
		
		FormNewCampaignBean formNewCampaign;

		if (!classificationCmpJSON.equals("undefined")) {

			formNewCampaign = new FormNewCampaignBean();
			try {
				formNewCampaign = new ObjectMapper().readValue(classificationCmpJSON,
						FormNewCampaignBean.class);
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}

		} else {
			
			return ERROR;
			
		}

		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}
		
		formNewCampaign.setCompanyId(user.getCompany());
		
		System.out.println(formNewCampaign.toString());
		for(SelectClassificationCampaignBean classif : formNewCampaign.getClassificationList())
			System.out.println("id: " + classif.getId() + "  name: " + classif.getName());
		
		campaignService.insertCampaign(formNewCampaign);
		
		return SUCCESS;

	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "updateCampaignAction")
	public String updateCampaignAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String classificationCmpJSON = request.getParameter("formNewCampaign");
		
		
		FormNewCampaignBean formNewCampaign;

		if (!classificationCmpJSON.equals("undefined")) {

			formNewCampaign = new FormNewCampaignBean();
			try {
				formNewCampaign = new ObjectMapper().readValue(classificationCmpJSON,
						FormNewCampaignBean.class);
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}

		} else {
			
			return ERROR;
			
		}

		//System.out.println(formNewCampaign.toString());
		//for(SelectClassificationCampaignBean classif : formNewCampaign.getClassificationList())
		//	System.out.println("id: " + classif.getId() + "  name: " + classif.getName());
		campaignService.updateCampaign(formNewCampaign);
		
		return SUCCESS;

	}
	

	
	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	public List<CatClassificationCampaign> getClassifications() {
		return classifications;
	}

	public List<CampaignDetailBean> getCampaigns() {
		return campaigns;
	}

	public List<TPublication> getPublications() {
		return publications;
	}

	public PublicationBean getPublication() {
		return publication;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public List<CampaignDetailBean> getSearchCampaigns() {
		return searchCampaigns;
	}

	public List<CampaignDetailAdminBean> getCampaignsAdmin() {
		return campaignsAdmin;
	}
	
	public List<SelectClassificationCampaignBean> getClassificationLevel() {
		return classificationLevel;
	}

	public Integer getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(Integer classificationId) {
		this.classificationId = classificationId;
	}
	
	
}
