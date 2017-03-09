package com.twobig.sivale.actions;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
import com.twobig.sivale.beans.ExcelBean;
import com.twobig.sivale.beans.ExcelUserCampaignBean;
import com.twobig.sivale.constants.CommonsConstants;
import com.twobig.sivale.constants.PathConstants;
import com.twobig.sivale.service.TAttachedFileService;
import com.twobig.sivale.service.impl.ExcelServiceImpl;
import com.twobig.sivale.utils.FilesUtil;

public class UploadFileUserAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(UploadFileUserAction.class);
	
	private Map<String, Object> session;
	
	private String[] filesFileName;
	
	private File[] files;
	
	@Autowired 
	public TAttachedFileService tAttachedFileService;
	
	@Action(value = "uploadFileUserAction", results = { @Result(name=SUCCESS, location="/secured/home_admin.jsp"),
			@Result(name = ERROR, location = "/secured/home_admin.jsp")},
	        interceptorRefs={
			        @InterceptorRef(params={"maximumSize","104857600"}, value="fileUpload"),
			        @InterceptorRef("defaultStack"),
			        @InterceptorRef("validation")}
	)
	
	public String uploadFileUserAction() {

		TUser user = (TUser) session.get("user");

		logger.info("uploadFileUserAction. CARGA DE ARCHIVO DE USUARIOS");

		if (user == null) {
			return ERROR;
		}

		if (files == null || files.length == 0) {
			return ERROR;
		}
		
		logger.info(""+files[0]);
		logger.info(""+filesFileName[0]);
		
		Integer attachedFileId  = saveFileOnDataBase();
		
		saveFileOnDiskFile(attachedFileId);
		
		loadDataExcel(attachedFileId);
		
		return SUCCESS;
	}
	
	private void loadDataExcel(Integer attachedFileId){
		
		String directory = PathConstants.ATTACHED_USER_FILE + attachedFileId + File.separator;
		
		ExcelServiceImpl excelservice = new ExcelServiceImpl();
		ExcelBean excelBean = excelservice.getExcelData(directory+filesFileName[0]);
		
		System.out.println(excelBean.getHeader().toString());
		
		
		List<ExcelUserCampaignBean> excelCampaign = excelservice.getListUserCampaign(excelBean,CommonsConstants.COLUMN_CARD_NUMBER);
		
		for (ExcelUserCampaignBean excelUserCampaignBean : excelCampaign) {
			System.out.println(excelUserCampaignBean.toString());
		}
//		
//		List<String> listAccountNumber = new ArrayList<String>();
//		for (ExcelUserCampaignBean excelUserCampaignBean : excelCampaign) {
//			listAccountNumber.add(excelUserCampaignBean.getUserId());
//		}
//		
//		List<TUser> listUser= userDAO.getListUserByAccountNumber(listAccountNumber);
//		
//		for (TUser tUser : listUser) {
//			
//			TUserDataC userDataC = new TUserDataC();
//			userDataC.setCampaignId(Integer.parseInt(campaignId));
//			userDataC.setUserId(tUser.getUserId());
//			tUserDataCService.insertTUserData(userDataC);
//			
//		}
		
	}
	
	private void saveFileOnDiskFile(Integer attachedFileId){
		
		String directory = PathConstants.ATTACHED_USER_FILE + attachedFileId + File.separator;
		
		for (int i = 0; i < files.length; i++) {
			try {
				FilesUtil.saveFile(files[i], filesFileName[i], directory);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private Integer saveFileOnDataBase(){
		
		TAttachedFile attachedFile = new TAttachedFile();
		attachedFile.setFileName(filesFileName[0]);
		tAttachedFileService.insertTAttachedFile(attachedFile);
		return attachedFile.getAttachedFileId();
	}

	public String[] getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
}
