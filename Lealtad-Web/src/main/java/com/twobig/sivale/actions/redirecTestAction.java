package com.twobig.sivale.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import com.opensymphony.xwork2.ActionSupport;

@Namespace(value="/")
public class redirecTestAction extends ActionSupport {


	@Action(value="campaingParticipante", results=@Result(name="success", location="/secured/campaña_participante.html"))
	 public String getCampaing(){
		 return SUCCESS;
	 }
	
	 @Action(value="campaingsList", results=@Result(name="success", location="/secured/campañas_participante.html"))
	 public String getCampaings(){
		 return SUCCESS;
	 }
	 
	 @Action(value="homeUser", results=@Result(name="success", location="/secured/home_user.html"))
	 public String home(){
		 return SUCCESS;
	 }
	 
	    
}
