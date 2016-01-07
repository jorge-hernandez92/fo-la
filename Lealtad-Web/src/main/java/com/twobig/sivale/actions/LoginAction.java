package com.twobig.sivale.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.hd.to.UserBean;
import com.twobig.sivale.service.LoginService;

@ParentPackage(value = "json-default")
@Namespace("/")
public class LoginAction extends ActionSupport implements SessionAware {

	@Autowired
	LoginService loginService;
	
	private Map<String, Object> session;

	private String username;
	private String password;
	private TUser user;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Action(value="login", results = { @Result(name="user", location="/secured/home_user.html"),
			@Result(name="admin", location="/secured/home_admin.html"),
			@Result(name = ERROR, location = "/secured/login.html")})
	public String login() {
		
		HttpServletRequest requestPrincipal = ServletActionContext.getRequest();

		if (username.equals("") || password.equals(""))
			return ERROR;
		else{
			
			//ServicesUser services = new ServicesUser();
			//user = services.getUser(username, password);
			
			UserBean userBean = new UserBean();
			userBean.setPass(password);
			userBean.setUser(username);
			
			user = (TUser) loginService.validateUserWeb(userBean);
			
	        if (user != null){
	        	session.put("user", user);
	        	
	        	if(user.getCatProfile() == 0){
	        		return "admin";
	        	}
	        	return "user";
	        }
	        
	        return ERROR;
		}
		
	}

	@Action(value="logout", results = @Result(name="success", location="/secured/login.html"))
	public String logout() {
		
		session.clear();
		return SUCCESS;		
		
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
