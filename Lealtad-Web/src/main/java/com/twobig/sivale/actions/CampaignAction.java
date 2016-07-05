package com.twobig.sivale.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
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
import com.twobig.sivale.bd.to.CatPublicationType;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.beans.CampaignDetailAdminBean;
import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.beans.FormNewCampaignBean;
import com.twobig.sivale.beans.PublicationBean;
import com.twobig.sivale.beans.SearchCampaignBean;
import com.twobig.sivale.beans.SelectClassificationCampaignBean;
import com.twobig.sivale.beans.UpdateCampaignBean;
import com.twobig.sivale.beans.ViewPublicationBean;
import com.twobig.sivale.constants.PathConstants;
import com.twobig.sivale.service.CatClassificationCampaignService;
import com.twobig.sivale.service.FilterCampaignService;
import com.twobig.sivale.service.TCampaignsService;
import com.twobig.sivale.service.TPublicationService;
import com.twobig.sivale.service.ViewPublicationService;



@ParentPackage(value = "json-default")
@Namespace("/")
public class CampaignAction extends ActionSupport implements SessionAware {
	
	final static Logger logger = Logger.getLogger(CampaignAction.class);

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
	private List<CampaignDetailAdminBean> searchCampaignsAdmin;
	private List<TPublication> publications;
	private PublicationBean publication;
	private List<SelectClassificationCampaignBean> classificationLevel;
	private Integer campaignId;
	private Integer classificationId;
	private String cardNumber;
	private List<UpdateCampaignBean> selectCampaign;
	private List<SelectClassificationCampaignBean> selectPublicationTypes;
	private Map<String, String> message;

	public static final String CODE = "code";
	public static final String MESSAGE = "message";
	
	public static final String SUCCESS_CODE = "001";
	public static final String ERROR_CODE 	= "002";
	
	public static final String ERROR_CREATE_CAMPAIGN 	= "Se produjo un error al Crear la campaña";
	public static final String ERROR_UPDATE_CAMPAIGN 	= "Se produjo un error al actualizar la campaña";
	public static final String SUCCESS_CRATE_CAMPAIGN 	= "Campaña creada correctamente";
	public static final String SUCCESS_DELETE_CAMPAIGN 	= "Campaña eliminada correctamente";
	public static final String SUCCESS_UPDATE_CAMPAIGN 	= "Campaña actualizada correctamente";
	
	
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
		
