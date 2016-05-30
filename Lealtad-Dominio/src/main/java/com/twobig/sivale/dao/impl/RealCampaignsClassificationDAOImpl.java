package com.twobig.sivale.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.RealCampaignsClassification;
import com.twobig.sivale.dao.RealCampaignsClassificationDAO;


@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RealCampaignsClassificationDAOImpl extends
GenericDAOImpl<RealCampaignsClassification, Long> implements RealCampaignsClassificationDAO {
	
	public RealCampaignsClassificationDAOImpl(){
		super(RealCampaignsClassification.class);
		
	}

	@Override
	public List<RealCampaignsClassification> getRealCampaignsClassificationByCampaignId(ArrayList<Integer> campaignId) {
		
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RealCampaignsClassification.class);
		
		criteria.add(Restrictions.in(RealCampaignsClassification.FIELD_REL_CAMPAIGN_ID, campaignId));
		
		return getListByCriteria(criteria);
	}

	@Override
	public List<RealCampaignsClassification> getRealCampaignsClassificationByCampaignIdAndClassificationCampaignsId(
			ArrayList<Integer> campaignId, int classificationCampaignsId) {
		
		
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RealCampaignsClassification.class);
		
		criteria.add(Restrictions.in(RealCampaignsClassification.FIELD_REL_CAMPAIGN_ID, campaignId));
		criteria.add(Restrictions.eq(RealCampaignsClassification.FIELD_REL_CLASSIFICATION_ID, classificationCampaignsId));		
		return getListByCriteria(criteria);
	}

	@Override
	public List<RealCampaignsClassification> getRealCampaignsClassificationByCampaignId(int campaignId) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(RealCampaignsClassification.class);
		
		criteria.add(Restrictions.eq(RealCampaignsClassification.FIELD_REL_CAMPAIGN_ID, campaignId));
		
		return getListByCriteria(criteria);
	}
	
	

}
