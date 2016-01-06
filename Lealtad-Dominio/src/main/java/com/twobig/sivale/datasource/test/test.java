package com.twobig.sivale.datasource.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.beans.PublicationBean;
import com.twobig.sivale.beans.SearchCampaignBean;
import com.twobig.sivale.beans.TUserLogin;
import com.twobig.sivale.hd.to.UserBean;
import com.twobig.sivale.service.CatClassificationCampaignService;
import com.twobig.sivale.service.FilterCampaignService;
import com.twobig.sivale.service.LoginService;
import com.twobig.sivale.service.TCampaignsService;
import com.twobig.sivale.service.TPublicationService;
import com.twobig.sivale.service.ViewPublicationService;


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
						
			userDetails.put("email", 			tUserLogin.getEmail());
			userDetails.put("functionalities", 	tUserLogin.getFunctionalities());
			userDetails.put("userId", 			tUserLogin.getUserId());
			userDetails.put("rfcClient", 		tUserLogin.gettCompanies().getDescription());
			userDetails.put("clientName", 		tUserLogin.gettCompanies().getName());
			userDetails.put("userName", 		tUserLogin.getFirstName()+" "+tUserLogin.getLastName1()+" "+tUserLogin.getLastName2());
			userDetails.put("cardNumber", 		tUserLogin.getTjCardNumber());
			userDetails.put("clientId", 		tUserLogin.gettCompanies().getIdCompany());	
			System.out.println(userDetails.toString());
			
		} else {
			System.out.println("Usuario o password incorrectos!");
		}
		
	}
	
	public static void clasificaciones(ClassPathXmlApplicationContext context){
		
		CatClassificationCampaignService cccs = 
				(CatClassificationCampaignService) context.getBean("catClassificationCampaignServiceImpl");
		
		List<CatClassificationCampaign> clasificaciones = cccs.getCatClassificationCampaignByUserId(7);
		
		for (CatClassificationCampaign catClassificationCampaign : clasificaciones) {
			System.out.println(catClassificationCampaign.toString());
		}
		
	}
	
	public static void campañas(ClassPathXmlApplicationContext context){
		TCampaignsService cccs = (TCampaignsService) context.getBean("TCampaignsServiceImpl");
		List<CampaignDetailBean> campaignDetailBeanList =  
				cccs.getCampaignByUserIdAndClassificationCampaignsId(7, 7);
		
		for (CampaignDetailBean campaignDetailBean2 : campaignDetailBeanList) {
			System.out.println(campaignDetailBean2.toString());
		}
	}
	
	public static void publicaciones(ClassPathXmlApplicationContext context){
		TPublicationService cccs = 
		(TPublicationService) context.getBean("TPublicationServiceImpl");
		
		List<TPublication> publicaciones = cccs.getTPublicationByUserIdAndCampaignId(7, 1);
		
		for (int i = 0; i < publicaciones.size(); i++) {
			System.out.println(publicaciones.get(i).toString() + " ");
			System.out.print(publicaciones.get(i).getCatPublicationType());
		}
	}
	
	public static void mostrarPublicaciones(ClassPathXmlApplicationContext context){
		
		ViewPublicationService cccs = 
				(ViewPublicationService) context.getBean("viewPublicationServiceImpl");
		
		PublicationBean publicationBean = cccs.showPublication(7, 1);
		
		if(publicationBean != null){
			
			for (TAttachedFile files : publicationBean.getListFiles()) {
				System.out.println(files.toString());
			}
			
			System.out.println(publicationBean.getHtml());
		}
	}
			
	public static void filterCampaigns(ClassPathXmlApplicationContext context) {

		FilterCampaignService cccs = (FilterCampaignService) context.getBean("filterCampaignServiceImpl");

		SearchCampaignBean searchCampaignBean = new SearchCampaignBean();

		String pattern = "yyyy-MM-dd";

		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			Date startDate = format.parse("2015-12-01");
			Date endDate = format.parse("2016-01-01");
			
//			Date startDate = format.parse("2015-09-01 00:00:00");
//			Date endDate = format.parse("2015-10-01 00:00:00");
			
//			Date startDate = format.parse("2015-09-01 00:00:00");
//			Date endDate = format.parse("2015-10-01 00:00:00");
			
			//2015-09-01
			//2015-09-30

			searchCampaignBean.setClassificationParentId(7);
			searchCampaignBean.setCampaignName("cam");
			searchCampaignBean.setStartDate(startDate);
			searchCampaignBean.setEndDate(endDate);
			searchCampaignBean.setClassificationName1("clase5");
			searchCampaignBean.setClassificationName2("clase2");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<CampaignDetailBean> listCampaignDetailBean =  cccs.FilterCampaign(7, searchCampaignBean);
		
		for (CampaignDetailBean campaignDetailBean : listCampaignDetailBean) {
			System.out.println(campaignDetailBean.toString());
		}

	}
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			     "classpath:/application-context.xml");
		
//		//SERVICIO DE LOGIN PARA ADMINISTRADOR
//		login(context);
//
//		
//		//SERVICIO DE CLASIFICACIONES 
//		clasificaciones(context);
//		
//				
//		//SERVICIO DE CAMPAÑAS
//		campañas(context);
//		
//		
//		//SERVICIO DE PUBLICACIONES
//		publicaciones(context);
//		
//		
//		//SERVICIO MOSTRAR PUBLICACIONES
//		mostrarPublicaciones(context);
		
		
		//SERVICIO DE FILTRARCAMPAÑAS
		filterCampaigns(context);
		
	}
}
