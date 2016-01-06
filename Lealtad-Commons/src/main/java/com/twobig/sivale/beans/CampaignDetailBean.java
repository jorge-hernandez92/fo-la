package com.twobig.sivale.beans;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.twobig.sivale.bd.to.CatClassificationCampaign;
import com.twobig.sivale.bd.to.TCampaign;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignDetailBean extends TCampaign {
	
	private List<String> classificationName;
	
	private List<CatClassificationCampaign> catClassificationCampaign;

	public List<String> getClassificationName() {
		return classificationName;
	}

	public void setClassificationName(List<String> classificationName) {
		this.classificationName = classificationName;
	}

	public List<CatClassificationCampaign> getCatClassificationCampaign() {
		return catClassificationCampaign;
	}

	public void setCatClassificationCampaign(List<CatClassificationCampaign> catClassificationCampaign) {
		this.catClassificationCampaign = catClassificationCampaign;
	}
	
}
