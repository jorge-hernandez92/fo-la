package com.twobig.sivale.datasource.test;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twobig.sivale.bd.to.CatPublicationType;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.beans.CampaignDetailAdminBean;
import com.twobig.sivale.beans.FormNewCampaignBean;
import com.twobig.sivale.beans.PublicationCRUDBean;
import com.twobig.sivale.beans.SelectClassificationCampaignBean;
import com.twobig.sivale.service.CatClassificationCampaignService;
import com.twobig.sivale.service.TCampaignsService;
import com.twobig.sivale.service.TPublicationService;

public class PruebasAdministrador {

	public static void getCampaingsSuper(ClassPathXmlApplicationContext context) {

		TCampaignsService cccs = (TCampaignsService) context.getBean("TCampaignsServiceImpl");

		List<CampaignDetailAdminBean> listCampaignDetailAdminBean = cccs.getCampaingsSuper(7);

		for (CampaignDetailAdminBean campaignDetailAdminBean : listCampaignDetailAdminBean) {
			System.out.println(campaignDetailAdminBean.toString());
		}

	}

	public static void insertPublicacion(ClassPathXmlApplicationContext context) {
		
		TPublication publication = new TPublication();
		publication.settCampaignId(1);
		publication.setName("PRUEBA INSERCCION 1");
		publication.setDataFilePath("src/test/resources/FORD.xlsx");
		
		CatPublicationType cpt = new CatPublicationType();
		cpt.setPublicationTypeId(1);
		
		publication.setCatPublicationType(cpt);
		
		PublicationCRUDBean pib = new PublicationCRUDBean();
		pib.setPublication(publication);
		
		TPublicationService cccs = (TPublicationService) context.getBean("TPublicationServiceImpl");

		List<TAttachedFile> attachedFiles = new ArrayList<TAttachedFile>();

		for (int i = 0; i < 5; i++) {
			attachedFiles.add(new TAttachedFile());
		}

		pib.setAttachedFiles(attachedFiles);

		System.out.println(cccs.addPublication(pib));
	}

	public static void updatePublication(ClassPathXmlApplicationContext context) {

		TPublicationService cccs = (TPublicationService) context.getBean("TPublicationServiceImpl");

		PublicationCRUDBean pib = new PublicationCRUDBean();
		TPublication publication = new TPublication();
		publication.setPublicationId(20);
		publication.settCampaignId(1);
		publication.setName("PRUEBA ACTUALIZACION 11");
		CatPublicationType cpt = new CatPublicationType();
		cpt.setPublicationTypeId(1);
		publication.setCatPublicationType(cpt);
		pib.setPublication(publication);

		List<TAttachedFile> attachedFiles = new ArrayList<TAttachedFile>();

		for (int i = 0; i < 5; i++) {
			TAttachedFile attachedFile = new TAttachedFile();
			attachedFile.setAttachedFileId((24 + i));
			attachedFile.settPublicationId(20);
			attachedFile.setFileName("PRUEBA ACTUALIZACION ARCHIVOS ADJUNTOS");
			attachedFiles.add(attachedFile);
		}

		pib.setAttachedFiles(attachedFiles);

		System.out.println(cccs.updatePublication(pib));

	}

	public static void getListClassificationChildren(ClassPathXmlApplicationContext context) {
		
		CatClassificationCampaignService cccs = (CatClassificationCampaignService) context
				.getBean("catClassificationCampaignServiceImpl");

		List<SelectClassificationCampaignBean> clasificaciones = cccs.getListClassificationChildren(30);

		for (SelectClassificationCampaignBean selectClassificationCampaignBean : clasificaciones) {
			System.out.println(selectClassificationCampaignBean.toString());
		}
	}

	public static void getListClassificationParent(ClassPathXmlApplicationContext context) {
		CatClassificationCampaignService cccs = (CatClassificationCampaignService) context
				.getBean("catClassificationCampaignServiceImpl");

		List<SelectClassificationCampaignBean> clasificaciones = cccs.getListClassificationParent(7);

		for (SelectClassificationCampaignBean selectClassificationCampaignBean : clasificaciones) {
			System.out.println(selectClassificationCampaignBean.toString());
		}
	}

