package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TReportMovements;
import com.twobig.sivale.beans.AccountStatusFilterBean;

public interface TReportMovementsDAO {
	
	
	
	static final String QUERY_DELETE_ALL_BY_CAMPAIGN= "delete from TReportMovements where campaign = :campaign";
	
	Boolean insertRM(TReportMovements tReportMovements);
	
	void deleteAllByCampaign(TCampaign tCampaign);
	
	
	List<TReportMovements> getTReportMovementsNoRepeatByCompanyId(Integer companyId, String numberCard);
	
	List<TReportMovements> getTReportMovementsByIdStarsCompanyIdMovement(Integer companyId, String idStars, String movement, String numberCard);
	
	List<TReportMovements> getAllTReportMovementsByCompanyIdAndFilter(Integer companyId, AccountStatusFilterBean filterBean, String numberCard);

}

