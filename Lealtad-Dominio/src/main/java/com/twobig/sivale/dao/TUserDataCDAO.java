package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.TUserDataC;

public interface TUserDataCDAO {
	
	List<TUserDataC> getTUserDataByCampaignIdAndUserId(int userId, int campaignId);
	
	List<TUserDataC> getTUserDataByUserId(int userId);
	
	void insertTUserData(TUserDataC tUserDataC);
	
	void deleteTUserData(TUserDataC tUserDataC);

}
