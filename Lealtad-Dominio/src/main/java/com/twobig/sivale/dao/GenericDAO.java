package com.twobig.sivale.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataIntegrityViolationException;

public interface GenericDAO<T, ID> {

	public void guardar(final T vo);

	public void actualizar(final T vo);

	public void borrar(final T vo);

	public List<T> buscar();

	public T executeQuery(String query);

	public List<T> executeQueryGetList(String query);

	public List<T> executeQueryByExample(final T vo);
	
	public T getTByCriteria(DetachedCriteria criteria);
	
	public List<T> getListByCriteria(DetachedCriteria criteria);
	
	public void saveWithConstraints(final T vo)
			throws DataIntegrityViolationException;

}
