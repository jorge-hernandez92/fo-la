package com.twobig.sivale.beans;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.twobig.sivale.bd.to.TPublication;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ViewPublicationBean extends TPublication {

	private String acoundNumber;

	public String getAcoundNumber() {
		return acoundNumber;
	}

	public void setAcoundNumber(String acoundNumber) {
		this.acoundNumber = acoundNumber;
	}
	
	public TPublication getPublication(){
		TPublication publication = new TPublication();
		
		publication.setPublicationId(this.getPublicationId());
		publication.setCatPublicationType(this.getCatPublicationType());
		publication.settCampaignId(this.gettCampaignId());
		publication.setPublishedDate(this.getPublishedDate());
		publication.setName(this.getName());
		publication.setTemplateFilePath(this.getTemplateFilePath());
		publication.setDataFilePath(this.getDataFilePath());
		publication.setDataFilePage(this.getDataFilePage());
		publication.setDescription(this.getDescription());
		publication.setIsEnable(this.getIsEnable());
		
		return publication;
	}
}
