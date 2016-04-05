package com.twobig.sivale.bd.to;
// Generated 20/11/2015 02:09:49 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.google.common.base.MoreObjects;

/**
 * CatFunctionalities generated by hbm2java
 */
@Entity
@Table(name = "cat_functionalities", catalog = "lealtaddb")
public class CatFunctionality implements java.io.Serializable {

	private static final long serialVersionUID = -7575607339074496629L;
	private int functionalityId;
	private String functionalityCode;
	private String name;

	public CatFunctionality() {
	}

	public CatFunctionality(int functionalityId) {
		this.functionalityId = functionalityId;
	}

	public CatFunctionality(int functionalityId, String functionalityCode, String name) {
		this.functionalityId = functionalityId;
		this.functionalityCode = functionalityCode;
		this.name = name;
	}

	@Id

	@Column(name = "functionality_id", unique = true, nullable = false)
	public int getFunctionalityId() {
		return this.functionalityId;
	}

	public void setFunctionalityId(int functionalityId) {
		this.functionalityId = functionalityId;
	}

	@Column(name = "functionality_code", length = 20)
	public String getFunctionalityCode() {
		return this.functionalityCode;
	}

	public void setFunctionalityCode(String functionalityCode) {
		this.functionalityCode = functionalityCode;
	}

	@Column(name = "name", length = 80)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("functionalityId", functionalityId)
				.add("functionalityCode", functionalityCode).add("name", name).toString();
	}

}
