package com.twobig.sivale.beans;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.TCampaign;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignDetailBean extends TCampaign {
	
	private List<String> classification;
	
	private List<CatClassificationCampaign> catClassificationCampaign;

	public List<String> getClassification() {
		return classification;
	}

	public void setClassification(List<String> classification) {
		this.classification = classification;
	}

	public List<CatClassificationCampaign> getCatClassificationCampaign() {
		return catClassificationCampaign;
	}

	public void setCatClassificationCampaign(List<CatClassificationCampaign> catClassificationCampaign) {
		this.catClassificationCampaign = catClassificationCampaign;
	}
	
	public void setTCampaign(TCampaign tCampaign){
		
		this.setCampaignId(tCampaign.getCampaignId());
		
		this.setCampaignName(tCampaign.getCampaignName());
		
		this.setClassificationId(tCampaign.getClassificationId());
		
		this.setDescription(tCampaign.getDescription());
		
		this.setEndDate(tCampaign.getEndDate());
		
		this.setStartDate(tCampaign.getStartDate());
	}
	
}
