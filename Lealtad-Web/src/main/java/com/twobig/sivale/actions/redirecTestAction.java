package com.twobig.sivale.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/")
public class redirecTestAction extends ActionSupport {


	@Action(value="campaignParticipante", results=@Result(name="success", location="/secured/campaña_participante.jsp"))
	 public String getCampaign(){
		 return SUCCESS;
	 }
	
	 @Action(value="campaignsList", results=@Result(name="success", location="/secured/campañas_participante.jsp"))
	 public String getCampaigns(){
		 return SUCCESS;
	 }
	 
	 @Action(value="homeUser", results=@Result(name="success", location="/secured/login.jsp"))
	 public String home(){
		 return SUCCESS;
	 }
	    
}
