package com.twobig.sivale.service;

import java.util.List;

import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.beans.CampaignDetailAdminBean;
import com.twobig.sivale.beans.CampaignDetailBean;

public interface TCampaignsService {
	
	
	public List<CampaignDetailBean> getCampaignByUserIdAndClassificationCampaignsId(
			int userId,int classificationCampaignsId);
	
	public List<CampaignDetailAdminBean> getCampaingsSuper(Integer userId);
	
}
