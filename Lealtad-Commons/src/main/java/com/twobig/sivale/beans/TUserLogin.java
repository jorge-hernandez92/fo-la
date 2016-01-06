package com.twobig.sivale.beans;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.twobig.sivale.bd.to.TCompany;
import com.twobig.sivale.bd.to.TUser;

public class TUserLogin extends TUser {

	/**
	 * Serial uid from this class.
	 */
	private static final long serialVersionUID = 5184737690476918675L;

	/**
	 * Constructor from the class.
	 * @param tuser Object TUsers.
	 */
	public TUserLogin(TUser tuser) {
		BeanUtils.copyProperties(tuser, this);
	}
	
	/**
	 * List that contains the functionalities associated to the user.
	 */
	List<Integer> functionalities;
	
	/**
	 * TCompanies object.
	 */
	private TCompany tCompanies;

	/**
	 * Get the functionalities associated to the user.
	 * @return The functionalities associated to the user.
	 */
	public List<Integer> getFunctionalities() {
		return functionalities;
	}

	/**
	 * Set the functionalities associated to the user.
	 * @param functionalities The functionalities associated to the user.
	 */
	public void setFunctionalities(List<Integer> functionalities) {
		this.functionalities = functionalities;
	}

	/**
	 * Get the tCompanies object.
	 * @return tCompanies object.
	 */
	public TCompany gettCompanies() {
		return tCompanies;
	}

	/**
	 * Set the tCompanies object.
	 * @param tCompanies tCompanies object.
	 */
	public void settCompanies(TCompany tCompanies) {
		this.tCompanies = tCompanies;
	}

	@Override
	public String toString() {
		return "TUserLogin [functionalities=" + functionalities + "]";
	}
	
	
}