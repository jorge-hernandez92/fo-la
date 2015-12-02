package com.twobig.sivale.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TUser;
import com.xm.sivale.services.test.ServicesUser;

@ParentPackage(value = "json-default")
@Namespace("/")
public class LoginAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private String username;
	private String password;
	private TUser user;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Action(value="login", results = { @Result(name="success", location="/secured/home_user.html"), 
			@Result(name = ERROR, location = "/secured/login.html")})
	public String login() {
		
		HttpServletRequest requestPrincipal = ServletActionContext.getRequest();

		System.out.println(username+"  "+password);
		
		if (username.equals("") || password.equals(""))
			return ERROR;
		else{
			
			ServicesUser services = new ServicesUser();
			
			user = services.getUser(username, password);
	        
	        if (user != null){
	        	session.put("user", user);
	        	System.out.println(user.getFullName());
	    		return SUCCESS;
	        }
	        
	        return ERROR;
		}
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TUser getUser() {
		return user;
	}

	public void setUser(TUser user) {
		this.user = user;
	}
	
	
}
