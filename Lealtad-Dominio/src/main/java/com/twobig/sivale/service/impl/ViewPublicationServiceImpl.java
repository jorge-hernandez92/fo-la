package com.twobig.sivale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.bd.to.TUserDate;
import com.twobig.sivale.beans.PublicationBean;
import com.twobig.sivale.dao.TAttachedFileDAO;
import com.twobig.sivale.dao.TPublicationDAO;
import com.twobig.sivale.dao.TUserDateDAO;
import com.twobig.sivale.service.ViewPublicationService;

@Service
public class ViewPublicationServiceImpl implements ViewPublicationService {
	
	@Autowired
	public TUserDateDAO tUserDateDAO;

	@Autowired
	public TAttachedFileDAO tAttachedFile;

	@Autowired
	public TPublicationDAO tpublicationDAO;

	@Override
	public PublicationBean showPublication(int userId, int publicationId) {
		
		List<TUserDate>  tUserDate = tUserDateDAO.getTUserDateByPublicationIdAndUserId(userId, publicationId);
		TPublication tpublication = tpublicationDAO.getPublicationById(publicationId);
		PublicationBean publication = new PublicationBean();

		if (tUserDate.size() != 0) {

			String data = tUserDate.get(0).getData();

			HTMLParserServiceImpl htmlParser = new HTMLParserServiceImpl();

			String html = htmlParser.getHTML(tpublication.getTemplateFilePath(), data);

			publication.setHtml(html);

			List<TAttachedFile> files = tAttachedFile.getTAttachedFileByPublicationId(publicationId);
			publication.setListFiles(files);

		} else {
			System.out.println("lista vacia");
			return null;
		}
		return publication;
	}
}
