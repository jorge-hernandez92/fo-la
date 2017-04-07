package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.dao.TAttachedFileDAO;


@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TAttachedFileDAOImpl extends GenericDAOImpl<TAttachedFile, Long> implements TAttachedFileDAO {

	public TAttachedFileDAOImpl() {
		super(TAttachedFile.class);
	}

	@Override
	public List<TAttachedFile> getTAttachedFileByPublicationId(int publicationId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TAttachedFile.class);
		criteria.add(Restrictions.eq(TAttachedFile.FIELD_TPUBLICATION_ID, publicationId));
		return getListByCriteria(criteria);
	}

	@Override
	public void insertTAttachedFile(TAttachedFile tAttachedFile) throws DataIntegrityViolationException {
		this.saveWithConstraints(tAttachedFile);
	}

	@Override
	public void updateTAttachedFile(TAttachedFile tAttachedFile) {
		this.actualizar(tAttachedFile);
	}

	@Override
	public void deleteTAttachedFile(TAttachedFile tAttachedFile) {
		this.borrar(tAttachedFile);
	}

	@Override
	public List<TAttachedFile> getListTAttachedFileByCampaignId(Integer campaignId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(TAttachedFile.class);
		criteria.add(Restrictions.eq(TAttachedFile.FIELD_TCAMPAIGN_ID, campaignId));
		return getListByCriteria(criteria);
	}

	@Override
	public void deleteAcuseTAttachedFile() {
		Query query = getSession().createQuery(QUERY_DELETE_ACUSE_FILE);
		query.executeUpdate();
	}
	
	
}
