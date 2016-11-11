package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TReportMovements;
import com.twobig.sivale.beans.AccountStatusFilterBean;

public interface TReportMovementsDAO {
	
	static final String QUERY_DELETE_ALL_BY_CAMPAIGN= "delete from TReportMovements where campaign = :campaign";
	
	Boolean insertRM(TReportMovements tReportMovements);
	
	void deleteAllByCampaign(TCampaign tCampaign);
	
	List<TReportMovements> getAllTReportMovementsByCampaignId(Integer campaignId);
	
	List<TReportMovements> getTReportMovementsNoRepeatByCampaignId(Integer campaignId);
	
	List<TReportMovements> getTReportMovementsByIdStarsCampaignIdMovement(Integer campaignId, String idStars, String movement);
	
	List<TReportMovements> getAllTReportMovementsByCampaignIdAndFilter(Integer campaignId, AccountStatusFilterBean accountStatusFilterBean);

}

