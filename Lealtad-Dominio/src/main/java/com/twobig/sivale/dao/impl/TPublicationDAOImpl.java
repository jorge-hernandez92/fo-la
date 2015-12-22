package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.dao.TPublicationDAO;


@Repository
public class TPublicationDAOImpl extends
GenericDAOImpl<TPublication, Long> implements TPublicationDAO {
	
	public TPublicationDAOImpl() {
		super(TPublication.class);
	}


	@Override
	public List<TPublication> getTCampaignByPublicationId(List<Integer> publicationId) {
		
		DetachedCriteria criteria = DetachedCriteria
				.forClass(TPublication.class);
		
		criteria.add(Restrictions.in(TPublication.FIELD_PUBLICATION_ID, publicationId));
		
		return getListByCriteria(criteria);
		
	}

}
