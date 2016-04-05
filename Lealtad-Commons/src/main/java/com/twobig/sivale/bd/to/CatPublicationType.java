package com.twobig.sivale.bd.to;

//Generated 14/12/2015 01:25:30 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.google.common.base.MoreObjects;

/**
 * CatPublicationsType generated by hbm2java
 */
@Entity
@Table(name = "cat_publications_type", catalog = "lealtaddb")
public class CatPublicationType implements java.io.Serializable {

	private static final long serialVersionUID = -4176586590786951285L;
	private Integer publicationTypeId;
	private String name;
	private String description;

	public CatPublicationType() {
	}

	@Id

	@Column(name = "publication_type_id", unique = true, nullable = false)
	public int getPublicationTypeId() {
		return this.publicationTypeId;
	}

	public void setPublicationTypeId(int publicationTypeId) {
		this.publicationTypeId = publicationTypeId;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 150)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("publicationTypeId", publicationTypeId).add("name", name)
				.add("description", description).toString();
	}
}
