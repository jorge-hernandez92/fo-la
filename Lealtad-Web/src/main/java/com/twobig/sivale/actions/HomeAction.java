package com.twobig.sivale.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.twobig.sivale.bd.to.TUser;
import com.twobig.sivale.constants.CommonsConstants;
import com.twobig.sivale.exceptions.TravelsNotFoundException;
import com.twobig.sivale.service.TransactionService;

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
	
//	final static Logger logger = Logger.getLogger(HomeAction.class);
	
	@Autowired
	TransactionService transactionService;
	
	private List<TypeTransaccion> lastTransactions;	

	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Action(value = "getBalanceAction", results = { @Result(name = SUCCESS, type = "json", params = { "root", "balance",
			"excludeNullProperties", "true", "noCache", "true" }), @Result(name = ERROR, location = "/error.jsp") })
	public String getBalanceAction() {
		
		
		//balance = 2000;
		TUser user =(TUser) session.get("user");
		cardNumber = user.getTjCardNumber();
		 
		try {
			balance = transactionService.getBalance(cardNumber);
		} catch (TravelsNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	@Action(value = "getLastTransactionByCardAction", results = @Result(name = SUCCESS, type = "json", params = { "root",
			"lastTransactions", "excludeNullProperties", "true", "noCache", "true" }))
	public String getLastTransactionByCardAction(){
		
		 TUser user =(TUser) session.get("user");
		 cardNumber = user.getTjCardNumber();
		
		
		//START SERVICE
		lastTransactions = transactionService.getLastTransactionByCard(cardNumber);
		//END SERVICE		 	
		
		
		//START HARDCODE
		//lastTransactions = new ServicesUser().getLastTransactions();
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
//				logger.info("Dates: "+dateFormatResult.format(dateTemp));
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
