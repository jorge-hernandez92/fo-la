package com.twobig.sivale.actions;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.CatPublicationType;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.beans.PublicationCRUDBean;
import com.twobig.sivale.constants.PathConstants;
import com.twobig.sivale.service.TPublicationService;
import com.twobig.sivale.utils.FilesUtil;

@ParentPackage(value = "json-default")
@Namespace("/")
public class UploadFileAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -4748500436762141116L;

	@Autowired
	private TPublicationService publicationService;
	
	
	private Map<String, Object> session;
	private File[] file;
	private String[] fileContentType;
	private String[] fileFileName;
	private String[] filechecked;
	private String publication;
	private String description;
	private int selected;
	private Map<String, String> message;
	private Integer publicationId;

	public static final String CODE = "code";
	public static final String MESSAGE = "message";
	
	public static final String SUCCESS_CODE = "001";
	public static final String ERROR_CODE 	= "002";
	
	public static final String ERROR_CREATE_PUBLICATION 	= "Se produjo un error al Crear la publicación";
	public static final String ERROR_UPDATE_PUBLICATION 	= "Se produjo un error al Actualizar la publicación";
	public static final String SUCCESS_CREATE_PUBLICATION 	= "Publicación creada correctamente";
	public static final String SUCCESS_DELETE_PUBLICATION 	= "Publicación eliminada correctamente";
	public static final String SUCCESS_UPDATE_PUBLICATION 	= "Publicación actualizada correctamente";
	
	
	
	@Action(value = "UploadFile", results = { @Result(name=SUCCESS, location="/secured/home_admin.jsp"),
			@Result(name = ERROR, location = "/secured/home_admin.jsp")},
	        interceptorRefs={
			        @InterceptorRef(params={"maximumSize","104857600"}, value="fileUpload"),
			        @InterceptorRef("defaultStack"),
			        @InterceptorRef("validation")}
	)
	public String uploadAction(){
		
		TCampaign campaign = (TCampaign) session.get("campaign");
		TPublication publication; 

		if (campaign == null) {
			setMessage(ERROR_CODE, ERROR_CREATE_PUBLICATION);
			return ERROR;
		}
		
		
		if(getFile().length == 2){
			publication = loadHtmlExcel(campaign);
			return loadAtachedFiles(publication,campaign, 2, 1);
		}
		else if(getFile().length >= 3){
			
			try {
				Image image = ImageIO.read(getFile()[0]);
			    if (image == null) {
			    	publication = loadHtmlExcel(campaign);
			    	return loadAtachedFiles(publication,campaign, 2, 1);
			    	
			    }
			    else{
			    	publication = loadImageHtmlExcel(campaign);
			    	return loadAtachedFiles(publication,campaign, 3, 2);
			    }
			} catch(IOException ex) {	
				
			}
		}
		
		setMessage(ERROR_CODE, ERROR_CREATE_PUBLICATION);
		return ERROR;
		
	}
	
	/**
	 * This method create a publication with all information that is delivering by the user
	 * @param campaign current campaign of the session
	 * @return publication with HTML and EXCEL files 
	 */
	private TPublication loadHtmlExcel(TCampaign campaign){
		
		CatPublicationType publicationTypet = new CatPublicationType();
		publicationTypet.setPublicationTypeId(selected);
		
		TPublication publication = new TPublication();
		publication.setCatPublicationType(publicationTypet);
		publication.settCampaignId(campaign.getCampaignId());
		publication.setName(this.publication);
		publication.setDescription(this.description);
		
		/* Load of excel */
		publication.setDataFilePath(this.getFileFileName()[1]);
		
		/* Load of template (HTML)*/
		publication.setTemplateFilePath(this.getFileFileName()[0]);
		
		publication.setIsEnable(false);
		
		return publication; 
	}
	
	/**
	 * This method create a publication with all information that is delivering by the user
	 * @param campaign current campaign of the session
	 * @return publication with IMAGE,  HTML and EXCEL files 
	 */
	private TPublication loadImageHtmlExcel(TCampaign campaign){
		
		CatPublicationType publicationTypet = new CatPublicationType();
		publicationTypet.setPublicationTypeId(selected);
		
		TPublication publication = new TPublication();
		publication.setCatPublicationType(publicationTypet);
		publication.settCampaignId(campaign.getCampaignId());
		publication.setName(this.publication);
		publication.setDescription(this.description);
		/* Load of excel */
		publication.setDataFilePath(this.getFileFileName()[2]);
		/* Load of template (HTML)*/
		publication.setTemplateFilePath(this.getFileFileName()[1]);
		/* Load of publication image */
		publication.setImagePath(this.getFileFileName()[0]);
		publication.setIsEnable(false);
		
		return publication; 
	}
	
	/**
	 * Load all files that is delivering by the user. The files is loaded in the file system. 
	 * @param publication creates for save all information of a publication  
	 * @param campaign current campaign of the session
	 * @param numberFilesPub is the number of files that the user needs for the new publication 
	 * @param indexExcel is the position of excel file in the array created in the browser
	 * @return String with the state of files 
	 */
	private String loadAtachedFiles(TPublication publication, TCampaign campaign, int numberFilesPub, int indexExcel){
		
		PublicationCRUDBean publicationBean = new PublicationCRUDBean();
		publicationBean.setPublication(publication);
		
		List<TAttachedFile> attachedFiles = new ArrayList<TAttachedFile>();
		for (int i = numberFilesPub ; i < this.getFile().length; i++) {
			TAttachedFile attachedFile = new TAttachedFile();
			
			if(this.getFilechecked()[i- (numberFilesPub )].equals("Privado"))
				attachedFile.setIsPublic(false);
			else attachedFile.setIsPublic(true);
			
			StringTokenizer tokens = new StringTokenizer(this.getFileFileName()[i],".");
			
			ArrayList<String> tokensList = new ArrayList<String>();
			while(tokens.hasMoreTokens()){
				tokensList.add(tokens.nextToken());
			}
			
			if (tokensList.size() >= 2){
				
				if(tokensList.size() == 2){
					attachedFile.setFileName(tokensList.get(0));
					attachedFile.setFileExtension(tokensList.get(1));
				}
				else{
					String fileName = "";
					for(int j=0; j < tokensList.size()-1; j++){
						if(j == tokensList.size()-2)
							fileName += tokensList.get(j);
						else
							fileName += tokensList.get(j) + ".";
					}
					String extension = tokensList.get(tokensList.size()-1);
					
					attachedFile.setFileName(fileName);
					attachedFile.setFileExtension(extension);
				}
				
			}
			else{
				return ERROR;
			}
			
			attachedFiles.add(attachedFile);
		}

		publicationBean.setAttachedFiles(attachedFiles);
		
		String id = publicationService.addPublication(publicationBean);			
		
		String directory = PathConstants.ATTACHED_DIRECTORY + campaign.getCampaignId() + File.separator + id;
		
		if(NumberUtils.isDigits(id)){
			
			for(int i=0; i < getFile().length; i++){
				
				try {
					FilesUtil.saveFile(getFile()[i], getFileFileName()[i], directory);
				} catch (IOException e) {
					e.printStackTrace();
					setMessage(ERROR_CODE, ERROR_CREATE_PUBLICATION);
					return ERROR;
				}
			}
			publicationService.loadDataExcel(Integer.valueOf(id), directory+File.separator+getFileFileName()[indexExcel]);
			
			setMessage(SUCCESS_CODE, SUCCESS_CREATE_PUBLICATION);
			return SUCCESS;
			
		}
		setMessage(ERROR_CODE, ERROR_CREATE_PUBLICATION);
		return ERROR;
	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "updateStatusPublicationAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"message", "excludeNullProperties", "true", "noCache", "true" }) )
	public String updateStatusPublicationAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String publicationJSON = request.getParameter("publication");
		
		
		TPublication publication;

		if (!publicationJSON.equals("undefined")) {

			publication = new TPublication();
			try {
				publication = new ObjectMapper().readValue(publicationJSON,
						TPublication.class);
			} catch (IOException e) {
				e.printStackTrace();
				setMessage(ERROR_CODE, ERROR_UPDATE_PUBLICATION);
				return ERROR;
			}

		} else {
			setMessage(ERROR_CODE, ERROR_UPDATE_PUBLICATION);
			return ERROR;
			
		}
		
		PublicationCRUDBean publicationBean = new PublicationCRUDBean();
		publicationBean.setPublication(publication);
		
		publicationService.updatePublication(publicationBean);
		
		setMessage(SUCCESS_CODE, SUCCESS_UPDATE_PUBLICATION);
		return SUCCESS;

	}
	
	@Action(value = "UpdatePublicationAction", results = { @Result(name=SUCCESS, location="/secured/home_admin.jsp"),
			@Result(name = ERROR, location = "/secured/home_admin.jsp")},
	        interceptorRefs={
			        @InterceptorRef(params={"maximumSize","104857600"}, value="fileUpload"),
			        @InterceptorRef("defaultStack"),
			        @InterceptorRef("validation")}
	)
	public String updatePublicationAction(){
		
		if(getFile()!=null && getFile().length > 0){
			
			TCampaign campaign = (TCampaign) session.get("campaign");

			TPublication publication = (TPublication) session.get("publication");

			if (publication == null) {
				return ERROR;
			}
			
			publication.getCatPublicationType().setPublicationTypeId(selected);
			publication.setName(this.publication);
			publication.setDescription(this.description);
			
			PublicationCRUDBean publicationBean = new PublicationCRUDBean();
			publicationBean.setPublication(publication);
			
			List<TAttachedFile> attachedFiles = new ArrayList<TAttachedFile>();
			for (int i = 0; i < this.getFile().length; i++) {
				TAttachedFile attachedFile = new TAttachedFile();
				
				attachedFile.settPublicationId(publication.getPublicationId());
				
				if(this.getFilechecked()[i].equals("Privado"))
					attachedFile.setIsPublic(false);
				else attachedFile.setIsPublic(true);
				
				StringTokenizer tokens = new StringTokenizer(this.getFileFileName()[i],".");
				
				ArrayList<String> tokensList = new ArrayList<String>();
				while(tokens.hasMoreTokens()){
					tokensList.add(tokens.nextToken());
				}
				
				if (tokensList.size() >= 2){
					
					if(tokensList.size() == 2){
						attachedFile.setFileName(tokensList.get(0));
						attachedFile.setFileExtension(tokensList.get(1));
					}
					else{
						String fileName = "";
						for(int j=0; j < tokensList.size()-1; j++){
							if(j == tokensList.size()-2)
								fileName += tokensList.get(j);
							else
								fileName += tokensList.get(j) + ".";
						}
						String extension = tokensList.get(tokensList.size()-1);
						
						attachedFile.setFileName(fileName);
						attachedFile.setFileExtension(extension);
					}
					
				}
				else{
					return ERROR;
				}
				
				attachedFiles.add(attachedFile);
			}

			publicationBean.setAttachedFiles(attachedFiles);
			
			//String id = publicationService.updatePublication(publicationBean);
			
			
			String directory = PathConstants.ATTACHED_DIRECTORY + campaign.getCampaignId() + File.separator + publication.getPublicationId();
			
			
				
				for(int i=0; i < getFile().length; i++){
					
					try {
						FilesUtil.saveFile(getFile()[i], getFileFileName()[i], directory);
					} catch (IOException e) {
						e.printStackTrace();
						return ERROR;
					}
				}
				publicationService.insertListAttachedFiles(attachedFiles);
				
				return SUCCESS;
				
			
		}
		else{
			TPublication publication = (TPublication) session.get("publication");

			if (publication == null) {
				return ERROR;
			}
			
			publication.getCatPublicationType().setPublicationTypeId(selected);
			publication.setName(this.publication);
			publication.setDescription(this.description);
			
			PublicationCRUDBean publicationBean = new PublicationCRUDBean();
			publicationBean.setPublication(publication);
			
			publicationService.updatePublication(publicationBean);
			
			return SUCCESS;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "deletePublicationAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"message", "excludeNullProperties", "true", "noCache", "true" }) )
	public String deletePublicationAction() {

		publicationService.deletePublication(publicationId);
		setMessage(SUCCESS_CODE, SUCCESS_DELETE_PUBLICATION);
		return SUCCESS;

	}
	
	public void setMessage(String code, String message){
		this.message = new HashMap <String, String>();
		this.message.put(CODE, code);
		this.message.put(MESSAGE, message);
	}

	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}
	

	public String[] getFilechecked() {
		return filechecked;
	}

	public void setFilechecked(String[] filechecked) {
		this.filechecked = filechecked;
	}

	public Map<String, String> getMessage() {
		return message;
	}

	public Integer getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(Integer publicationId) {
		this.publicationId = publicationId;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}