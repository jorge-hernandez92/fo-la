package com.twobig.sivale.dao;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.twobig.sivale.bd.to.TUser;

public interface UserDAO {

	public static final String QUERY_UDPATE_PASSWORD = "update TUsers set password = :password where userId = :userId";

	/**
	 * Method to get TUser by id.
	 * 
	 * @param userId
	 * @return
	 */
	public TUser getUserById(Integer userId);

	/**
	 * Method to get all users from MYSQL Table.
	 * 
	 * @return
	 */
	public List<TUser> getAllUsers();

	public TUser getUserByUserName(String userName);

	public void insert(TUser tUsers);

	public List<TUser> getAllUsersWithCard();

	public Integer getUserIdByCard(String cardNumber);

	public TUser getUserByCard(String cardNumber);

	public TUser validateUserByUserAndPwd(String user, String pwd);

	public void update(TUser tUsers);

	public void delete(TUser tUsers);

	public List<TUser> getAllUsersWithCardNumberByCompany(Integer company);

	public List<TUser> getUserByCliente(Integer clientId);

	public void insertUser(TUser tUsers)
			throws DataIntegrityViolationException;

	public List<TUser> getUserByLevelAndCompany(List<Integer> profileList,
			Integer company);

	public void updatePassword(Integer userId, String password);

	public List<String> getAllAccountNumberByCompanies(List<Integer> companyList);
	
	public List<TUser> getListUserByAccountNumber(List<String> accountNumber);
	
	public Integer getUserIdByAccountNumber(String accountNumber);
}
