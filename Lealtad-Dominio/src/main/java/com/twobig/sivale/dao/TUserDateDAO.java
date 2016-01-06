package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.TUserDate;


public interface TUserDateDAO {
	
	public List<TUserDate> getTUserDateByPublicationIdAndUserId(int userId, int publicationId);
	
}
