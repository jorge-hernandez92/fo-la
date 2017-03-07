package com.twobig.sivale.beans;

public class ExcelUserCampaignBean {
	
	private String userId;
	private String campaignId;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	@Override
	public String toString() {
		return "ExcelUserCampaignBean [userId=" + userId + ", campaignId=" + campaignId + "]";
	}
	
}
