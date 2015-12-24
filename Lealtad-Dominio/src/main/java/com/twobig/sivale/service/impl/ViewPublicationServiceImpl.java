package com.twobig.sivale.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.CatPublicationUser;
import com.twobig.sivale.beans.PublicationBean;
import com.twobig.sivale.dao.CatPublicationUserDAO;
import com.twobig.sivale.service.ViewPublicationService;



@Service
public class ViewPublicationServiceImpl implements ViewPublicationService {
	
	@Autowired
	public CatPublicationUserDAO catPublicationUserDAO;

	@Override
	public PublicationBean showPublication(int userId, int publicationId) {
		
		List<CatPublicationUser> catPublicationUser = 
				catPublicationUserDAO.getCatPublicationUserByPublicationIdAndUserId(userId, publicationId);
		
		if(catPublicationUser.size() != 0){
			
		}else{
			return null;
		}
		
		return null;
	}
}
