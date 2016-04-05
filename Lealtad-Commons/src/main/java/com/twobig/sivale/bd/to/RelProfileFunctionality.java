package com.twobig.sivale.bd.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class contains the properties from the rel_profile_functionality table.
 * 
 * @author 2Big
 *
 */

@Entity
@Table(name = "rel_profile_functionality", catalog = "lealtaddb")
public class RelProfileFunctionality implements Serializable {

	/**
	 * Serial uid from this class.
	 */
	private static final long serialVersionUID = 2071128878728700112L;

	public static final String FIELD_REL_CAT_PROFILE = "catProfile";

	@Id
	@Column(name = "profile_id", unique = true, nullable = false)
	private int catProfile;

	@Id
	@Column(name = "functionality_id", unique = true, nullable = false)
	private int catFunctionality;

	public int getCatProfile() {
		return catProfile;
	}

	public void setCatProfile(int catProfile) {
		this.catProfile = catProfile;
	}

	public int getCatFunctionality() {
		return catFunctionality;
	}

	public void setCatFunctionality(int catFunctionality) {
		this.catFunctionality = catFunctionality;
	}
}
