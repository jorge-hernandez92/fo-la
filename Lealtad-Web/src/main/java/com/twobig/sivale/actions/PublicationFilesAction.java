package com.twobig.sivale.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.beans.ExcelBean;
import com.twobig.sivale.beans.PublicationCRUDBean;
import com.twobig.sivale.constants.CommonsConstants;
import com.twobig.sivale.constants.PathConstants;
import com.twobig.sivale.service.ExcelService;
import com.twobig.sivale.service.TPublicationService;
import com.twobig.sivale.utils.FilesUtil;

@Namespace("/")
public class PublicationFilesAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -4748500436762141116L;

	@Autowired
	private TPublicationService publicationService;
	@Autowired
	private ExcelService excelService;

	private Map<String, Object> session;
	private File[] file;
	private String[] fileContentType;
	private String[] fileFileName;
	private static final Logger logger = LogManager.getLogger(PublicationFilesAction.class);
	
	@Action(value = "UploadHtmlAction", results = { @Result(name=SUCCESS, location="/secured/home_admin.jsp"),
			@Result(name = ERROR, location = "/secured/home_admin.jsp")},
			interceptorRefs = {
			@InterceptorRef(params = { "maximumSize", "104857600" }, value = "fileUpload"),
			@InterceptorRef("defaultStack"), @InterceptorRef("validation") })
	public String uploadHtmlAction() {
		boolean delete = true;
		if (getFile() !=null && getFile().length > 0) {
			TCampaign campaign = (TCampaign) session.get("campaign");
			if (campaign == null) {
				logger.error("No existe campaña");
				return ERROR;
			}
			TPublication publication = (TPublication) session.get("publication");
			if (publication == null) {
				logger.error("No existe publicación");
				return ERROR;
			}
			if(publication.getTemplateFilePath().equals(getFileFileName()[0]))
				delete = false;	
			String directory = PathConstants.ATTACHED_DIRECTORY + campaign.getCampaignId() + File.separator + publication.getPublicationId();
			try {
				FilesUtil.saveFile(getFile()[0], getFileFileName()[0], directory);
			} catch (IOException e) {
				logger.error("Error al guardar archivo");
				e.printStackTrace();
				return ERROR;
			}
			String htmlFileName = publication.getTemplateFilePath();
			publication.setTemplateFilePath(this.getFileFileName()[0]);
			PublicationCRUDBean publicationBean = new PublicationCRUDBean();
			publicationBean.setPublication(publication);
			List<TAttachedFile> attachedFiles = new ArrayList<TAttachedFile>();
			publicationBean.setAttachedFiles(attachedFiles);
			String status =  publicationService.updatePublication(publicationBean);
			if( status.equals("SUCCESS") && delete){
				try{
					String pathfile = directory + File.separator + htmlFileName;
					File file = new File(pathfile);
					if(file.delete()){}		
				}catch(Exception e){
					logger.error("Error al eliminar HTML");
				}
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
	@Action(value = "UploadExcelAction", results = { @Result(name=SUCCESS, location="/secured/home_admin.jsp"),
			@Result(name = ERROR, location = "/secured/home_admin.jsp")}, 
			interceptorRefs = {
			@InterceptorRef(params = { "maximumSize", "104857600" }, value = "fileUpload"),
			@InterceptorRef("defaultStack"), @InterceptorRef("validation") })
	public String uploadExcelAction() {
		boolean delete = true;
		if (getFile() !=null && getFile().length > 0) {
			TCampaign campaign = (TCampaign) session.get("campaign");
			if (campaign == null) {
				logger.error("No existe campaña");
				return ERROR;
			}
			TPublication publication = (TPublication) session.get("publication");
			if (publication == null) {
				logger.error("No existe publicacion");
				return ERROR;
			}
			if(publication.getDataFilePath().equals(getFileFileName()[0]))
				delete = false;
			String directory = PathConstants.ATTACHED_DIRECTORY + campaign.getCampaignId() + File.separator + publication.getPublicationId();
			try {
				FilesUtil.saveFile(getFile()[0], getFileFileName()[0], directory);
			} catch (IOException e) {
				logger.error("Arror al guardar el archivo");
				e.printStackTrace();
				return ERROR;
			}
			if (delete) {
				try {
					String pathfile = directory + File.separator + publication.getDataFilePath();
					File file = new File(pathfile);
					if (file.delete()){}
				} catch (Exception e) {
					logger.error("Error al generar archivo");
				}
			}
			publication.setDataFilePath(this.getFileFileName()[0]);
			PublicationCRUDBean publicationBean = new PublicationCRUDBean();
			publicationBean.setPublication(publication);
			List<TAttachedFile> attachedFiles = new ArrayList<TAttachedFile>();
			publicationBean.setAttachedFiles(attachedFiles);
			String status =  publicationService.updatePublication(publicationBean);
			if( status.equals("ERROR")){
				return ERROR;
			}
			String excelPath = directory+ File.separator + publication.getDataFilePath();
			ExcelBean excelBean = excelService.getExcelData(excelPath);
			if(excelBean == null){
				return ERROR;
			}
			if(excelService.getFormatList(excelBean, CommonsConstants.COLUMN_ID_EXCEL) == null){
				return ERROR;
			}
			publicationService.updateExcel(publication, excelPath);
			return SUCCESS;
		}
		return ERROR;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
