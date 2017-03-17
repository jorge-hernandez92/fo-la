package com.twobig.sivale.service;

import java.util.List;

import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.beans.CampaignDetailAdminBean;
import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.beans.FormNewCampaignBean;

public interface TCampaignsService {
	
	
	List<CampaignDetailBean> getCampaignByUserIdAndClassificationCampaignsId(
			int userId,int classificationCampaignsId);
	
	List<CampaignDetailBean> getCampaignByUserIdAndClassificationId(
			int userId,int classificationCampaignsId);
	
	List<CampaignDetailAdminBean> getCampaingsSuper(Integer userId);
	
	String insertCampaign(FormNewCampaignBean formNewCampaignBean);
	
	String insertCampaign(TCampaign tCampaign);
	
	String updateCampaign(FormNewCampaignBean formNewCampaignBean);
	
	String deleteCampaign(Integer campaignId);
	
	List<CampaignDetailBean> getFullCampaignByUserIdAndClassificationId(int userId, int classificationCampaignsId);
	
}
