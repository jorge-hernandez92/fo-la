package com.twobig.sivale.dao.impl;

import org.hibernate.Query;
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

		int result = query.executeUpdate();
		
	}

}
