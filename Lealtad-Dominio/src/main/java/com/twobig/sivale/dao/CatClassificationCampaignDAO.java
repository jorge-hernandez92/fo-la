package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.CatClassificationCampaign;

public interface CatClassificationCampaignDAO {
	
	public List<CatClassificationCampaign> getCatClassificationCampaignByClassificationId(List<Integer> classificationId);
	
	public List<CatClassificationCampaign> getCatClassificationCampaignByClassificationId(List<Integer> classificationId, int level);
	
	public List<CatClassificationCampaign> getListCatClassificationCampaignByParentId(int parentId);
	
	public CatClassificationCampaign getCatClassificationCampaignById(int id);
	
	public List<CatClassificationCampaign> getListCatClassificationCampaignByCompany(int companyId);
	
	public void insertCatClassificationCampaign(CatClassificationCampaign catClassificationCampaign);
	
}
