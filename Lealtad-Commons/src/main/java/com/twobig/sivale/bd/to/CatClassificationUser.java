package com.twobig.sivale.bd.to;
// Generated 20/11/2015 02:09:49 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CatClassificationUsers generated by hbm2java
 */
@Entity
@Table(name = "cat_classification_users", catalog = "lealtaddb")
public class CatClassificationUser implements java.io.Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 8079574288888629006L;
	private int catClassificationUsersId;
	private CatClassificationUser catClassificationUsers;
	private CatView catViews;
	private TCompany TCompanies;
	private String className;
	private String description;

	public CatClassificationUser() {
	}

	public CatClassificationUser(int catClassificationUsersId, TCompany TCompanies, String className) {
		this.catClassificationUsersId = catClassificationUsersId;
		this.TCompanies = TCompanies;
		this.className = className;
	}

	public CatClassificationUser(int catClassificationUsersId, CatClassificationUser catClassificationUsers,
			CatView catViews, TCompany TCompanies, String className, String description) {
		this.catClassificationUsersId = catClassificationUsersId;
		this.catClassificationUsers = catClassificationUsers;
		this.catViews = catViews;
		this.TCompanies = TCompanies;
		this.className = className;
		this.description = description;
	}

	@Id

	@Column(name = "cat_classification_users_id", unique = true, nullable = false)
	public int getCatClassificationUsersId() {
		return this.catClassificationUsersId;
	}

	public void setCatClassificationUsersId(int catClassificationUsersId) {
		this.catClassificationUsersId = catClassificationUsersId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_classification_id")
	public CatClassificationUser getCatClassificationUsers() {
		return this.catClassificationUsers;
	}

	public void setCatClassificationUsers(CatClassificationUser catClassificationUsers) {
		this.catClassificationUsers = catClassificationUsers;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_view")
	public CatView getCatViews() {
		return this.catViews;
	}

	public void setCatViews(CatView catViews) {
		this.catViews = catViews;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_company", nullable = false)
	public TCompany getTCompanies() {
		return this.TCompanies;
	}

	public void setTCompanies(TCompany TCompanies) {
		this.TCompanies = TCompanies;
	}

	@Column(name = "class_name", nullable = false, length = 45)
	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Column(name = "description", length = 45)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
