package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.RelProfileFunctionality;
import com.twobig.sivale.dao.RelProfileFunctionalityDAO;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RelProfileFunctionalityDAOImpl extends
		GenericDAOImpl<RelProfileFunctionality, Long> implements
		RelProfileFunctionalityDAO {

	public RelProfileFunctionalityDAOImpl() {
		super(RelProfileFunctionality.class);
	}

	@Override
	public List<RelProfileFunctionality> getRelProfileFunctionalityByCatProfile(
			int catProfileId) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(RelProfileFunctionality.class);

		criteria.add(Restrictions.eq(
				RelProfileFunctionality.FIELD_REL_CAT_PROFILE, catProfileId));

		return getListByCriteria(criteria);
	}

}