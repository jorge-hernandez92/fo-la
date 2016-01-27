package com.twobig.sivale.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
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
	
	
	@Action(value = "UploadFile",
	        interceptorRefs={
			        @InterceptorRef(params={"maximumSize","104857600"}, value="fileUpload"),
			        @InterceptorRef("defaultStack"),
			        @InterceptorRef("validation")}
	)
	public String uploadAction(){
		
		System.out.println("*/*/*/*/*/*/*/**/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/ ");
		System.out.println("Tamaño de boleanos: " + this.getFilechecked().length);
		for(int i = 0 ; i<filechecked.length ; i++)
			System.out.println("boolean["+i+"] : " + filechecked[i]);
		
		if(getFile().length >= 2){
			
			TCampaign campaign = (TCampaign) session.get("campaign");

			if (campaign == null) {
				return ERROR;
			}
			
			CatPublicationType publicationTypet = new CatPublicationType();
			publicationTypet.setPublicationTypeId(selected);
			
			TPublication publication = new TPublication();
			publication.setCatPublicationType(publicationTypet);
			publication.settCampaignId(campaign.getCampaignId());
			publication.setName(this.publication);
			publication.setDescription(this.description);
			publication.setDataFilePath(this.getFileFileName()[1]);
			publication.setTemplateFilePath(this.getFileFileName()[0]);
			publication.setIsEnable(false);
			
			PublicationCRUDBean publicationBean = new PublicationCRUDBean();
			publicationBean.setPublication(publication);
			
			List<TAttachedFile> attachedFiles = new ArrayList<TAttachedFile>();
			for (int i = 2; i < this.getFile().length; i++) {
				TAttachedFile attachedFile = new TAttachedFile();
				
				if(this.getFilechecked()[i-2].equals("Privado"))
					attachedFile.setIsPublic(false);
				else attachedFile.setIsPublic(true);
				
				StringTokenizer tokens = new StringTokenizer(this.getFileFileName()[i],".");
				
				if(tokens.hasMoreTokens())
					attachedFile.setFileName(tokens.nextToken());
				
				if(tokens.hasMoreTokens())
					attachedFile.setFileExtension(tokens.nextToken());
				
				attachedFiles.add(attachedFile);
			}

			publicationBean.setAttachedFiles(attachedFiles);
			
			String id = publicationService.addPublication(publicationBean);
			
			String directory = PathConstants.ATTACHED_DIRECTORY + campaign.getCampaignId() + File.separator + id;
			
			if(NumberUtils.isDigits(id)){
				
				for(int i=0; i < getFile().length; i++){
					//System.out.println("File Name is:"+getFileFileName()[i]);
					//System.out.println("File ContentType is:"+getFileContentType()[i]);
					
					try {
						FilesUtil.saveFile(getFile()[i], getFileFileName()[i], directory);
					} catch (IOException e) {
						e.printStackTrace();
						return ERROR;
					}
				}
				//System.out.println("File path excel: " + directory+File.separator+getFileFileName()[1]);
				publicationService.loadDataExcel(Integer.valueOf(id), directory+File.separator+getFileFileName()[1]);
				
				return SUCCESS;
				
			}
			else return ERROR;
		}
		

		return ERROR;
		
	}
	
	@Action(value = "UpdatePublicationAction",
	        interceptorRefs={
			        @InterceptorRef(params={"maximumSize","104857600"}, value="fileUpload"),
			        @InterceptorRef("defaultStack"),
			        @InterceptorRef("validation")}
	)
	public String updatePublicationAction(){
		
		System.out.println("*/*/*/*/*/*/*/**/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/ ");
		System.out.println("Tamaño de boleanos: " + this.getFilechecked().length);
		System.out.println("Tamaño de archivos: " + this.getFile().length);
		for(int i = 0 ; i<filechecked.length ; i++)
			System.out.println("boolean["+i+"] : " + filechecked[i]);
		
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
				
				if(tokens.hasMoreTokens())
					attachedFile.setFileName(tokens.nextToken());
				
				if(tokens.hasMoreTokens())
					attachedFile.setFileExtension(tokens.nextToken());
				
				attachedFiles.add(attachedFile);
			}

			publicationBean.setAttachedFiles(attachedFiles);
			
			String id = publicationService.updatePublication(publicationBean);
			
			
			String directory = PathConstants.ATTACHED_DIRECTORY + campaign.getCampaignId() + File.separator + publication.getPublicationId();
			
			
				
				for(int i=0; i < getFile().length; i++){
					//System.out.println("File Name is:"+getFileFileName()[i]);
					//System.out.println("File ContentType is:"+getFileContentType()[i]);
					
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}