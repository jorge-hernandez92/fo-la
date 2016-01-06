package com.twobig.sivale.bd.to;
<<<<<<< HEAD:Lealtad-Commons/src/main/java/com/twobig/sivale/bd/to/RealUsersCampaigns.java
=======

>>>>>>> remotes/origin/Services:Lealtad-Commons/src/main/java/com/twobig/sivale/bd/to/RealUserCampaign.java
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
<<<<<<< HEAD:Lealtad-Commons/src/main/java/com/twobig/sivale/bd/to/RealUsersCampaigns.java
@Table(name = "rel_users_campaigns", catalog = "lealtad_schema")
public class RealUsersCampaigns implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7993619456264354472L;
=======
@Table(name = "rel_user_campaign", catalog = "lealtad_schema")
public class RealUserCampaign implements Serializable {

	private static final long serialVersionUID = 3404510238899467496L;
>>>>>>> remotes/origin/Services:Lealtad-Commons/src/main/java/com/twobig/sivale/bd/to/RealUserCampaign.java
	
	public static final String FIELD_REL_USER_COMPAIGN_ID = "campaignId";
	public static final String FIELD_REL_USER_ID 		  = "userId";

<<<<<<< HEAD:Lealtad-Commons/src/main/java/com/twobig/sivale/bd/to/RealUsersCampaigns.java
	@Id
	@Column(name = "campaign_id", unique = true, nullable = false)
	private int campaignId;

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	private int userId;

=======
	
	private int campaignId;	
	private int userId;

	@Id
	@Column(name = "campaign_id", unique = true, nullable = false)
>>>>>>> remotes/origin/Services:Lealtad-Commons/src/main/java/com/twobig/sivale/bd/to/RealUserCampaign.java
	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

<<<<<<< HEAD:Lealtad-Commons/src/main/java/com/twobig/sivale/bd/to/RealUsersCampaigns.java
=======
	@Id
	@Column(name = "user_id", unique = true, nullable = false)
>>>>>>> remotes/origin/Services:Lealtad-Commons/src/main/java/com/twobig/sivale/bd/to/RealUserCampaign.java
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
<<<<<<< HEAD:Lealtad-Commons/src/main/java/com/twobig/sivale/bd/to/RealUsersCampaigns.java
=======

	@Override
	public String toString() {
		return "RealUserCampaign [campaignId=" + campaignId + ", userId=" + userId + "]";
	}
	
>>>>>>> remotes/origin/Services:Lealtad-Commons/src/main/java/com/twobig/sivale/bd/to/RealUserCampaign.java
	

}
