package com.twobig.sivale.bd.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_data_c")
public class TUserDataC implements Serializable {

	private static final long serialVersionUID = 1066749819972430137L;

	private Integer campaignId;
	private Integer userId; 

	public static final String FIELD_USER_ID = "userId";
	public static final String FIELD_CAMPAIGN_ID = "campaignId";
	
	@Id
	@Column(name = "campaign_id", unique = true, nullable = false)
	public Integer getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}	
	
}
