package com.twobig.sivale.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.SessionAware;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.service.TPublicationService;

public class AttachedFilesAction extends ActionSupport implements SessionAware {

	@Autowired
	TPublicationService publicationService;
	
	private Map<String, Object> session;
	
	@SuppressWarnings("unchecked")
	@Action(value = "updateAttachedFileAction")
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
				return ERROR;
			}

		} else {
			
			return ERROR;
			
		}
		
		List<TAttachedFile> list = new ArrayList<TAttachedFile>();
		list.add(attachedFile);
		
		publicationService.updateListAttachedFiles(list);
		
		return SUCCESS;

	}
	
	
	@SuppressWarnings("unchecked")
	@Action(value = "deleteAttachedFileAction")
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
				return ERROR;
			}

		} else {
			
			return ERROR;
			
		}
		
		List<TAttachedFile> list = new ArrayList<TAttachedFile>();
		list.add(attachedFile);
		
		publicationService.deleteListAttachedFiles(list);
		
		return SUCCESS;

	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
