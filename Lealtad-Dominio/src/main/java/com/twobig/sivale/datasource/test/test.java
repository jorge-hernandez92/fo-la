package com.twobig.sivale.datasource.test;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twobig.sivale.bd.to.CatProfile;
import com.twobig.sivale.beans.TUserLogin;
import com.twobig.sivale.hd.to.UserBean;
import com.twobig.sivale.service.LoginService;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			     "classpath:/application-context.xml");
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		LoginService loginService = (LoginService) context.getBean("loginServiceImpl");
		
		String user   = "jorge";
		String passwd = "jorge";

		
		TUserLogin tUserLogin;

		UserBean userBean = new UserBean();
		userBean.setUser(user);
		userBean.setPass(passwd);
		Map<String, Object> userDetails =  new HashMap<String, Object>();
    	
		if ((tUserLogin = loginService.validateUserWeb(userBean)) != null) {			 						
						
			userDetails.put("email", tUserLogin.getEmail());
			userDetails.put("functionalities", tUserLogin.getFunctionalities());
			userDetails.put("userId", tUserLogin.getUserId());
			userDetails.put("rfcClient", tUserLogin.gettCompanies().getDescription());
			userDetails.put("clientName", tUserLogin.gettCompanies().getName());
			userDetails.put("userName", tUserLogin.getFullName());
			userDetails.put("cardNumber", tUserLogin.getTjCardNumber());
			userDetails.put("clientId", tUserLogin.gettCompanies().getIdCompany());	
			
		} else {
			System.out.println("Usuario o password incorrectos!");
		}
	}
}
