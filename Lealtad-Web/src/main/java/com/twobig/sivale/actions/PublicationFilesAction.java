package com.twobig.sivale.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.beans.ExcelBean;
import com.twobig.sivale.beans.FormNewCampaignBean;
import com.twobig.sivale.beans.PublicationCRUDBean;
import com.twobig.sivale.beans.SelectClassificationCampaignBean;
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

	
	@Action(value = "UploadHtmlAction", results = { @Result(name=SUCCESS, location="/secured/home_admin.html"),
			@Result(name = ERROR, location = "/secured/home_admin.html")},
			interceptorRefs = {
			@InterceptorRef(params = { "maximumSize", "104857600" }, value = "fileUpload"),
			@InterceptorRef("defaultStack"), @InterceptorRef("validation") })
	public String uploadHtmlAction() {

		System.out.println("Upload html files size = " + getFile().length);

		if (getFile() !=null && getFile().length > 0) {

			TCampaign campaign = (TCampaign) session.get("campaign");

			if (campaign == null) {
				return ERROR;
			}

			TPublication publication = (TPublication) session.get("publication");
			if (publication == null) {
				return ERROR;
			}
			
			String directory = PathConstants.ATTACHED_DIRECTORY + campaign.getCampaignId() + File.separator + publication.getPublicationId();

			try {
				FilesUtil.saveFile(getFile()[0], getFileFileName()[0], directory);
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
			
			publication.setTemplateFilePath(this.getFileFileName()[0]);
			
			PublicationCRUDBean publicationBean = new PublicationCRUDBean();
			publicationBean.setPublication(publication);

			List<TAttachedFile> attachedFiles = new ArrayList<TAttachedFile>();
			publicationBean.setAttachedFiles(attachedFiles);

			String status =  publicationService.updatePublication(publicationBean);

			if( status.equals("SUCCES")){
				return SUCCESS;
			}
		}

		return ERROR;

	}
	
	@Action(value = "UploadExcelAction", results = { @Result(name=SUCCESS, location="/secured/home_admin.html"),
			@Result(name = ERROR, location = "/secured/home_admin.html")}, 
			interceptorRefs = {
			@InterceptorRef(params = { "maximumSize", "104857600" }, value = "fileUpload"),
			@InterceptorRef("defaultStack"), @InterceptorRef("validation") })
	public String uploadExcelAction() {

		System.out.println("Upload excel files size = " + getFile().length);

		if (getFile() !=null && getFile().length > 0) {

			TCampaign campaign = (TCampaign) session.get("campaign");

			if (campaign == null) {
				return ERROR;
			}

			TPublication publication = (TPublication) session.get("publication");
			if (publication == null) {
				return ERROR;
			}
			
			String directory = PathConstants.ATTACHED_DIRECTORY + campaign.getCampaignId() + File.separator + publication.getPublicationId();

			try {
				FilesUtil.saveFile(getFile()[0], getFileFileName()[0], directory);
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
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
			
			if(excelBean == null)
				return ERROR;
			
			if(excelService.getFormatList(excelBean, CommonsConstants.COLUMN_ID_EXCEL) == null)
				return ERROR;
			
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
