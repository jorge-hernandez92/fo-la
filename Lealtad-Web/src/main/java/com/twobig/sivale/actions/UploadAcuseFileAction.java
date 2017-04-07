package com.twobig.sivale.actions;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.constants.PathConstants;
import com.twobig.sivale.service.TAttachedFileService;
import com.twobig.sivale.utils.FilesUtil;

public class UploadAcuseFileAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(UploadAcuseFileAction.class);
	private String[] filesAcuseFileName;
	private File[] filesAcuse;
	private Map<String, Object> session;
	@Autowired 
	public TAttachedFileService tAttachedFileService;
	
	@Action(value = "uploadAcuseFileAction", results = { @Result(name=SUCCESS, location="/secured/home_admin.jsp"),
			@Result(name = ERROR, location = "/secured/home_admin.jsp")},
	        interceptorRefs={
			        @InterceptorRef(params={"maximumSize","104857600"}, value="fileUpload"),
			        @InterceptorRef("defaultStack"),
			        @InterceptorRef("validation")})
	public String uploadAcuseFileAction(){
		logger.info("uploadAcuseFileAction");
		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}
		if (filesAcuse == null || filesAcuse.length == 0) {
			return ERROR;
		}
		tAttachedFileService.deleteAcuses();
		saveFiles();
		return SUCCESS; 
	}
	
	private void saveFiles(){
		String directory; 
		for (int i = 0; i < filesAcuse.length; i++) {
			TAttachedFile attachedFile = new TAttachedFile();
			attachedFile.setFileName(filesAcuseFileName[i]);
			attachedFile.setIsAcuse(true);
			tAttachedFileService.insertTAttachedFile(attachedFile);
			directory = PathConstants.ATTACHED_ACUSE_FILE + attachedFile.getAttachedFileId() + File.separator;
			try {
				FilesUtil.saveFile(filesAcuse[i], filesAcuseFileName[i], directory);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String[] getFilesAcuseFileName() {
		return filesAcuseFileName;
	}

	public void setFilesAcuseFileName(String[] filesAcuseFileName) {
		this.filesAcuseFileName = filesAcuseFileName;
	}

	public File[] getFilesAcuse() {
		return filesAcuse;
	}

	public void setFilesAcuse(File[] filesAcuse) {
		this.filesAcuse = filesAcuse;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
