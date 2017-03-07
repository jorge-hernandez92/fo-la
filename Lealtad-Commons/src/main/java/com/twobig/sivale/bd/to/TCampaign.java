package com.twobig.sivale.bd.to;
// Generated 20/11/2015 02:09:49 PM by Hibernate Tools 4.3.1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.common.base.MoreObjects;

/**
 * TCampaigns generated by hbm2java
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "t_campaigns", catalog = "bolinf")

public class TCampaign implements java.io.Serializable {

	private static final long serialVersionUID = -6514507797041253203L;

	private Integer campaignId;
	private Date startDate;
	private Date endDate;
	private String campaignName;
	private String description;
	private Integer classificationId;
	private Integer companyId;
	private String imagePath;
	private String xlsPath;

	public static final String FIELD_COMPAIGN_ID = "campaignId";
	public static final String FIELD_COMPAIGN_NAME = "campaignName";
	public static final String FIELD_START_DATE = "startDate";
	public static final String FIELD_END_DATE = "endDate";
	public static final String FIELD_COMPANY_ID = "companyId";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "campaign_id")
	@SequenceGenerator(name = "campaign_id", sequenceName = "CAMPAIGN_SEQ", initialValue = 0, allocationSize = 0)
	@Column(name = "campaign_id", unique = true, nullable = false)
	public Integer getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "campaign_name", length = 150)
	public String getCampaignName() {
		return this.campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	@Column(name = "description", length = 150)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "fk_cat_classification", unique = false)
	public Integer getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(Integer classificationId) {
		this.classificationId = classificationId;
	}

	@Column(name = "fk_company", unique = false)
	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Column(name = "image_file_path", length = 45)
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	@Column(name = "excel_file_path", length = 45)
	public String getXlsPath() {
		return xlsPath;
	}

	public void setXlsPath(String xlsPath) {
		this.xlsPath = xlsPath;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("campaignId", campaignId).add("startDate", startDate)
				.add("endDate", endDate).add("campaignName", campaignName).add("description", description)
				.add("classificationId", classificationId).add("companyId", companyId).toString();
	}

}
