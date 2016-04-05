package com.twobig.sivale.bd.to;
//Generated 14/12/2015 04:17:44 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CatPublicationUser generated by hbm2java
 */
@Entity
@Table(name = "cat_publication_user")
public class CatPublicationUser implements java.io.Serializable {

	private static final long serialVersionUID = 1066749819972430137L;
	private TPublication TPublications;
	private TUser TUsers;
	private String data;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "publication_id", nullable = false, insertable = false, updatable = false)
	public TPublication getTPublications() {
		return this.TPublications;
	}

	public void setTPublications(TPublication TPublications) {
		this.TPublications = TPublications;
	}

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	public TUser getTUsers() {
		return this.TUsers;
	}

	public void setTUsers(TUser TUsers) {
		this.TUsers = TUsers;
	}

	@Column(name = "data", nullable = false, length = 1000)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}
}