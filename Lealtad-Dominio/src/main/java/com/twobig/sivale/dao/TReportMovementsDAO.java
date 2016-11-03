package com.twobig.sivale.dao;

import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TReportMovements;

public interface TReportMovementsDAO {
	
	public static final String QUERY_DELETE_ALL_BY_CAMPAIGN= "delete from TReportMovements where campaign = :campaign";
	
	public Boolean insertRM(TReportMovements tReportMovements);
	
	public void deleteAllByCampaign(TCampaign tCampaign);

}
