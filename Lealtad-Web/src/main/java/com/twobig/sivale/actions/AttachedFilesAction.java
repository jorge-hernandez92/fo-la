package com.twobig.sivale.actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.constants.PathConstants;
import com.twobig.sivale.service.TPublicationService;

@ParentPackage(value = "json-default")
@Namespace("/")
public class AttachedFilesAction extends ActionSupport implements SessionAware {

	@Autowired
	TPublicationService publicationService;
	
	private Map<String, Object> session;
	
	private Map<String, String> message;

	public static final String CODE = "code";
	public static final String MESSAGE = "message";
	
	public static final String SUCCESS_CODE = "001";
	public static final String ERROR_CODE 	= "002";
	
	public static final String ERROR_DELETE_ATTACHEDFILE 	= "Se produjo un error al eliminar el archivo";
	public static final String ERROR_UPDATE_ATTACHEDFILE	= "Se produjo un error al actualizar el archivo";
	public static final String SUCCESS_DELETE_ATTACHEDFILE 	= "Archivo eliminado correctamente";
	public static final String SUCCESS_UPDATE_ATTACHEDFILE 	= "Archivo actualizado correctamente";
	
	@SuppressWarnings("unchecked")
	@Action(value = "updateAttachedFileAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"message", "excludeNullProperties", "true", "noCache", "true" }) )
	public String updateAttachedFileAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String attachedFileJSON = request.getParameter("attachedFile");
		
		
		TAttachedFile attachedFile;

		if (!attachedFileJSON.equals("undefined")) {

			attachedFile = new TAttachedFile();
			try {
				attachedFile = new ObjectMapper().readValue(attachedFileJSON,
						TAttachedFile.class);
			} catch (IOException e) {
				e.printStackTrace();
				setMessage(ERROR_CODE, ERROR_UPDATE_ATTACHEDFILE);
				return ERROR;
			}

		} else {
			setMessage(ERROR_CODE, ERROR_UPDATE_ATTACHEDFILE);
			return ERROR;
			
		}
		
		List<TAttachedFile> list = new ArrayList<TAttachedFile>();
		list.add(attachedFile);
		
		publicationService.updateListAttachedFiles(list);
		
		setMessage(SUCCESS_CODE, SUCCESS_UPDATE_ATTACHEDFILE);
		return SUCCESS;

	}
	
	
	@SuppressWarnings("unchecked")
	@Action(value = "deleteAttachedFileAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"message", "excludeNullProperties", "true", "noCache", "true" }) )
	public String deleteAttachedFileAction() {

		final HttpServletRequest request = ServletActionContext.getRequest();

		String attachedFileJSON = request.getParameter("attachedFile");
		
		
		TAttachedFile attachedFile;

		if (!attachedFileJSON.equals("undefined")) {

			attachedFile = new TAttachedFile();
			try {
				attachedFile = new ObjectMapper().readValue(attachedFileJSON,
						TAttachedFile.class);
			} catch (IOException e) {
				e.printStackTrace();
				setMessage(ERROR_CODE, ERROR_DELETE_ATTACHEDFILE);
				return ERROR;
			}

		} else {
			setMessage(ERROR_CODE, ERROR_DELETE_ATTACHEDFILE);
			return ERROR;
			
		}
		
		List<TAttachedFile> list = new ArrayList<TAttachedFile>();
		list.add(attachedFile);
		
		
		publicationService.deleteListAttachedFiles(list);
		
		try{
			TPublication pub = (TPublication) session.get("publication");

			if (pub != null) {
				
				String directory = PathConstants.ATTACHED_DIRECTORY + pub.gettCampaignId() + File.separator + pub.getPublicationId();
				String pathfile = directory + File.separator + attachedFile.getFileName() + "." + attachedFile.getFileExtension();
				System.out.println("**** archivo adjunto a eliminar: "+ pathfile);
				File file = new File(pathfile);
				if(file.delete())
				System.out.println("**** Se eliminó archivo adjunto");
			}
			
		}catch(Exception e){
			System.out.println("Error al eliminar archivo adjunto");
		}
		
		setMessage(SUCCESS_CODE, SUCCESS_DELETE_ATTACHEDFILE);
		return SUCCESS;

	}
	
	public void setMessage(String code, String message){
		this.message = new HashMap <String, String>();
		this.message.put(CODE, code);
		this.message.put(MESSAGE, message);
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public Map<String, String> getMessage() {
		return message;
	}

	
}
