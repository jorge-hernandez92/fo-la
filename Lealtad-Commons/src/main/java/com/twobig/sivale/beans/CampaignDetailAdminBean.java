package com.twobig.sivale.beans;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.twobig.sivale.bd.to.TCampaign;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignDetailAdminBean extends TCampaign{

	private String status; //activa o inactiva dependiendo de la fecha
	private String totalWon; // no implementar solo poner $ 0.00
	private String totalScattered; // no implementar solo $ 0.00
	private List<String> classification;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTotalWon() {
		return totalWon;
	}
	
	public void setTotalWon(String totalWon) {
		this.totalWon = totalWon;
	}
	
	public String getTotalScattered() {
		return totalScattered;
	}
	
	public void setTotalScattered(String totalScattered) {
		this.totalScattered = totalScattered;
	}
	
	public List<String> getClassification() {
		return classification;
	}
	
	public void setClassification(List<String> classification) {
		this.classification = classification;
	}
	
	public void setTCampaign(TCampaign tCampaign) {
		this.setCampaignId(tCampaign.getCampaignId());
		this.setCompanyId(tCampaign.getCompanyId());
		this.setStartDate(tCampaign.getStartDate());
		this.setEndDate(tCampaign.getEndDate());
		this.setCampaignName(tCampaign.getCampaignName());
		this.setDescription(tCampaign.getDescription());
		this.setClassificationId(tCampaign.getClassificationId());
	}

	@Override
	public String toString() {
		return "CampaignDetailAdminBean [status=" + status + ", totalWon=" + totalWon + ", totalScattered="
				+ totalScattered + ", classification=" + classification + "]";
	}
	
	
	
}
