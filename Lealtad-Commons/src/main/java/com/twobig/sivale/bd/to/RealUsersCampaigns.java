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
@Table(name = "rel_users_campaigns", catalog = "lealtad_schema")
public class RealUsersCampaigns implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7993619456264354472L;
	
	public static final String FIELD_REL_USER_COMPAIGN_ID = "campaignId";
	public static final String FIELD_REL_USER_ID 		  = "userId";

	@Id
	@Column(name = "campaign_id", unique = true, nullable = false)
	private int campaignId;

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	private int userId;

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
