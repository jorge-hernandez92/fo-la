package com.twobig.sivale.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.twobig.sivale.dao.GenericDAO;

public class GenericDAOImpl<T, ID extends Serializable> extends
		HibernateDaoSupport implements GenericDAO<T, ID> {

	@Autowired
	public void anyMethodName(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	protected Class<T> c;

	public GenericDAOImpl(Class<T> c) {
		this.c = c;
	}

	private boolean checkNull(T vo) {
		return vo != null;
	}

	public void guardar(T vo) {
		if (checkNull(vo))
			getHibernateTemplate().save(vo);
	}

	public void actualizar(T vo) {
		if (checkNull(vo))
			getHibernateTemplate().update(vo);
	}

	public void borrar(T vo) {
		if (checkNull(vo))
			getHibernateTemplate().delete(vo);
	}

	public List<T> buscar() {

		return getHibernateTemplate().loadAll(c);
	}

	public T buscarObjeto(int id) {
		return getHibernateTemplate().get(c, id);
	}

	@SuppressWarnings("unchecked")
	public T executeQuery(String query) {
		List<T> list = null;
		if (query != null) {
			list = getHibernateTemplate().find(query);
		}

		if (list != null && list.size() > 0)
			return list.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<T> executeQueryGetList(String query) {
		List<T> list = null;

		if (query != null) {
			list = getHibernateTemplate().find(query);
		}

		return list;
	}

	
	@SuppressWarnings("unchecked")
	public List<T> executeQueryByExample(T vo) {
		return getHibernateTemplate().findByExample(vo);
	}

	
	@SuppressWarnings("unchecked")
	public T getTByCriteria(DetachedCriteria criteria) {

		List<T> list = (List<T>) getHibernateTemplate()
				.findByCriteria(criteria);

		if (list != null && list.size() > 0) {
			return list.get(0);
		}

		return null;
	}

	
	@SuppressWarnings("unchecked")
	public List<T> getListByCriteria(DetachedCriteria criteria) {

		return (List<T>) getHibernateTemplate().findByCriteria(criteria);

	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getListIntegerByCriteria(DetachedCriteria criteria) {

		return (List<Integer>) getHibernateTemplate().findByCriteria(criteria);

	}
	
	@SuppressWarnings("unchecked")
	public List<String> getListStringByCriteria(DetachedCriteria criteria) {

		return (List<String>) getHibernateTemplate().findByCriteria(criteria);

	}

	@Override
	public void saveWithConstraints(T vo)
			throws DataIntegrityViolationException {
		if (checkNull(vo))
			getHibernateTemplate().save(vo);
	}
}