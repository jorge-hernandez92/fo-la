package com.twobig.sivale.service;


import java.util.List;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.beans.SelectClassificationCampaignBean;

/**
 * This interface contains the methods that are used to validate the users.
 * @author 2Big
 *
 */

public interface CatClassificationCampaignService {
	
	/**
	 * 
	 * @param userId
	 * @return list of RealUsersCampaigns
	 */
	
	public List<CatClassificationCampaign> getCatClassificationCampaignByUserId(int userId);
	
	/**
	 * Method to get all Classification Children by idParent
	 * @param idParent
	 * @return List<SelectClassificationCampaignBean> 
	 */
	public List<SelectClassificationCampaignBean> getListClassificationChildren(int idParent);
	
	/**
	 * Methon to get all classification Parent by idCompany
	 * @param idCompany
	 * @return List<SelectClassificationCampaignBean>
	 */
	public List<SelectClassificationCampaignBean> getListClassificationParent(int userId);
	
	
	List<CatClassificationCampaign> getClassificationCampaignByUserId(int userId);
}