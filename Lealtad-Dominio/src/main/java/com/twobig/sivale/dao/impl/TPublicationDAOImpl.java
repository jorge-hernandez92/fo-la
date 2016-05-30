package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.dao.TPublicationDAO;
import com.twobig.sivale.constants.CommonsConstants;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TPublicationDAOImpl extends GenericDAOImpl<TPublication, Long> implements TPublicationDAO {

	public TPublicationDAOImpl() {
		super(TPublication.class);
	}

	@Override
	public List<TPublication> getTCampaignByPublicationId(List<Integer> publicationId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TPublication.class);

		criteria.add(Restrictions.in(TPublication.FIELD_PUBLICATION_ID, publicationId));

		return getListByCriteria(criteria);

	}

	@Override
	public TPublication getPublicationById(int publicationId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TPublication.class);

		criteria.add(Restrictions.eq(TPublication.FIELD_PUBLICATION_ID, publicationId));

		return getTByCriteria(criteria);
	}

	@Override
	public List<TPublication> getTCampaignByPublicationId(int campaign, int profile) {
		
		if(CommonsConstants.CAT_PROFILE_ADMIN == profile){
			
			DetachedCriteria criteria = DetachedCriteria.forClass(TPublication.class);

			criteria.add(Restrictions.eq(TPublication.FIELD_CAMPAIGN_ID, campaign));

			return getListByCriteria(criteria);
		}
		else{
			DetachedCriteria criteria = DetachedCriteria.forClass(TPublication.class);

			criteria.add(Restrictions.eq(TPublication.FIELD_CAMPAIGN_ID, campaign));
			
			criteria.add(Restrictions.eq(TPublication.FIELD_IS_ENABLE, true));

			return getListByCriteria(criteria);
		}
		
		
	}

	@Override
	public void insertPublication(TPublication tPublication) throws DataIntegrityViolationException {
		this.saveWithConstraints(tPublication);
	}

	@Override
	public void updatePublication(TPublication tPublication) {
		this.actualizar(tPublication);
	}

	@Override
	public void deletePublication(TPublication tPublication) {
		this.borrar(tPublication);
	}

}