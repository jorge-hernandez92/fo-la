package com.twobig.sivale.bd.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class contains the properties from the rel_users_campaigns table.
 * 
 * @author 2Big
 *
 */

@Entity
@Table(name = "rel_user_campaign", catalog = "lealtaddb")
public class RealUserCampaign implements Serializable {

	private static final long serialVersionUID = 3404510238899467496L;

	public static final String FIELD_REL_USER_COMPAIGN_ID = "campaignId";
	public static final String FIELD_REL_USER_ID = "userId";

	private int campaignId;
	private int userId;

	@Id
	@Column(name = "campaign_id", unique = true, nullable = false)
	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
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
		return "RealUserCampaign [campaignId=" + campaignId + ", userId=" + userId + "]";
	}

}
