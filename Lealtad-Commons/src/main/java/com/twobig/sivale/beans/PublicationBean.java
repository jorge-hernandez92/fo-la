package com.twobig.sivale.beans;

import com.twobig.sivale.bd.to.TAttachedFile;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicationBean {
	
	private List<TAttachedFile> listFiles;
	
	private String html;
	
	private String image; 

	public List<TAttachedFile> getListFiles() {
		return listFiles;
	}

	public void setListFiles(List<TAttachedFile> listFiles) {
		this.listFiles = listFiles;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