	public static void insertCampaign(ClassPathXmlApplicationContext context) {

		TCampaignsService cccs = (TCampaignsService) context.getBean("TCampaignsServiceImpl");

		FormNewCampaignBean formNewCampaignBean = new FormNewCampaignBean();
		formNewCampaignBean.setCampaignName("prueba inserccion");
		formNewCampaignBean.setCompanyId(1);
		formNewCampaignBean.setDescription("descripcion de inserccion");
		formNewCampaignBean.setEndDate(new Date());
		formNewCampaignBean.setStartDate(new Date());

		List<SelectClassificationCampaignBean> classificationList = new ArrayList<SelectClassificationCampaignBean>();

		SelectClassificationCampaignBean scc = new SelectClassificationCampaignBean();
		scc.setId((7));
		classificationList.add(scc);

		for (int i = 1; i < 6; i++) {
			scc = new SelectClassificationCampaignBean();
			scc.setId((-2));
			scc.setName("Nombre prueba inserccion " + (i + 1));
			classificationList.add(scc);
		}

		formNewCampaignBean.setClassificationList(classificationList);
		cccs.insertCampaign(formNewCampaignBean);
	}

	public static void updateCampaign(ClassPathXmlApplicationContext context) {

		TCampaignsService cccs = (TCampaignsService) context.getBean("TCampaignsServiceImpl");

		FormNewCampaignBean formNewCampaignBean = new FormNewCampaignBean();
		formNewCampaignBean.setCampaignId(17);
		formNewCampaignBean.setCampaignName("prueba actualizacion");
		formNewCampaignBean.setCompanyId(1);
		formNewCampaignBean.setDescription("descripcion de actualizacion");
		formNewCampaignBean.setEndDate(new Date());
		formNewCampaignBean.setStartDate(new Date());

		List<SelectClassificationCampaignBean> classificationList = new ArrayList<SelectClassificationCampaignBean>();

		for (int i = 0; i < 6; i++) {
			SelectClassificationCampaignBean scc = new SelectClassificationCampaignBean();
			scc.setId((7 + i));
			scc.setName("Nombre prueba inserccion " + (i + 1));
			classificationList.add(scc);
		}

		formNewCampaignBean.setClassificationList(classificationList);
		cccs.updateCampaign(formNewCampaignBean);
	}

	public static void deletePublication(ClassPathXmlApplicationContext context) {
		TPublicationService cccs = (TPublicationService) context.getBean("TPublicationServiceImpl");
		cccs.deletePublication(18);
	}

	public static void deleteCampaign(ClassPathXmlApplicationContext context) {
		TCampaignsService cccs = (TCampaignsService) context.getBean("TCampaignsServiceImpl");
		cccs.deleteCampaign(17);
	}

	public static void getPublicationType(ClassPathXmlApplicationContext context){
		TPublicationService cccs = (TPublicationService) context.getBean("TPublicationServiceImpl");
		System.out.println(cccs.getPublicationType());
	}
		
	public static void main(String[] args) {

		// BasicConfigurator.configure();

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/application-context.xml");

		 //SERVICIO DE OBTENER CAMPAÑAS
		//getCampaingsSuper(context);

		// SERVICIO DE INSERTAR PUBLICACIONES
		 insertPublicacion(context);

		// SERVICIO DE ACTUALIZAR PUBLICATION
		// updatePublication(context);

		// SERVICIO DE OBTENER LISTA DE CLASIFICACIONES HIJAS
		//getListClassificationChildren(context);

		// OBTENER LISTA DE CLASIFICACIONES PARENT DE COMPAÑÍA A LA QUE
		// PERTENECE UN USUARIO
		// getListClassificationParent(context);

		// SERVCIO PARA INSERTAR CAMPAÑAS CON SUS CLASIFICACIONES
		// -1 NO SE SELECCIONO NINGUNO (NO REVISAR LO DE MAS ABAJO)
		// -2 CREAR UNA CLASIFICACION EL PARENT ES EL ID DE ELEMENTO ANTERIOR
		// insertCampaign(context);

		// SERVICIO PARA ACTUALIZAR CAMPAÑAS
		// updateCampaign(context);

		// ELIMINAR PUBLICACION
		// deletePublication(context);

		// ELIMINAR CAMPAÑA
		// deleteCampaign(context);
		
		//OBTENER TIPO DE PUBLICACIONES
		//getPublicationType(context);
		
	}

}
