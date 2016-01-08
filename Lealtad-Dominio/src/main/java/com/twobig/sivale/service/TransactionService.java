package com.twobig.sivale.service;

import java.util.List;

import com.twobig.sivale.exceptions.TravelsNotFoundException;

import ws.sivale.com.mx.messages.types.TypeTransaccion;

public interface TransactionService {

	public static final String ERROR_MSG_NO_FOUND_TRANSACTIONS_BY_CARD_NUMBER = "NO SE ENCONTRARON TRANSACCIONES EN LA BASE DE DATOS CENTRAL";

	/**
	 * Method to update transaction information.
	 * 
	 * @param transaction
	 */

	public Double getBalance(String cardNumber) throws TravelsNotFoundException;

	public List<TypeTransaccion> getLastTransactionByCard(String cardNumber);
	
}