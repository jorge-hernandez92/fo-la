package com.twobig.sivale.service;

import com.twobig.sivale.beans.PublicationBean;

public interface ViewPublicationService {
	
	public PublicationBean showPublication(int userId, int publicationId, int profile);
	
	public PublicationBean showPublicationByCardNumber(String cardNumber, int publicationId, int profile);

}
