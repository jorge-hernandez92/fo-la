package com.twobig.sivale.bd.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class RelCampaignsClassification implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -977568590942007295L;
	
	public static final String FIELD_REL_USER_CAMPAIGN_CLASSIFICATION_ID = "classificationId";
	public static final String FIELD_REL_USER_CAMPAIGN_ID 		 		 = "campaignId";

	@Id
	@Column(name = "classification_id", unique = true, nullable = false)
	private int classificationId;

	@Id
	@Column(name = "campaign_id", unique = true, nullable = false)
	private int campaignId;

	public int getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(int classificationId) {
		this.classificationId = classificationId;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	
}
