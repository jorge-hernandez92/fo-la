package com.twobig.sivale.bd.to;
// Generated 20/11/2015 02:09:49 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * TCampaigns generated by hbm2java
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="t_campaigns"
    ,catalog="lealtad_schema"
)
public class TCampaign  implements java.io.Serializable {


     private int campaignId;
     private Date startDate;
     private Date endDate;
     private String campaignName;
     private String description;
     private int classificationId;
     
     public static final String FIELD_COMPANY_ID = "campaignId";

    
     @Id 

    
    @Column(name="campaign_id", unique=true, nullable=false)
    public int getCampaignId() {
        return this.campaignId;
    }
    
    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date", length=19)
    public Date getStartDate() {
        return this.startDate;
    }

	public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date", length=19)
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    @Column(name="campaign_name", length=150)
    public String getCampaignName() {
        return this.campaignName;
    }
    
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    
    @Column(name="description", length=150)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="fk_cat_classification", unique=false, nullable=false)
    public int getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(int classificationId) {
		this.classificationId = classificationId;
	}

	@Override
	public String toString() {
		return "TCampaign [campaignId=" + campaignId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", campaignName=" + campaignName + ", description=" + description + ", classificationId="
				+ classificationId + "]";
	}
}


