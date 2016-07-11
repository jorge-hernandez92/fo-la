package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.Client;
import com.twobig.sivale.dao.CompanyDAO;

import com.twobig.sivale.dao.impl.GenericDAOImpl;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CompanyDAOImpl extends GenericDAOImpl<Client, Long> implements
		CompanyDAO {

	public CompanyDAOImpl() {
		super(Client.class);
	}

	@Override
	public void insert(Client companies) {
		this.guardar(companies);
	}

	@Override
	public void update(Client companies) {
		this.actualizar(companies);
	}

	@Override
	public void delete(Client companies) {
		this.borrar(companies);
	}

	@Override
	public List<Client> getAll() {
		return this.buscar();
	}

	@Override
	public Client getCompanyById(Integer companyId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);

		criteria.add(Restrictions.eq(Client.FIELD_COMPANY_ID, companyId));

		return getTByCriteria(criteria);
	}

	@Override
	public List<Client> getCompaniesNoDefault() {

		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);

		criteria.add(Restrictions.ge("companyId", 0));

		return getListByCriteria(criteria);
	}

	/*@Override
	public void updateFlagIsEnable(Integer companyId, Integer isEnable) {

		Query query = getSession().createQuery(QUERY_UPDATE_FLAG_IS_ENABLE);

		query.setParameter(TCompany.FIELD_COMPANY_IS_DISABLE, isEnable);
		query.setParameter(TCompany.FIELD_COMPANY_ID, companyId);

		query.executeUpdate();
	}

	@Override
	public List<Integer> getCompaniesNotDisabled() {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(TCompany.class);
		criteria.add(Restrictions.eq(TCompany.FIELD_COMPANY_IS_DISABLE, CommonsConstants.ACTIVE_COMPANY));
		criteria.setProjection(Projections.property(TCompany.FIELD_COMPANY_ID));

		return getListIntegerByCriteria(criteria);
	}*/
}