package com.twobig.sivale.bd.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_data")
public class TUserData implements Serializable {

	private static final long serialVersionUID = 1066749819972430137L;

	private String data;
	private int publicationId;
	private int userId;

	public static final String FIELD_USER_ID = "userId";
	public static final String FIELD_PUBLICATION_ID = "publicationId";

	@Column(name = "data", nullable = false, length = 1000)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Id
	@Column(name = "publication_id", unique = true, nullable = false)
	public int getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(int publicationId) {
		this.publicationId = publicationId;
	}

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "TUserDate [data=" + data + ", publicationId=" + publicationId + ", userId=" + userId + "]";
	}
}
