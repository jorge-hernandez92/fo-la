package com.twobig.sivale.beans;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchCampaignBean{

	private Integer classificationParentId;
	
	private String classificationName1;
	private String classificationName2;

	private String campaignName;
	private Date startDate;
    private Date endDate;
    
    //class_name of cat_classification_campaigns
    private String company; 
	
    
	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public Integer getClassificationParentId() {
		return classificationParentId;
	}

	public void setClassificationParentId(int classificationParentId) {
		this.classificationParentId = classificationParentId;
	}

	public String getClassificationName1() {
		return classificationName1;
	}

	public void setClassificationName1(String classificationName1) {
		this.classificationName1 = classificationName1;
	}

	public String getClassificationName2() {
		return classificationName2;
	}

	public void setClassificationName2(String classificationName2) {
		this.classificationName2 = classificationName2;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "SearchCampaignBean [classificationParentId=" + classificationParentId + ", classificationName1="
				+ classificationName1 + ", classificationName2=" + classificationName2 + ", campaignName="
				+ campaignName + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
