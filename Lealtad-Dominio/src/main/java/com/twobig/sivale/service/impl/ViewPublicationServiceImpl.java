package com.twobig.sivale.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.bd.to.TUserData;
import com.twobig.sivale.beans.PublicationBean;
import com.twobig.sivale.constants.CommonsConstants;
import com.twobig.sivale.constants.PathConstants;
import com.twobig.sivale.dao.TAttachedFileDAO;
import com.twobig.sivale.dao.TPublicationDAO;
import com.twobig.sivale.dao.TUserDataDAO;
import com.twobig.sivale.dao.UserDAO;
import com.twobig.sivale.service.ViewPublicationService;
import com.twobig.sivale.utils.ImageUtils;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ViewPublicationServiceImpl implements ViewPublicationService {
	
	@Autowired
	public TUserDataDAO tUserDateDAO;

	@Autowired
	public TAttachedFileDAO tAttachedFile;

	@Autowired
	public TPublicationDAO tpublicationDAO;
	
	@Autowired
	public UserDAO userDAO;
	
	private static final Logger logger = LogManager.getLogger(ViewPublicationServiceImpl.class);

	@Override
	public PublicationBean showPublication(int userId, int publicationId, int profile) {
		
		List<TUserData>  tUserDate = tUserDateDAO.getTUserDataByPublicationIdAndUserId(userId, publicationId);
		TPublication tpublication = tpublicationDAO.getPublicationById(publicationId);
		PublicationBean publication = new PublicationBean();

		if (tUserDate.size() != 0 || profile == 0 ) {

			String data = null;
			
			if(tUserDate.size() != 0)
				data = tUserDate.get(0).getData();
			
			HTMLParserServiceImpl htmlParser = new HTMLParserServiceImpl();
			
			String htmlPath = PathConstants.ATTACHED_DIRECTORY + tpublication.gettCampaignId() + File.separator
					+ tpublication.getPublicationId() + File.separator + tpublication.getTemplateFilePath();
			logger.info("htmlPath : " + htmlPath);
			
			String html = htmlParser.getHTML(htmlPath, data);

			publication.setHtml(html);
			
			if (tpublication.getImagePath() != null) {
				
				// path for get image of publication to set in html background
				String imagePathPublication = PathConstants.ATTACHED_DIRECTORY + tpublication.gettCampaignId()
						+ File.separator + tpublication.getPublicationId() + File.separator
						+ tpublication.getImagePath();

				ImageUtils imageUtils = new ImageUtils();

				try {
					String image65 = imageUtils.imageToBase64(imagePathPublication);
					publication.setImage("data:image/png;base64,"+image65);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				// SET A DEFAULT IMAGE
			}
			


			//SEPARAR OBTENER ARCHIVOS ADJUNTOS EN UN NUEVO SERVICIO 
			
			List<TAttachedFile> files = tAttachedFile.getTAttachedFileByPublicationId(publicationId);
			
			
			//PARA EL PARTICIPANTE SOLO TRAER LOS QUE ESTAN PUBLICOS (ARCHIVOS ADJUNTOS)
			if ( CommonsConstants.CAT_PROFILE_ADMIN != profile ){
				for (int i = 0 ; i < files.size() ; i++){
					if ( !files.get(i).getIsPublic()  ){
						files.remove(files.get(i));
						i--;
					}
				}
			}
			
			publication.setListFiles(files);
			

		} else {
			logger.info("lista vacia");
			return null;
		}
		
		return publication;
	}

	@Override
	public PublicationBean showPublicationByCardNumber(String cardNumber, int publicationId, int profile) {
		
		Integer userId = userDAO.getUserIdByAccountNumber(cardNumber);
		
		
		
		if(userId != null){
			List<TUserData>  tUserDate = tUserDateDAO.getTUserDataByPublicationIdAndUserId(userId, publicationId);
			
			TPublication tpublication = tpublicationDAO.getPublicationById(publicationId);
			PublicationBean publication = new PublicationBean();

			if (tUserDate.size() != 0 ) {

				String data = null;
				
				if(tUserDate.size() != 0)
					data = tUserDate.get(0).getData();
				
				HTMLParserServiceImpl htmlParser = new HTMLParserServiceImpl();
				
				String htmlPath = PathConstants.ATTACHED_DIRECTORY + tpublication.gettCampaignId() + File.separator
						+ tpublication.getPublicationId() + File.separator + tpublication.getTemplateFilePath();
				logger.info("htmlPath : " + htmlPath);
				
				String html = htmlParser.getHTML(htmlPath, data);

				publication.setHtml(html);
				
				
				if (tpublication.getImagePath() != null) {
					
					// path for get image of publication to set in html background
					String imagePathPublication = PathConstants.ATTACHED_DIRECTORY + tpublication.gettCampaignId()
							+ File.separator + tpublication.getPublicationId() + File.separator
							+ tpublication.getImagePath();

					ImageUtils imageUtils = new ImageUtils();

					try {
						String image65 = imageUtils.imageToBase64(imagePathPublication);
						publication.setImage("data:image/png;base64,"+image65);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} else {
					// SET A DEFAULT IMAGE
				}

				//SEPARAR OBTENER ARCHIVOS ADJUNTOS EN UN NUEVO SERVICIO 
				
				List<TAttachedFile> files = tAttachedFile.getTAttachedFileByPublicationId(publicationId);
				
				
				//PARA EL PARTICIPANTE SOLO TRAER LOS QUE ESTAN PUBLICOS (ARCHIVOS ADJUNTOS)
				if ( CommonsConstants.CAT_PROFILE_ADMIN != profile ){
					for (int i = 0 ; i < files.size() ; i++){
						if ( !files.get(i).getIsPublic()  ){
							files.remove(files.get(i));
							i--;
						}
					}
				}
				
				publication.setListFiles(files);
				return publication;
				
			} else {
				logger.info("lista vacia");
				return null;
			}

		}
		else{
			logger.info("no exite usuario con la tarjeta: "+cardNumber);
			return null; 
		}
		
	}
}