		//logger.info("------userId: " + user.getUserId() + "  classId: " + classificationCmp.getCatClassificationCampaignsId());
		campaigns = campaignService.getCampaignByUserIdAndClassificationCampaignsId(user.getUserId(), classificationCmp.getCatClassificationCampaignsId());
		for (CampaignDetailBean campaignDetailBean2 : campaigns) {
			logger.info(campaignDetailBean2.toString());
			logger.info(campaignDetailBean2.getClassification());
		}
		return SUCCESS;

	}

	@SuppressWarnings("unchecked")
	@Action(value = "getCampaignsAdminAction", results = { @Result(name = SUCCESS, type = "json", params = { "root",
			"campaignsAdmin", "excludeNullProperties", "true", "noCache", "true" }), @Result(name = ERROR, location = "/error.jsp") })
	public String getCampaignsAdminAction() {

		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}

		// IMPORTANT -- ONLY TEST PURPOSES -- SHOULD BE DISABLED IN PRODUCTION
		//campaignsAdmin = new ServicesUser().getCampaignsAdmin();

		campaignsAdmin = campaignService.getCampaingsSuper(user.getUserId());

		for (CampaignDetailAdminBean campaignDetailAdminBean : campaignsAdmin) {
			logger.info(campaignDetailAdminBean.toString());
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
				logger.info(searchCampaign.toString());
				
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
		
		logger.info(searchCampaigns.toString());
		return SUCCESS;

	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "searchCampaignsAdminAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"searchCampaignsAdmin", "excludeNullProperties", "true", "noCache", "true" }) )
	public String searchCampaignsAdminAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String searchCampaignJSON = request.getParameter("searchCampaign");
		
		
		SearchCampaignBean searchCampaign;

		if (!searchCampaignJSON.equals("undefined")) {

			searchCampaign = new SearchCampaignBean();
			try {
				searchCampaign = new ObjectMapper().readValue(searchCampaignJSON,
						SearchCampaignBean.class);
				logger.info(searchCampaign.toString());
				
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
		
		searchCampaignsAdmin = filterCampaignService.FilterCampaignAdmin(user.getCompany(), searchCampaign);
		
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
		
		publications = publicationService.getTPublicationCampaignId(campaign.getCampaignId(), user.getCatProfile());
		
		return SUCCESS;

	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "getPublicationsAdminAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"publications", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getPubliationsAdminAction() {

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
		
		publications = publicationService.getTPublicationAdminCampaignId(campaign.getCampaignId(), user.getCatProfile());
		
		return SUCCESS;

	}

	@SuppressWarnings("unchecked")
	@Action(value = "showPublicationAsTHAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"publication", "excludeNullProperties", "true", "noCache", "true" }) )
	public String showPublicationAsTHAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String publicationJSON = request.getParameter("publication");
		
		ViewPublicationBean pub;

		if (!publicationJSON.equals("undefined")) {

			pub = new ViewPublicationBean();
			//logger.info(pub);
			//logger.info(publicationJSON);
			try {
				pub = new ObjectMapper().readValue(publicationJSON, ViewPublicationBean.class);
				//logger.info("detalle de pub: "+pub.toString());
			} catch (IOException e) {
				e.printStackTrace();
				//logger.info("ERROR ERROR ERROR ERROR ERROR ERROR ");
				return ERROR;
			}

			//logger.info("antes del session");
			session.put("publication", pub);
			//logger.info("despues del session");
		} else {
			//logger.info("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
			return ERROR;
		}

		this.publication = viewPublicationService.showPublicationByCardNumber(pub.getAcoundNumber(), pub.getPublicationId(), 1);
		
		//logger.info(publication);
		
		if(this.publication.getListFiles()!=null)
			if(this.publication.getListFiles().size() == 0)
				this.publication.setListFiles(null);
			//for (TAttachedFile files : publication.getListFiles()) {
			//	logger.info(files.toString());
			//}
		
		logger.info(this.publication.getHtml());
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
		
		this.publication = viewPublicationService.showPublication(user.getUserId(), pub.getPublicationId(), user.getCatProfile());
		
		if(publication.getListFiles()!=null)
			if(publication.getListFiles().size() == 0)
				publication.setListFiles(null);
			//for (TAttachedFile files : publication.getListFiles()) {
			//	logger.info(files.toString());
			//}
		
		logger.info(publication.getHtml());
		return SUCCESS;
	}
	
	
	@SuppressWarnings("unchecked")
	@Action(value = "deleteCampaignAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"message", "excludeNullProperties", "true", "noCache", "true" }) )
	public String deleteCampaignAction() {

		logger.info("**** " + campaignId + " ****");
		campaignService.deleteCampaign(campaignId);
		setMessage(SUCCESS_CODE, SUCCESS_DELETE_CAMPAIGN);
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
	@Action(value = "getPublicationTypesAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"selectPublicationTypes", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getPublicationTypesAction() {
		
		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}
		
		List<CatPublicationType> publicationTypes = publicationService.getPublicationType();
		if(publicationTypes!=null){
			selectPublicationTypes = new ArrayList<SelectClassificationCampaignBean>();
			
			for(CatPublicationType pType : publicationTypes){
				SelectClassificationCampaignBean select = new SelectClassificationCampaignBean();
				select.setId(pType.getPublicationTypeId());
				select.setName(pType.getName());
				
				selectPublicationTypes.add(select);
			}
			
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "addCampaignAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"message", "excludeNullProperties", "true", "noCache", "true" }) )
	public String addCampaignAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();
		
		String classificationCmpJSON = request.getParameter("formNewCampaign");
		logger.info("*********** " + classificationCmpJSON + "******************");
		
		FormNewCampaignBean formNewCampaign;
		
		if (!classificationCmpJSON.equals("undefined")) {

			formNewCampaign = new FormNewCampaignBean();
			try {
				formNewCampaign = new ObjectMapper().readValue(classificationCmpJSON,
						FormNewCampaignBean.class);
			} catch (IOException e) {
				e.printStackTrace();
				
				setMessage(this.ERROR_CODE, this.ERROR_CREATE_CAMPAIGN);
				return ERROR;
			}

		} else {
			setMessage(this.ERROR_CODE, this.ERROR_CREATE_CAMPAIGN);
			return ERROR;
			
		}

		TUser user = (TUser) session.get("user");
		if (user == null) {
			setMessage(this.ERROR_CODE, this.ERROR_CREATE_CAMPAIGN);
			return ERROR;
		}
		
		formNewCampaign.setCompanyId(user.getCompany());
		
		logger.info(formNewCampaign.toString());
		for(SelectClassificationCampaignBean classif : formNewCampaign.getClassificationList())
			logger.info("id: " + classif.getId() + "  name: " + classif.getName());
		
		logger.info("*********** " + formNewCampaign.getCampaignName() + "******************");
		
		System.out.println(formNewCampaign.toString());
		
		String idTCampaign = campaignService.insertCampaign(formNewCampaign);
		
		saveFile(formNewCampaign.getImageFile(), formNewCampaign.getNameFile(), idTCampaign);
		
		setMessage(this.SUCCESS_CODE, this.SUCCESS_CRATE_CAMPAIGN);
		return SUCCESS;

	}
	
	private void saveFile(String fileString, String fileName, String idTCampaign){
		
		String pathName = PathConstants.ATTACHED_IMAGE_CAMPAIGN + idTCampaign + File.separator + fileName; 
		
		byte[] fileBits = stringToBytes(fileString);
		
		File file = new File(pathName);
		
		try {
			FileUtils.writeByteArrayToFile(file, fileBits);
			System.out.println("-.-.-.-.-.-.-: "+file.getAbsolutePath());
			
		} catch (IOException e) {
			System.out.println("NO SE PUDO GUARDAR LA IMAGEN DE LA CAMPAÑA");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private byte[] stringToBytes(String string) {
		String [] bytes = string.split(",");
		final byte[] fileBytes = new byte[bytes.length];		
		int i=0;
		for (String byteStr : bytes) {
			fileBytes[i] = (byte) Integer.parseInt(byteStr);
			i++;
		}
		return fileBytes;		
	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "updateCampaignAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"message", "excludeNullProperties", "true", "noCache", "true" }) )
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
				setMessage(ERROR_CODE, ERROR_UPDATE_CAMPAIGN);
				return ERROR;
			}

		} else {
			setMessage(ERROR_CODE, ERROR_UPDATE_CAMPAIGN);
			return ERROR;
			
		}

		TUser user = (TUser) session.get("user");
		if (user == null) {
			setMessage(ERROR_CODE, ERROR_UPDATE_CAMPAIGN);
			return ERROR;
		}
		
		formNewCampaign.setCompanyId(user.getCompany());
		
		logger.info(formNewCampaign.toString());
		for(SelectClassificationCampaignBean classif : formNewCampaign.getClassificationList())
			logger.info("id: " + classif.getId() + "  name: " + classif.getName());
		campaignService.updateCampaign(formNewCampaign);
		
		setMessage(SUCCESS_CODE, SUCCESS_UPDATE_CAMPAIGN);
		return SUCCESS;

	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "getCampaignUpdateAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"selectCampaign", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getCampaignUpdateAction(){
		
		final HttpServletRequest request = ServletActionContext.getRequest();

		String classificationCmpJSON = request.getParameter("campaignDetail");
		
		CampaignDetailAdminBean campaignDetail;

		if (!classificationCmpJSON.equals("undefined")) {

			campaignDetail = new CampaignDetailAdminBean();
			try {
				campaignDetail = new ObjectMapper().readValue(classificationCmpJSON,
						CampaignDetailAdminBean.class);
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}

		} else {
			return ERROR;			
		}
		
		TUser user = (TUser)session.get("user");
		
		if (user==null) {
			return ERROR;
		}

		selectCampaign = new ArrayList<UpdateCampaignBean>();
		
		
		classificationLevel = classificationService.getListClassificationParent(user.getUserId());
		
		UpdateCampaignBean updateCampaignBean = new UpdateCampaignBean();
		updateCampaignBean.setAvailableOptions(classificationLevel);
		updateCampaignBean.setSelectedOption(this.getSelectedOption(classificationLevel, campaignDetail.getCatClassificationCampaign().get(0).getCatClassificationCampaignsId()));
		
		selectCampaign.add(updateCampaignBean);
		
		
		
		for(int i=0 ; i<campaignDetail.getCatClassificationCampaign().size() - 1 ; i++ ){
			Integer classId = campaignDetail.getCatClassificationCampaign().get(i).getCatClassificationCampaignsId();
			classificationLevel = classificationService.getListClassificationChildren(classId);
			
			updateCampaignBean = new UpdateCampaignBean();
			updateCampaignBean.setAvailableOptions(classificationLevel);
			updateCampaignBean.setSelectedOption(this.getSelectedOption(classificationLevel, campaignDetail.getCatClassificationCampaign().get(i+1).getCatClassificationCampaignsId()));
			
			selectCampaign.add(updateCampaignBean);
		}
		
		logger.info(selectCampaign.toString());
		
		return SUCCESS;
	}
	
	
//	@Action(value = "uploadFileAction")
//	public String uploadAction(){
//		
//		final HttpServletRequest request = ServletActionContext.getRequest();
//
//		String fileJSON = request.getParameter("file");
//		
//		logger.info(fileJSON);
//		
//		return SUCCESS;
//		
//	}
	
	public void setMessage(String code, String message){
		this.message = new HashMap <String, String>();
		this.message.put(CODE, code);
		this.message.put(MESSAGE, message);
	}
	
	public SelectClassificationCampaignBean getSelectedOption(List<SelectClassificationCampaignBean> listOption, Integer selectedId){
		
		for(SelectClassificationCampaignBean option: listOption){
			if(option.getId().equals(selectedId))
				return option;
		}
		
		return null;
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

	public List<CampaignDetailAdminBean> getSearchCampaignsAdmin() {
		return searchCampaignsAdmin;
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

	public List<UpdateCampaignBean> getSelectCampaign() {
		return selectCampaign;
	}

	public List<SelectClassificationCampaignBean> getSelectPublicationTypes() {
		return selectPublicationTypes;
	}

	public Map<String, String> getMessage() {
		return message;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	

}
