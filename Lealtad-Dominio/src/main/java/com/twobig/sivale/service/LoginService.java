package com.twobig.sivale.service;

import com.twobig.sivale.beans.TUserLogin;
import com.twobig.sivale.hd.to.UserBean;

/**
 * This interface contains the methods that are used to validate the users.
 * @author 2Big
 *
 */
public interface LoginService {

	/**
	 * This method validates the user name and password.
	 * @param user User object that contains the card and password.
	 * @return True if the card and password are correct, if not will return false.
	 */
	public boolean validateUser(UserBean user);
	
	/**
	 * This method validates the user name and password.
	 * @param user User object that contains the card and password.
	 * @return TUserLogin object if the card and password are correct, if not will return null.
	 */
	public TUserLogin validateUserWeb(UserBean user);
}




