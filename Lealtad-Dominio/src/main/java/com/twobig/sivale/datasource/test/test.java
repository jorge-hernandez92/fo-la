package com.twobig.sivale.datasource.test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twobig.sivale.bd.to.CatProfile;
import com.twobig.sivale.bd.to.RealUsersCampaigns;
import com.twobig.sivale.beans.TUserLogin;
import com.twobig.sivale.hd.to.UserBean;
import com.twobig.sivale.service.CatClassificationCampaignService;
import com.twobig.sivale.service.LoginService;


public class test {
	
	
	public static void login(ClassPathXmlApplicationContext context){
		
		LoginService loginService = (LoginService) context.getBean("loginServiceImpl");
		
		String user   = "admin_1";
		String passwd = "adm-1111";

		
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
			userDetails.put("userName", tUserLogin.getFirstName()+" "+tUserLogin.getLastName1()+" "+tUserLogin.getLastName2());
			userDetails.put("cardNumber", tUserLogin.getTjCardNumber());
			userDetails.put("clientId", tUserLogin.gettCompanies().getIdCompany());	
			System.out.println(userDetails.toString());
			
		} else {
			System.out.println("Usuario o password incorrectos!");
		}
		
	}
	
	public static void clasificaciones(ClassPathXmlApplicationContext context){
		
		CatClassificationCampaignService cccs = 
				(CatClassificationCampaignService) context.getBean("catClassificationCampaignServiceImpl");
		
		cccs.getCatClassificationCampaignByClassificationId(7);
		
//		List<Integer> campaignsByUser = new ArrayList<Integer>();
//		
//		List<RealUsersCampaigns> listA = cccs.getRealUsersCampaignsByUserId(7);  
//		
//		for(RealUsersCampaigns listA2: listA){
//			campaignsByUser.add(listA2.getCampaignId());
//		}
//		
//		System.out.println(cccs.getRelCampaignsClassificationByCampaign((ArrayList<Integer>) campaignsByUser));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			     "classpath:/application-context.xml");
		
		login(context);
		clasificaciones(context);
		
	}
}
