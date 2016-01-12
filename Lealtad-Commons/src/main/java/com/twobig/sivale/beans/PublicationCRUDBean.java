package com.twobig.sivale.beans;

import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.bd.to.TAttachedFile;

import java.util.List;

public class PublicationCRUDBean {
	
	private TPublication publication;
	
	private List<TAttachedFile> attachedFiles;

	public TPublication getPublication() {
		return publication;
	}

	public void setPublication(TPublication publication) {
		this.publication = publication;
	}

	public List<TAttachedFile> getAttachedFiles() {
		return attachedFiles;
	}

	public void setAttachedFiles(List<TAttachedFile> attachedFiles) {
		this.attachedFiles = attachedFiles;
	}

	@Override
	public String toString() {
		return "PublicationInsertBean [publication=" + publication + ", attachedFiles=" + attachedFiles + "]";
	}
	
}
