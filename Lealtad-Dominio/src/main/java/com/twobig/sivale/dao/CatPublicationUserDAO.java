package com.twobig.sivale.dao;

import java.util.List;
import com.twobig.sivale.bd.to.CatPublicationUser;

public interface CatPublicationUserDAO {
	
	public List<CatPublicationUser> getCatPublicationUserByPublicationIdAndUserId(int userId, int publicationId);
	
}
