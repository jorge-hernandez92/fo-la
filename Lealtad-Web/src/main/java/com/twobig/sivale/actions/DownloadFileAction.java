package com.twobig.sivale.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TUser;
import com.xm.sivale.services.test.ServicesUser;

@ParentPackage(value = "json-default")
@Namespace("/")
public class DownloadFileAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	
	private InputStream fileInputStream;
	  
	public InputStream getFileInputStream() {
	 
		return fileInputStream;
	   
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}
	
	@SuppressWarnings("unchecked")
	@Action(value = "getFileAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"fileInputStream", "excludeNullProperties", "true", "noCache", "true" }) )
	public String getFileAction() {
		System.out.println("****////  ////****");
		try {
			fileInputStream = new FileInputStream(new File("C:\\wp.JPG"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return SUCCESS;

	}

}
