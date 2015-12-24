package com.twobig.sivale.beans;

import com.twobig.sivale.bd.to.TAttachedFile;

import java.util.List;

public class PublicationBean {
	
	private List<TAttachedFile> listFiles;
	
	private String html;

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
}
