package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TReportMovements;
import com.twobig.sivale.dao.TReportMovementsDAO;


@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TReportMovementsDAOImpl extends GenericDAOImpl<TReportMovements, Long> implements TReportMovementsDAO {

	public TReportMovementsDAOImpl() {
		super(TReportMovements.class);
	}

	@Override
	public Boolean insertRM(TReportMovements tReportMovements) {
		this.saveWithConstraints(tReportMovements);
		return true;
	}

	@Override
	public void deleteAllByCampaign(TCampaign tCampaign) {
		
		Query query = getSession().createQuery(QUERY_DELETE_ALL_BY_CAMPAIGN);

		query.setParameter(TReportMovements.FIELD_CAMPAIGN, tCampaign);

		query.executeUpdate();
		
	}

	@Override
	public List<TReportMovements> getAllTReportMovementsByCampaignId(Integer campaignId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TReportMovements.class);
		
		criteria.add(Restrictions.eq(TReportMovements.FIELD_CAMPAIGN_ID, campaignId));
		
		return getListByCriteria(criteria);
	}
	

	@Override
	public List<TReportMovements> getTReportMovementsNoRepeatByCampaignId(Integer campaignId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TReportMovements.class);
		
		ProjectionList projList = Projections.projectionList();
		
		projList.add(Projections.property(TReportMovements.FIELD_IDSTARS), TReportMovements.FIELD_IDSTARS);
		
		criteria.add(Restrictions.eq(TReportMovements.FIELD_CAMPAIGN_ID, campaignId));
		
		criteria.setProjection(Projections.distinct(projList));
		
		criteria.setResultTransformer(Transformers.aliasToBean(TReportMovements.class));

		return getListByCriteria(criteria);
		
	}

	@Override
	public List<TReportMovements> getAllTReportMovementsByIdStars(String idStars) {
		// TODO Auto-generated method stub
		return null;
	}

}
