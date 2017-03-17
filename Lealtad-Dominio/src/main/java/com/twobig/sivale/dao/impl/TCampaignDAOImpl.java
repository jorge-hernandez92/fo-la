package com.twobig.sivale.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.dao.TCampaignDAO;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TCampaignDAOImpl extends GenericDAOImpl<TCampaign, Long> implements TCampaignDAO {

	public TCampaignDAOImpl() {
		super(TCampaign.class);
	}

	@Override
	public List<TCampaign> getTCampaignByCampaignId(List<Integer> campaignId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TCampaign.class);
		criteria.add(Restrictions.in(TCampaign.FIELD_COMPAIGN_ID, campaignId));
		criteria.addOrder(Order.asc(TCampaign.FIELD_COMPAIGN_ID));
		return getListByCriteria(criteria);
	}

	@Override
	public List<TCampaign> getTCampaignByCampaignIdCampaignNameAndDate(List<Integer> campaignId, String campaignName,
			Date startDate, Date endDate) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TCampaign.class);

		criteria.add(Restrictions.in(TCampaign.FIELD_COMPAIGN_ID, campaignId));
		
		if(campaignName != null && !campaignName.isEmpty()){
			
			campaignName = "%"+campaignName+"%";
			
			criteria.add(Restrictions.like(TCampaign.FIELD_COMPAIGN_NAME, campaignName));
			
		}
		
		if(startDate != null || endDate != null){
			
			criteria.add(Restrictions.ge(TCampaign.FIELD_START_DATE, startDate));

			criteria.add(Restrictions.le(TCampaign.FIELD_END_DATE, endDate));
			
		}
		
		return getListByCriteria(criteria);
	}

	@Override
	public List<TCampaign> getTCampaignByCompanyId(Integer companyId) {
	
		DetachedCriteria criteria = DetachedCriteria.forClass(TCampaign.class);

		criteria.add(Restrictions.eq(TCampaign.FIELD_COMPANY_ID, companyId));

		return getListByCriteria(criteria);
	}

	@Override
	public void insertTCampaign(TCampaign tCampaign) {
		this.guardar(tCampaign);
	}

	@Override
	public void updateTCampaign(TCampaign tCampaign) {
		this.actualizar(tCampaign);
	}

	@Override
	public void deleteTCampaign(TCampaign tCampaign) {
		this.borrar(tCampaign);
	}

	@Override
	public List<TCampaign> getTCampaignByCompanyIdCampaignNameAndDate(int companyId, String campaignName,
			Date startDate, Date endDate) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TCampaign.class);
		
		criteria.add(Restrictions.eq(TCampaign.FIELD_COMPANY_ID, companyId));
		
		if(campaignName != null && !campaignName.isEmpty()){
			
			campaignName = "%"+campaignName+"%";
			
			criteria.add(Restrictions.like(TCampaign.FIELD_COMPAIGN_NAME, campaignName));
			
		}
		
		if(startDate != null || endDate != null){
			
			criteria.add(Restrictions.ge(TCampaign.FIELD_START_DATE, startDate));

			criteria.add(Restrictions.le(TCampaign.FIELD_END_DATE, endDate));
			
		}
		
		return getListByCriteria(criteria);
	}
	
}
