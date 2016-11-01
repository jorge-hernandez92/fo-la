package com.twobig.sivale.service;

import java.io.File;
import java.util.List;

import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.beans.CampaignDetailAdminBean;
import com.twobig.sivale.beans.CampaignDetailBean;
import com.twobig.sivale.beans.FormNewCampaignBean;

public interface TCampaignsService {
	
	
	public List<CampaignDetailBean> getCampaignByUserIdAndClassificationCampaignsId(
			int userId,int classificationCampaignsId);
	
	public List<CampaignDetailAdminBean> getCampaingsSuper(Integer userId);
	
	public String insertCampaign(FormNewCampaignBean formNewCampaignBean);
	
	public String updateCampaign(FormNewCampaignBean formNewCampaignBean);
	
	public String deleteCampaign(Integer campaignId);
	
	public String uploadRMFile(TCampaign tCampaign, File file);
	
}
