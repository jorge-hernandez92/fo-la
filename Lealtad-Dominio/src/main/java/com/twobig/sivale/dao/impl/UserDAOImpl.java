package com.twobig.sivale.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.dao.UserDAO;

@Repository
public class UserDAOImpl extends GenericDAOImpl<TUser, Long> implements
		UserDAO {

	public UserDAOImpl() {
		super(TUser.class);
	}

	/**
	 * The explanation of this method it's in the UserDAO interface.
	 */
	public TUser getUserById(Integer userId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TUser.class);

		criteria.add(Restrictions.eq(TUser.FIELD_USER_ID, userId));

		return getTByCriteria(criteria);

	}

	/**
	 * The explanation of this method it's in the UserDAO interface.
	 */

	public List<TUser> getAllUsers() {
		return buscar();
	}

	@Override
	public TUser getUserByUserName(String userName) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TUser.class);

		criteria.add(Restrictions.eq(TUser.FIELD_USER_ID, userName));

		return getTByCriteria(criteria);
	}

	@Override
	public void insert(TUser tUsers) {
		this.guardar(tUsers);
	}

	@Override
	public List<TUser> getAllUsersWithCard() {

		DetachedCriteria criteria = DetachedCriteria.forClass(TUser.class);

		criteria.add(Restrictions.isNotNull(TUser.FIELD_USER_CARD_NUMBER));

		return getListByCriteria(criteria);
	}

	@Override
	public Integer getUserIdByCard(String cardNumber) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TUser.class);

		criteria.add(Restrictions.eq(TUser.FIELD_USER_CARD_NUMBER, cardNumber));

		TUser user = getTByCriteria(criteria);

		if (user != null) {
			return user.getUserId();
		}

		return null;
	}

	@Override
	public TUser getUserByCard(String cardNumber) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TUser.class);

		criteria.add(Restrictions.eq(TUser.FIELD_USER_CARD_NUMBER, cardNumber));

		TUser user = getTByCriteria(criteria);

		if (user != null) {
			return user;
		}

		return null;
	}

	@Override
	public TUser validateUserByUserAndPwd(String user, String pwd) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TUser.class);

		criteria.add(Restrictions.eq(TUser.FIELD_USER_USER, user));
		criteria.add(Restrictions.eq(TUser.FIELD_USER_PASS, pwd));

		TUser tUser = getTByCriteria(criteria);

		if (tUser != null) {
			return tUser;
		}

		return null;
	}

	@Override
	public void update(TUser tUsers) {
		this.actualizar(tUsers);
	}

	@Override
	public void delete(TUser tUsers) {
		this.borrar(tUsers);
	}

	@Override
	public List<TUser> getAllUsersWithCardNumberByCompany(Integer company) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TUser.class);

		criteria.add(Restrictions.isNotNull(TUser.FIELD_USER_CARD_NUMBER));
		criteria.add(Restrictions.eq(TUser.FIELD_USER_COMPANY, company));

		return getListByCriteria(criteria);
	}

	@Override
	public List<TUser> getUserByCliente(Integer clientId) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TUser.class);

		criteria.add(Restrictions.eq(TUser.FIELD_USER_COMPANY, clientId));

		return getListByCriteria(criteria);
	}

	@Override
	public void insertUser(TUser tUsers)
			throws DataIntegrityViolationException {
		this.saveWithConstraints(tUsers);
	}

	@Override
	public List<TUser> getUserByLevelAndCompany(List<Integer> profileList,
			Integer company) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TUser.class);

		criteria.add(Restrictions
				.in(TUser.FIELD_USER_CAT_PROFILE, profileList));

		if (company != null) {
			criteria.add(Restrictions.eq(TUser.FIELD_USER_COMPANY, company));
		}

		criteria.addOrder(Order.asc(TUser.FIELD_USER_COMPANY));

		return getListByCriteria(criteria);
	}

	@Override
	public void updatePassword(Integer userId, String password) {

		Query query = getSession().createQuery(QUERY_UDPATE_PASSWORD);

		query.setParameter(TUser.FIELD_USER_PASS, password);
		query.setParameter(TUser.FIELD_USER_ID, userId);

		int result = query.executeUpdate();
	}

	@Override
	public List<String> getAllAccountNumberByCompanies(List<Integer> companyList) {

		DetachedCriteria criteria = DetachedCriteria.forClass(TUser.class);
		criteria.add(Restrictions.in(TUser.FIELD_USER_COMPANY, companyList));
		criteria.add(Restrictions.isNotNull(TUser.FIELD_USER_ACCOUNT_NUMBER));
		criteria.setProjection(Projections
				.property(TUser.FIELD_USER_ACCOUNT_NUMBER));

		return getListStringByCriteria(criteria);
	}
}
