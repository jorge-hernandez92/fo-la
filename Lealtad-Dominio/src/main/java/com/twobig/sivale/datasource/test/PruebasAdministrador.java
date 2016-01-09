package com.twobig.sivale.datasource.test;



import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twobig.sivale.beans.CampaignDetailAdminBean;
import com.twobig.sivale.service.TCampaignsService;

public class PruebasAdministrador {
	
	public static void getCampaingsSuper(ClassPathXmlApplicationContext context){
		
		TCampaignsService cccs = (TCampaignsService) context.getBean("TCampaignsServiceImpl");
		  
		List<CampaignDetailAdminBean> listCampaignDetailAdminBean = cccs.getCampaingsSuper(7);
		
		for (CampaignDetailAdminBean campaignDetailAdminBean : listCampaignDetailAdminBean) {
			System.out.println(campaignDetailAdminBean.toString());
		}
		
	}
	
	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			     "classpath:/application-context.xml");
		
		//SERVICIO DE OBTENER CAMPAÑAS 
		getCampaingsSuper(context);
	}

}
