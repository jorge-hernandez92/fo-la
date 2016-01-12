package com.twobig.sivale.datasource.test;



import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twobig.sivale.bd.to.CatPublicationType;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.beans.CampaignDetailAdminBean;
import com.twobig.sivale.beans.PublicationInsertBean;
import com.twobig.sivale.service.TCampaignsService;
import com.twobig.sivale.service.TPublicationService;

public class PruebasAdministrador {
	
	public static void getCampaingsSuper(ClassPathXmlApplicationContext context){
		
		TCampaignsService cccs = (TCampaignsService) context.getBean("TCampaignsServiceImpl");
		  
		List<CampaignDetailAdminBean> listCampaignDetailAdminBean = cccs.getCampaingsSuper(7);
		
		for (CampaignDetailAdminBean campaignDetailAdminBean : listCampaignDetailAdminBean) {
			System.out.println(campaignDetailAdminBean.toString());
		}
		
	}
	
	public static void insertPublicacion(ClassPathXmlApplicationContext context){
		PublicationInsertBean pib = new PublicationInsertBean();
		TPublication publication = new TPublication();
		publication.settCampaignId(1);
		publication.setName("PRUEBA INSERCCION 1");
		CatPublicationType cpt = new CatPublicationType();
		cpt.setPublicationTypeId(1);
		publication.setCatPublicationType(cpt);
		pib.setPublication(publication);
		TPublicationService cccs = (TPublicationService) context.getBean("TPublicationServiceImpl");
		
		List<TAttachedFile> attachedFiles = new ArrayList<TAttachedFile>();
		
		for (int i = 0; i < 5; i++){
			attachedFiles.add(new TAttachedFile());
		}
		
		pib.setAttachedFiles(attachedFiles);
		
		System.out.println(cccs.addPublication(pib));
	}
	
	public static void updatePublication(ClassPathXmlApplicationContext context){
		
		TPublicationService cccs = (TPublicationService) context.getBean("TPublicationServiceImpl");
		
		PublicationInsertBean pib = new PublicationInsertBean();
		TPublication publication = new TPublication();
		publication.setPublicationId(20);
		publication.settCampaignId(1);
		publication.setName("PRUEBA ACTUALIZACION 11");
		CatPublicationType cpt = new CatPublicationType();
		cpt.setPublicationTypeId(1);
		publication.setCatPublicationType(cpt);
		pib.setPublication(publication);
		
		
		List<TAttachedFile> attachedFiles = new ArrayList<TAttachedFile>();
		
		for (int i = 0; i < 5; i++){
			TAttachedFile attachedFile = new TAttachedFile();
			attachedFile.setAttachedFileId((24+i));
			attachedFile.settPublicationId(20);
			attachedFile.setFileName("PRUEBA ACTUALIZACION ARCHIVOS ADJUNTOS");
			attachedFiles.add(attachedFile);
		}
		
		pib.setAttachedFiles(attachedFiles);
		
		System.out.println(cccs.updatePublication(pib));
		
	}
	
	public static void main(String[] args){
		
		//BasicConfigurator.configure();
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			     "classpath:/application-context.xml");
		
		//SERVICIO DE OBTENER CAMPAÑAS 
		//getCampaingsSuper(context);
		
		//SERVICIO DE INSERTAR PUBLICACIONES
		//insertPublicacion(context);
		
		//SERVICIO DE ACTUALIZAR PUBLICATION
		//updatePublication(context);
	}

}
