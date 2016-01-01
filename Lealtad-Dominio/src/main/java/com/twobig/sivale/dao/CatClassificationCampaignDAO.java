package com.twobig.sivale.dao;

import java.util.List;

import com.twobig.sivale.bd.to.CatClassificationCampaign;

public interface CatClassificationCampaignDAO {
	
	public List<CatClassificationCampaign> getCatClassificationCampaignByClassificationId(List<Integer> classificationId);
	
	public List<CatClassificationCampaign> getCatClassificationCampaignByClassificationId(List<Integer> classificationId, int level);
	
	public CatClassificationCampaign getCatClassificationCampaignByParentId(int parentId);
	
	public CatClassificationCampaign getCatClassificationCampaignById(int id);
	
}
