package com.twobig.sivale.actions;

import java.io.File;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.service.TCampaignsService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ParentPackage(value = "json-default")
@Namespace("/")
public class UploadRMFileAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	private File[] file;
	private String[] fileFileName;
	
	private static final Logger logger = LogManager.getLogger(UploadFileAction.class);
	
	@Autowired
	private TCampaignsService tCampaignsService;
	
	@Action(value = "UploadRMFile", results = { @Result(name=SUCCESS, location="/secured/home_admin.jsp"),
			@Result(name = ERROR, location = "/secured/home_admin.jsp")},
	        interceptorRefs={
			        @InterceptorRef(params={"maximumSize","104857600"}, value="fileUpload"),
			        @InterceptorRef("defaultStack"),
			        @InterceptorRef("validation")}
	)
	public String uploadRMAction(){
		
		logger.info("UPLOA RM ACTION");
		
		TCampaign campaign = (TCampaign) session.get("campaign");
		
		if (campaign == null) {
			return ERROR;
		}
		else{
			logger.info("Datos de la campaña: "+campaign.toString());
			
			if(file!=null){
				logger.info("Archivo: "+file[0].getName());
				logger.info("Archivo: "+file[0].getParent());
				logger.info("Archivo: "+file[0].getPath());
				logger.info("Nombre Archivo: "+fileFileName[0]);
				
				tCampaignsService.uploadRMFile(campaign, file[0]);
			}
			else{
				logger.info("No se cargó archivo");
			}
		}
		
		
		return SUCCESS;
		
	}
	
	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
