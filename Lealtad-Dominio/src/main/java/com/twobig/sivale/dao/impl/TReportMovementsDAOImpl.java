package com.twobig.sivale.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
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
import com.twobig.sivale.beans.AccountStatusFilterBean;
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
	
	//SERVICE get TReportMovements by  company

	@Override
	public List<TReportMovements> getAllTReportMovementsByCompanyId(Integer companyId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TReportMovements.class);
		
		return getListByCriteria(criteria);
		

	}

	@Override
	public List<TReportMovements> getTReportMovementsNoRepeatByCompanyId(Integer companyId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TReportMovements.class);
		
		ProjectionList projList = Projections.projectionList();
		
		projList.add(Projections.property(TReportMovements.FIELD_IDSTARS), TReportMovements.FIELD_IDSTARS);
		
		criteria.createAlias("campaign", "campaignOb");
		
		criteria.add(Restrictions.eq("campaignOb.companyId", companyId));
		
		criteria.setProjection(Projections.distinct(projList));
		
		criteria.setResultTransformer(Transformers.aliasToBean(TReportMovements.class));

		return getListByCriteria(criteria);
	}

	@Override
	public List<TReportMovements> getTReportMovementsByIdStarsCompanyIdMovement(Integer companyId, String idStars,
			String movement) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TReportMovements.class);
		
		criteria.add(Restrictions.eq(TReportMovements.FIELD_IDSTARS, idStars));
		
		criteria.add(Restrictions.eq(TReportMovements.FIELD_MOVEMENT, movement));
		
		criteria.createAlias("campaign", "campaignOb");
		
		criteria.add(Restrictions.eq("campaignOb.companyId", companyId));
		
		return getListByCriteria(criteria);
	}

	@Override
	public List<TReportMovements> getAllTReportMovementsByCompanyIdAndFilter(Integer companyId,
			AccountStatusFilterBean filterBean) {		
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TReportMovements.class);
		
		criteria.createAlias("campaign", "campaignOb");
		criteria.add(Restrictions.eq("campaignOb.companyId", companyId));
		
		if(filterBean.getStartDate() != null && filterBean.getEndDate() != null){
			criteria.add(Restrictions.ge("campaignOb.startDate",filterBean.getStartDate()));
			criteria.add(Restrictions.le("campaignOb.endDate",filterBean.getEndDate()));
		}
		if(filterBean.getCampaign() != null && !filterBean.getCampaign().trim().isEmpty()){
			criteria.add(Restrictions.ilike("campaignOb.campaignName", "%"+filterBean.getCampaign().trim()+"%"));
		}
		if(filterBean.getObservaciones() != null && !filterBean.getObservaciones().trim().isEmpty()){
			criteria.add(Restrictions.ilike(TReportMovements.FIELD_OBSERVACIONES, "%"+filterBean.getObservaciones().trim()+"%"));
		}
		if(filterBean.getParticipanteIdStars() != null && !filterBean.getParticipanteIdStars().trim().isEmpty()){
			criteria.add(Restrictions.ilike(TReportMovements.FIELD_IDSTARS, "%"+filterBean.getParticipanteIdStars().trim()+"%"));
		}
		
		return getListByCriteria(criteria);
	}	

}
