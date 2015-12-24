package com.twobig.sivale.datasource.test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.beans.TUserLogin;
import com.twobig.sivale.hd.to.UserBean;
import com.twobig.sivale.service.CatClassificationCampaignService;
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
		
		List<CatClassificationCampaign> clasificaciones = cccs.getCatClassificationCampaignByClassificationId(7,1);
		
		
		for (int i = 0; i < clasificaciones.size(); i++){
			 System.out.println(clasificaciones.get(i));
		}
		
	}
	
	public static void campañas(ClassPathXmlApplicationContext context){
		TCampaignsService cccs = 
				(TCampaignsService) context.getBean("TCampaignsServiceImpl");
		
		List<TCampaign> clasificaciones = cccs.getCampaignByUserIdAndClassificationCampaignsId(7, 1); 
				//cccs.getCampaignByUserIdAndCampaignId(7, 1);
		
		
		for (int i = 0; i < clasificaciones.size(); i++){
			 System.out.println(clasificaciones.get(i).toString());
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
		
		cccs.showPublication(7, 1);
	}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			     "classpath:/application-context.xml");
		
//		//SERVICIO DE LOGIN PARA ADMINISTRADOR
//		login(context);
//		
//		//SERVICIO DE CLASIFICACIONES 
//		clasificaciones(context);
//		
//		//SERVICIO DE CAMPAÑAS
//		campañas(context);
//		
//		//SERVICIO DE PUBLICACIONES
//		publicaciones(context);
		
		//SERVICIO MOSTRAR PUBLICACIONES
		mostrarPublicaciones(context);
		
//		HTMLParserServiceImpl htmlParser = new HTMLParserServiceImpl();
//		String data = "{\"BONO 1\":\" $-   \",\"ID STARS GERENTE\":\"000983868\",\"CONCATENADO\":\"M1188SLSMGR\",\"BONO TOTAL\":\" $-   \",\"Ajustado\":\"38 \",\"APELLIDO\":\"GALEANA SOBERANIS\",\"Abs\":\"29%\",\"NOMBRE GERENTE\":\"MICAELA\",\"x\":\"29.00%\",\"BID\":\"M1188\",\"CVP\":\"0\",\"Original\":\"38 \",\"BONO 2\":\" $-   \",\"Razón Social\":\"Acapulco, S.A.\",\"Volumen\":\"11 \"}";
//		String html = htmlParser.getHTML("src/test/resources/template.html", data);
//		//assertNotNull("html Null",html);
//		System.out.println(data);
		
		
	}
}
