package com.twobig.sivale.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.constants.CommonsConstants;
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
	private String error = null;
	
	private static final Logger logger = LogManager.getLogger(LoginAction.class);
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Action(value="login", results = { @Result(name="user", location="/secured/home_user.jsp"),
			@Result(name="admin", location="/secured/home_admin.jsp"),
			@Result(name = ERROR, location = "/secured/login.jsp")})
	public String login() {
		
		//HttpServletRequest requestPrincipal = ServletActionContext.getRequest();
		
		logger.info("login");

		if ( username == null || password == null || username.equals("") || password.equals("")){
			
			TUser user = (TUser)session.get("user");
		
			if (user!=null) {
				UserBean userBean = new UserBean();
				userBean.setPass(user.getPassword());
				
				if(user.getCatProfile()== CommonsConstants.CAT_PROFILE_ADMIN)
					userBean.setUser(user.getUserLogin());
				else
					userBean.setUser(user.getTjCardNumber());
				
				user = (TUser) loginService.validateUserWeb(userBean);
				
		        if (user != null){
		        	session.put("user", user);
		        	
		        	if(user.getCatProfile() == CommonsConstants.CAT_PROFILE_ADMIN){
		        		return "admin";
		        	}
		        	return "user";
		        }
		        
		        error = "Usuario o password incorrectos!";
		        
		        return ERROR;
			}
			
			return ERROR;
		}
		else{
			
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
	        
	        error = "Usuario o password incorrectos!";
	        
	        return ERROR;
		}
		
	}
	
	@Action(value="Lincoln", results = { @Result(name="user", location="/secured/home_user.jsp"),
			@Result(name="admin", location="/secured/home_admin.jsp"),
			@Result(name = ERROR, location = "/secured/loginLincoln.jsp")})
	public String loginLincoln() {
		
		HttpServletRequest requestPrincipal = ServletActionContext.getRequest();

		if ( username == null || password == null || username.equals("") || password.equals("")){
			
			TUser user = (TUser)session.get("user");
		
			if (user!=null) {
				UserBean userBean = new UserBean();
				userBean.setPass(user.getPassword());
				
				if(user.getCatProfile()== CommonsConstants.CAT_PROFILE_ADMIN)
					userBean.setUser(user.getUserLogin());
				else
					userBean.setUser(user.getTjCardNumber());
				
				user = (TUser) loginService.validateUserWeb(userBean);
				
		        if (user != null){
		        	session.put("user", user);
		        	
		        	if(user.getCatProfile() == CommonsConstants.CAT_PROFILE_ADMIN){
		        		return "admin";
		        	}
		        	return "user";
		        }
		        
		        error = "Usuario o password incorrectos!";
		        
		        return ERROR;
			}
			
			return ERROR;
		}
		else{
			
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
	        
	        error = "Usuario o password incorrectos!";
	        
	        return ERROR;
		}
		
	}
	
	@Action(value="Ford", results = { @Result(name="user", location="/secured/home_user.jsp"),
			@Result(name="admin", location="/secured/home_admin.jsp"),
			@Result(name = ERROR, location = "/secured/loginFord.jsp")})
	public String loginFord() {
		TUser userS = (TUser) session.get("user");
		if(userS!= null){
			if(userS.getCatProfile() == CommonsConstants.CAT_PROFILE_ADMIN){
        		return "admin";
        	}
        	return "user";
		}
		if ( username == null || password == null || username.equals("") || password.equals("")){	
			TUser user = (TUser)session.get("user");
			if (user!=null) {
				UserBean userBean = new UserBean();
				userBean.setPass(user.getPassword());
				if(user.getCatProfile()== CommonsConstants.CAT_PROFILE_ADMIN){
					userBean.setUser(user.getUserLogin());
				}
				else{
					userBean.setUser(user.getTjCardNumber());
				}
				user = (TUser) loginService.validateUserWeb(userBean);
		        if (user != null){
		        	session.put("user", user);
		        	session.put("mensaje", 0);
		        	if(user.getCatProfile() == CommonsConstants.CAT_PROFILE_ADMIN){
		        		return "admin";
		        	}
		        	return "user";
		        }
		        error = "Usuario o password incorrectos!";
		        return ERROR;
			}
			return ERROR;
		}
		else{
			UserBean userBean = new UserBean();
			userBean.setPass(password);
			userBean.setUser(username);
			user = (TUser) loginService.validateUserWeb(userBean);
	        if (user != null){
	        	session.put("user", user);
	        	session.put("mensaje", 0);
	        	if(user.getCatProfile() == 0){
	        		return "admin";
	        	}
	        	return "user";
	        }
	        error = "Usuario o password incorrectos!";
	        return ERROR;
		}
	}

	@Action(value="logout", results = @Result(name="success", location="/secured/loginFord.jsp"))
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

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	
	
	
}
