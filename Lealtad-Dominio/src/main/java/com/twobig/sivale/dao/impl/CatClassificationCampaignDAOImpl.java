package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.dao.CatClassificationCampaignDAO;


@Repository
public class CatClassificationCampaignDAOImpl extends
GenericDAOImpl<CatClassificationCampaign, Long> implements CatClassificationCampaignDAO {

	public CatClassificationCampaignDAOImpl() {
		super(CatClassificationCampaign.class);
	}

	
	@Override
	public List<CatClassificationCampaign> getCatClassificationCampaignByClassificationId(
			List<Integer> classificationId) {
		
		DetachedCriteria criteria = DetachedCriteria
				.forClass(CatClassificationCampaign.class);
		
		criteria.add(Restrictions.in(CatClassificationCampaign.FIELD_CAT_CLASSIFICATION_ID, classificationId));
		
		return getListByCriteria(criteria);
	}


	@Override
	public List<CatClassificationCampaign> getCatClassificationCampaignByClassificationId(
			List<Integer> classificationId, int level) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(CatClassificationCampaign.class);
		
		criteria.add(Restrictions.in(CatClassificationCampaign.FIELD_CAT_CLASSIFICATION_ID, classificationId));
		criteria.add(Restrictions.eq(CatClassificationCampaign.FIELD_CAT_CLASSIFICATION_LEVEL, level));
		
		return getListByCriteria(criteria);
	}
	

	@Override
	public CatClassificationCampaign getCatClassificationCampaignByParentId(int parentId) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(CatClassificationCampaign.class);
		
		criteria.add(Restrictions.eq(CatClassificationCampaign.FIELD_CAT_CLASSIFICATION_ID, parentId));
		
		return getTByCriteria(criteria);
	}


	@Override
	public CatClassificationCampaign getCatClassificationCampaignById(int id) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(CatClassificationCampaign.class);
		
		criteria.add(Restrictions.eq(CatClassificationCampaign.FIELD_CAT_CLASSIFICATION_ID, id));
		
		return getTByCriteria(criteria);
	}

}
