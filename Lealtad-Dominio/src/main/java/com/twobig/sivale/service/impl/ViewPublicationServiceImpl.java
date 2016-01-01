package com.twobig.sivale.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twobig.sivale.bd.to.CatPublicationUser;
import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.beans.PublicationBean;
import com.twobig.sivale.dao.CatPublicationUserDAO;
import com.twobig.sivale.dao.TAttachedFileDAO;
import com.twobig.sivale.service.ViewPublicationService;

@Service
public class ViewPublicationServiceImpl implements ViewPublicationService {

	@Autowired
	public CatPublicationUserDAO catPublicationUserDAO;

	@Autowired
	public TAttachedFileDAO tAttachedFile;

	@Override
	public PublicationBean showPublication(int userId, int publicationId) {

		List<CatPublicationUser> catPublicationUser = catPublicationUserDAO
				.getCatPublicationUserByPublicationIdAndUserId(userId, publicationId);

		PublicationBean publication = new PublicationBean();

		if (catPublicationUser.size() != 0) {

			String data = catPublicationUser.get(0).getData();

			HTMLParserServiceImpl htmlParser = new HTMLParserServiceImpl();

			String html = htmlParser.getHTML("src/test/resources/template.html", data);

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
