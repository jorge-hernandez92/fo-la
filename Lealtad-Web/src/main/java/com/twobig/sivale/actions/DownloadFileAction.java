package com.twobig.sivale.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TPublication;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.constants.PathConstants;
import com.xm.sivale.services.test.ServicesUser;

@ParentPackage(value = "json-default")
@Namespace("/")
public class DownloadFileAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private InputStream fileInputStream;

	private String fileName;

	private byte[] file;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Action(value = "getFileAction", results = @Result(name = SUCCESS, type = "json", params = { "root", "file",
			"excludeNullProperties", "true", "noCache", "true" }) )
	public String getFileAction() {

		TCampaign campaign = (TCampaign) session.get("campaign");
		TPublication publication = (TPublication) session.get("publication");

		if (campaign == null || publication == null)
			return ERROR;

		String path = String.valueOf(campaign.getCampaignId()) + "/" + String.valueOf(publication.getPublicationId()) + "/"
				+ fileName;

		try {
			fileInputStream = new FileInputStream(new File(PathConstants.ATTACHED_DIRECTORY + path));
			file = IOUtils.toByteArray(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}
