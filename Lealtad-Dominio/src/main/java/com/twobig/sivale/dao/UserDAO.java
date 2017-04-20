package com.twobig.sivale.dao;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.twobig.sivale.bd.to.TUser;

public interface UserDAO {

	public static final String QUERY_UDPATE_PASSWORD = "update TUsers set password = :password where userId = :userId";
	
	void insert(TUser tUsers);
	void update(TUser tUsers);
	void delete(TUser tUsers);
	void insertUser(TUser tUsers)throws DataIntegrityViolationException;
	void updatePassword(Integer userId, String password);
	TUser getUserById(Integer userId);
	TUser getUserByUserName(String userName);
	TUser getUserByCard(String cardNumber);
	TUser validateUserByUserAndPwd(String user, String pwd);
	TUser getUsersByStars(String stars);
	List<TUser> getAllUsersWithCardNumberByCompany(Integer company);
	List<TUser> getUserByCliente(Integer clientId);
	List<TUser> getUserByLevelAndCompany(List<Integer> profileList,Integer company);
	List<TUser> getListUserByAccountNumber(List<String> accountNumber);
	List<TUser> getAllUsers();
	List<TUser> getAllUsersWithCard();
	List<TUser> getUsersByStars(List<String> listStars);
	List<String> getAllAccountNumberByCompanies(List<Integer> companyList);
	Integer getUserIdByCard(String cardNumber);
	Integer getUserIdByAccountNumber(String accountNumber);
	TUser getUserByUserLogin(String userLogin);
}
