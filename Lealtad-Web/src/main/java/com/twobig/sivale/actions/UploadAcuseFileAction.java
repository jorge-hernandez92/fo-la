package com.twobig.sivale.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.constants.PathConstants;
import com.twobig.sivale.service.TAttachedFileService;
import com.twobig.sivale.utils.FilesUtil;

@ParentPackage(value = "json-default")
@Namespace("/")
public class UploadAcuseFileAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(UploadAcuseFileAction.class);
	private byte[] byteFileAcuse;
	private InputStream fileInputStream;
	private String acuseId;
	private String acuseName;
	private String[] filesAcuseFileName;
	private File[] filesAcuse;
	private Map<String, Object> session;
	private List<TAttachedFile> listAcuseFile;
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
	
	@SuppressWarnings("unchecked")
	@Action(value = "getListAcuseFilesAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"listAcuseFile", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getListAcuseFilesAction() {
		logger.info("getListAcuseFiles");
		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}
		listAcuseFile = tAttachedFileService.getListTAttachedFileAcuse();
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "getFileAcuseAction", results = @Result(name = SUCCESS, type = "json", params = { "root", "byteFileAcuse",
			"excludeNullProperties", "true", "noCache", "true" }) )
	public String getFileAcuseAction() {
		String path = String.valueOf(acuseId + "/" + acuseName);
		try {
			fileInputStream = new FileInputStream(new File(PathConstants.ATTACHED_ACUSE_FILE + path));
			byteFileAcuse = IOUtils.toByteArray(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public List<TAttachedFile> getListAcuseFile() {
		return listAcuseFile;
	}

	public void setListAcuseFile(List<TAttachedFile> listAcuseFile) {
		this.listAcuseFile = listAcuseFile;
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
	
	public String getAcuseId() {
		return acuseId;
	}

	public void setAcuseId(String acuseId) {
		this.acuseId = acuseId;
	}

	public String getAcuseName() {
		return acuseName;
	}

	public void setAcuseName(String acuseName) {
		this.acuseName = acuseName;
	}

	public byte[] getByteFileAcuse() {
		return byteFileAcuse;
	}

	public void setByteFileAcuse(byte[] byteFileAcuse) {
		this.byteFileAcuse = byteFileAcuse;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
