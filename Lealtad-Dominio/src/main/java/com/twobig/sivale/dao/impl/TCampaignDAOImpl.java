package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.dao.TCampaignDAO;

public class TCampaignDAOImpl extends GenericDAOImpl<TCampaign, Long> 
			implements TCampaignDAO {
	
	public TCampaignDAOImpl() {
		super(TCampaign.class);
	}

	@Override
	public List<TCampaign> getTCampaignByCampaignId(List<Integer> campaignId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TCampaign.class);
		
		criteria.add(Restrictions.in(CatClassificationCampaign.FIELD_CAT_CLASSIFICATION_ID, campaignId));
		
		return getListByCriteria(criteria);
	}
}
