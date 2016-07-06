package com.twobig.sivale.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.twobig.sivale.exceptions.TravelsNotFoundException;
import com.twobig.sivale.service.TransactionService;
import com.twobig.sivale.servicios.SivaleServices;
import com.twobig.sivale.servicios.SivaleServicesException;

import ws.sivale.com.mx.messages.types.TypeTransaccion;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TransactionServiceImpl implements TransactionService {

	private static final Logger logger = LogManager.getLogger(TransactionServiceImpl.class);

	@Override
	public Double getBalance(String cardNumber) throws TravelsNotFoundException {

		SivaleServices sivaleServices = new SivaleServices();
		Double balance = new Double(0);
		try {
			balance = sivaleServices.getBalance(cardNumber);
		} catch (SivaleServicesException e) {
			logger.info(e.getMessage(), e);
		}

		return balance;
	}
	
	@Override
	public List<TypeTransaccion> getLastTransactionByCard(String cardNumber) {
		
		SivaleServices sivaleServices = new SivaleServices();
		try {
			List<TypeTransaccion> transactionList = sivaleServices.getMovements(cardNumber);
			return transactionList;
		} catch (SivaleServicesException e) {
			logger.info(e.getMessage(), e);
			return null;
		}
	}
}
