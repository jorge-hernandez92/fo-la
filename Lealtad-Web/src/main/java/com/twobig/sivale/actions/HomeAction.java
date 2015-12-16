package com.twobig.sivale.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.constants.CommonsConstants;
import com.xm.sivale.services.test.ServicesUser;

import ws.sivale.com.mx.messages.types.TypeTransaccion;

@SuppressWarnings("unchecked")
@ParentPackage(value = "json-default")
@Namespace("/")
public class HomeAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	private double balance;
	private double averageBalance;
	private String cardNumber;
	private String userId;
	
	private List<TypeTransaccion> lastTransactions;	

	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Action(value = "getBalanceAction", results = { @Result(name = SUCCESS, type = "json", params = { "root", "balance",
			"excludeNullProperties", "true", "noCache", "true" }), @Result(name = ERROR, location = "/error.jsp") })
	public String getBalanceAction() {
		
		
		//START HARDCODE
		balance = 2000;
		//END HARDCODE
		
		return SUCCESS;
	}
	
	
	@Action(value = "getLastTransactionByCardAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"lastTransactions", "excludeNullProperties", "true", "noCache", "true" }))
	public String getLastTransactionByCardAction(){
		
		 TUser user =(TUser) session.get("user");
		 cardNumber = user.getTjCardNumber();
		
		/*
		//START SERVICE
		lastTransactions = transactionService.getLastTransactionByCard(cardNumber);
		//END SERVICE		 	
		 * 	 
		 */
		
		
		//START HARDCODE
		lastTransactions = new ServicesUser().getLastTransactions();
		//END HARDCODE
		 
		
		SimpleDateFormat dateFormat = null;
		SimpleDateFormat dateFormatResult = new SimpleDateFormat(CommonsConstants.DATE_FORMAT_TRX_RESULT);
		try {
			for (TypeTransaccion tr : lastTransactions) {
				if(tr.getTransactionDate().length() == CommonsConstants.DATE_LENGTH_AM )
					dateFormat = new SimpleDateFormat(CommonsConstants.DATE_FORMAT_TRX_AM);
				if(tr.getTransactionDate().length() == CommonsConstants.DATE_LENGTH_PM )
					dateFormat = new SimpleDateFormat(CommonsConstants.DATE_FORMAT_TRX_PM);
				
				Date dateTemp = dateFormat.parse(tr.getTransactionDate());
				System.out.println("Dates: "+dateFormatResult.format(dateTemp));
				tr.setTransactionDate(dateFormatResult.format(dateTemp));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
		
		return SUCCESS;
	}

	public List<TypeTransaccion> getLastTransactions() {
		return lastTransactions;
	}

	public double getBalance() {
		return balance;
	}

	
	
}
