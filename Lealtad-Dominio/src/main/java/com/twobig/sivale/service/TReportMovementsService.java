package com.twobig.sivale.service;

import java.io.File;
import java.util.List;

import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.beans.AccountStatusBean;
import com.twobig.sivale.beans.AccountStatusFilterBean;

public interface TReportMovementsService {
	
	//SERVICE FOR ADMIN
	
	/**
	 * This method upload the information of RM to database with his Campaign
	 * @param tCampaign 
	 * @param file with the information of ReportMovements (xls)
	 * @return
	 */
	String uploadRMFile(TCampaign tCampaign, File file);
	
	List<AccountStatusBean> getAllAccountStatusByCompanyId(Integer companyId, String cardNumber);
	
	List<AccountStatusBean> getAccountStatusPendingByCompanyId(Integer companyId, String cardNumber);
	
	List<AccountStatusBean> getAccountStatusWithoutPendingByCompanyId(Integer companyId, String cardNumber);
	
	List<AccountStatusBean> getAccountStatusByCompanyIdAndFilter(Integer companyId, AccountStatusFilterBean filterBean, String cardNumber);
	

}
