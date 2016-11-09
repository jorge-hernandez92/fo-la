package com.twobig.sivale.service;

import java.io.File;
import java.util.List;

import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TReportMovements;
import com.twobig.sivale.beans.AccountStatusBean;

public interface TReportMovementsService {
	
	/**
	 * This method upload the information of RM to database with his Campaign
	 * @param tCampaign 
	 * @param file with the information of ReportMovements (xls)
	 * @return
	 */
	String uploadRMFile(TCampaign tCampaign, File file);
	
	List<TReportMovements> getAllTReportMovementsByCampaignId(Integer campaignId);
	
	List<AccountStatusBean> getAllAccountStatusByCampaignId(Integer campaignId);
	
	List<AccountStatusBean> getAccountStatusPendingByCampaignId(Integer campaignId);

}
