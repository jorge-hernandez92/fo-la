package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.TUserData;


public interface TUserDataDAO {
	
	public List<TUserData> getTUserDataByPublicationIdAndUserId(int userId, int publicationId);
	
	public void insertTUserData(TUserData tUserData);
	
}
