package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.TAttachedFile;
import com.twobig.sivale.dao.TAttachedFileDAO;


@Repository
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
	
	
}
