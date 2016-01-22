package com.twobig.sivale.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.twobig.sivale.service.ViewPublicationService;

@Service
public class ViewPublicationServiceImpl implements ViewPublicationService {
	
	@Autowired
	public TUserDataDAO tUserDateDAO;

	@Autowired
	public TAttachedFileDAO tAttachedFile;

	@Autowired
	public TPublicationDAO tpublicationDAO;

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
			System.out.println("htmlPath : " + htmlPath);
			
			String html = htmlParser.getHTML(htmlPath, data);

			publication.setHtml(html);

			List<TAttachedFile> files = tAttachedFile.getTAttachedFileByPublicationId(publicationId);
			
			
			//PARA EL PARTICIPANTE SOLO TRAER LOS QUE ESTAN PUBLICOS (ARCHIVOS ADJUNTOS)
			for (int i = 0 ; i < files.size() ; i++){
			     if ( !files.get(i).getIsPublic()  ){
			      files.remove(files.get(i));
			      i--;
			     }
			    }
			
			publication.setListFiles(files);
			

		} else {
			System.out.println("lista vacia");
			return null;
		}
		
		return publication;
	}
}
