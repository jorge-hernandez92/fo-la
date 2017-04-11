package com.twobig.sivale.actions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TUser;

public class AdminAction extends ActionSupport implements SessionAware{
	
	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger(AdminAction.class);
	
	private Map<String, Object> session;
	
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String usuario;
	private String password;
	private int selectCompany; 
	
	@Action(value = "newAdminAction", results = { @Result(name=SUCCESS, location="/secured/home_admin.jsp"),
			@Result(name = ERROR, location = "/secured/home_admin.jsp")},
	        interceptorRefs={
			        @InterceptorRef(params={"maximumSize","104857600"}, value="fileUpload"),
			        @InterceptorRef("defaultStack"),
			        @InterceptorRef("validation")}
	)
	public String newAdminAction() {
		logger.info("newAdminAction");
		TUser user = (TUser) session.get("user");
		if (user == null) {
			return ERROR;
		}
		logger.info(""+nombre);
		logger.info(""+apellidoPaterno);
		logger.info(""+apellidoMaterno);
		logger.info(""+usuario);
		logger.info(""+password);
		logger.info(""+selectCompany);
		TUser userAdmin = new TUser();
		
		return SUCCESS; 
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSelectCompany() {
		return selectCompany;
	}

	public void setSelectCompany(int selectCompany) {
		this.selectCompany = selectCompany;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

