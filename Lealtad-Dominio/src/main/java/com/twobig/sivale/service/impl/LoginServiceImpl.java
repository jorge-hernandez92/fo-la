package com.twobig.sivale.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.CatProfile;
import com.twobig.sivale.bd.to.RelProfileFunctionality;
import com.twobig.sivale.bd.to.TCompany;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.beans.TUserLogin;
import com.twobig.sivale.constants.CommonsConstants;
import com.twobig.sivale.dao.CatProfileDAO;
import com.twobig.sivale.dao.CompanyDAO;
import com.twobig.sivale.dao.RelProfileFunctionalityDAO;
import com.twobig.sivale.dao.UserDAO;
import com.twobig.sivale.hd.to.UserBean;
import com.twobig.sivale.service.LoginService;
import com.twobig.sivale.servicios.SivaleServices;
import com.twobig.sivale.servicios.SivaleServicesException;

/**
 * This class implements the LoginService interface to validate the users.
 * 
 * @author 2Big
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	public UserDAO userDAO;

	@Autowired
	public CatProfileDAO catProfileDAO;

	@Autowired
	public CompanyDAO companyDAO;

	@Autowired
	public RelProfileFunctionalityDAO relProfileFunctionalityDAO;

	/**
	 * Variable to register the logs.
	 */
	private final static Logger LOGGER = LoggerFactory
			.getLogger(LoginServiceImpl.class);

	/**
	 * Variable to specify the length of the card number.
	 */
	private static int LENGTH_OF_CARD_NUMBER = 16;

	/**
	 * Variable to specify the pattern of card number.
	 */
	private static String PATTERN_VALID_CARD_NUMBER = "[0-9]*";

	/**
	 * The explanation of this method is in the LoginService interface.
	 */
	@Override
	public boolean validateUser(UserBean user) {

		boolean response = false;

		if (user.getUser().length() == LENGTH_OF_CARD_NUMBER
				&& user.getUser().matches(PATTERN_VALID_CARD_NUMBER)) {

			SivaleServices sivaleServices = new SivaleServices();
			try {
				response = sivaleServices.validateLogin(user.getUser(),
						user.getPass());
			} catch (SivaleServicesException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}

		return response;
	}

	/**
	 * The explanation of this method is in the LoginService interface.
	 */
	@Override
	public TUserLogin validateUserWeb(UserBean user) {

		TUser tUsers = null;
		TUserLogin tUserLogin = null;

		if (isCardHolder(user.getUser())) {

			SivaleServices sivaleServices = new SivaleServices();
			
			try {
				
				if (sivaleServices
						.validateLogin(user.getUser(), user.getPass())) {
					tUsers = userDAO.getUserByCard(user.getUser());
				}
			} catch (SivaleServicesException e) {
				System.out.println(e.getMessage());
				LOGGER.error(e.getMessage(), e);
			}
		} else {

			tUsers = userDAO.validateUserByUserAndPwd(user.getUser(),
					user.getPass());
		}

		if (tUsers != null) {

			tUserLogin = new TUserLogin(tUsers);

			TCompany tCompanies = companyDAO.getCompanyById(tUsers
					.getCompany());

			if (tCompanies == null) {
				LOGGER.info("There isn't any company associated to this user");
				return null;
			}

			tUserLogin.settCompanies(tCompanies);

			CatProfile catProfile = catProfileDAO
					.getCatProfilesById(tUserLogin.getCatProfile());
			
			List<Integer> functionalities = new ArrayList<Integer>();
			
			List<RelProfileFunctionality> relProfileFunctionality = relProfileFunctionalityDAO
					.getRelProfileFunctionalityByCatProfile(catProfile
							.getProfileId());

			for (RelProfileFunctionality relProfileFunctionality2 : relProfileFunctionality) {

				functionalities.add(relProfileFunctionality2
						.getCatFunctionality());
			}

			tUserLogin.setFunctionalities(functionalities);
		}

		return tUserLogin;
	}

	public boolean isCardHolder(String user) {
		try {
			if (user.length() == LENGTH_OF_CARD_NUMBER) {
				Long.parseLong(user);
				return true;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
		return false;
	}

}
