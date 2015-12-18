package com.twobig.sivale.bd.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "rel_campaigns_classification", catalog = "lealtad_schema")
public class RealCampaignsClassification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2386087662923117818L;
	
	public static final String FIELD_REL_CLASSIFICATION_ID = "classificationId";
	public static final String FIELD_REL_CAMPAIGN_ID 	   = "campaignId";

	@Id
	@Column(name = "campaign_id", unique = true, nullable = false)
	private int classificationId;

	@Id
	@Column(name = "user_id", unique = true, nullable = false)
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
