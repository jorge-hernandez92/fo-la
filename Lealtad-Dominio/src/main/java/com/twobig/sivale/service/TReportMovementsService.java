package com.twobig.sivale.service;

import java.io.File;
import java.util.List;

import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TReportMovements;

public interface TReportMovementsService {
	
	/**
	 * This method upload the information of RM to database with his Campaign
	 * @param tCampaign 
	 * @param file with the information of ReportMovements (xls)
	 * @return
	 */
	public String uploadRMFile(TCampaign tCampaign, File file);
	
	public List<TReportMovements> getAllTReportMovementsByCampaignId(Integer campaignId);

}
