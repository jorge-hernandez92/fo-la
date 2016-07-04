package com.twobig.sivale.beans;

import java.util.List;

import org.apache.log4j.TTCCLayout;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.TCampaign;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignDetailAdminBean extends TCampaign implements Comparable<CampaignDetailAdminBean>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2924487941388949430L;
	private String status; //activa o inactiva dependiendo de la fecha
	private String totalWon; // no implementar solo poner $ 0.00
	private String totalScattered; // no implementar solo $ 0.00
	private List<String> classification;
	private List<CatClassificationCampaign> catClassificationCampaign;
	private String imageBase64;

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}
	
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
		this.setImagePath(tCampaign.getImagePath());
	}

	
	public List<CatClassificationCampaign> getCatClassificationCampaign() {
		return catClassificationCampaign;
	}

	public void setCatClassificationCampaign(List<CatClassificationCampaign> catClassificationCampaign) {
		this.catClassificationCampaign = catClassificationCampaign;
	}
	
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("super", super.toString()).add("status", status)
				.add("totalWon", totalWon).add("totalScattered", totalScattered).add("classification", classification)
				.add("catClassificationCampaign", catClassificationCampaign).toString();
	}

	//order by date
	@Override
	public int compareTo(CampaignDetailAdminBean o) {
		if (getStartDate() == null || o.getStartDate() == null)
		      return 0;
		return getStartDate().compareTo(o.getStartDate());
	}	
	
}
