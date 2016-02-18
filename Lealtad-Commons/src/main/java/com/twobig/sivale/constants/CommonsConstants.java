package com.twobig.sivale.constants;

public class CommonsConstants {

	/**
	 * Variable to specify when a transaction or invoice is not conciliated.
	 */
	public static final String NO_CONCILIATION_FLAG = "0";

	/**
	 * Variable to specify when a transaction or invoice is conciliated.
	 */
	public static final String TRUE_CONCILIATION_FLAG = "1";

	/**
	 * Variable to specify the default value for the transaction id.
	 */
	public static final String DEFAULT_TRANSACTION_ID = "0";

	/**
	 * Variable to specify the default value for the conciliation type.
	 */
	public static final String DEFAULT_CONCILIATION_TYPE = "0";
	
	/**
	 * Variable to specify the index where the amount is.
	 */
	public static final int TRX_AMOUNT_INDEX = 5;
	
	/**
	 * Variable to specify the index where the balance after the transaction is.
	 */
	public static final int TRX_BALANCE_AFTER_INDEX = 6;
	
	/**
	 * Variable to specify the index where the balance before the transaction is.
	 */
	public static final int TRX_BALANCE_BEFORE_INDEX = 14;
	
	/**
	 * Variable to specify the index where the commerce is.
	 */
	public static final int TRX_COMMERCE_INDEX = 7;
	
	/**
	 * Variable to specify the index where the rfc commerce is.
	 */
	public static final int BDU_RFC_INDEX = 16;

	/**
	 * Variable to specify the value when an invoice is ticket.
	 */
	public static final String FLAG_IS_TICKET = "1";

	/**
	 * Variable to specify the value when an invoice is invoice.
	 */
	public static final String FLAG_IS_INVOICE = "0";
	
	/**
	 * This constant is to indicate the 3 days that are going to be
	 * subtracted from the date.
	 */
	public static final int SUBTRACT_3_DAYS = 3;

	public static final String DEFAULT_EMPTY_STRING = "";
	public static final String DEFAULT_TIP_AMOUNT = "0";

	public static final String USER_INVALID_MESSAGE = "El usuario no tiene asociado ningun número de tarjeta";
	public static final String SUCCESS_MSG_REST_RESPONSE = "success";
	public static final String ERROR_MSG_REST_RESPONSE = "error";
	public static final String EMPTY_JSON_MSG_REST_RESPONSE = "{}";

	public static final String NAME_FIELD_UPLOAD_FILE = "file";
	public static final String NAME_FIELD_UPLOAD_IMG = "img";
	public static final String NAME_FIELD_UPLOAD_CARD_NUMBER = "cardNumber";

	public static final String DATE_PARSE_FORMAT = "yyyyMMdd";
	public static final String INVOICE_DATE_PARSE_FORMAT = "yyyyMMddHHmmss";
	
	public static final String YYYYMMDD_DATE_PARSE_FORMAT = "yyyyMMdd";
	
	public static final String DEFAULT_EMPTY_BUDGET_ID = "0";
	public static final String DEFAULT_EMPTY_TRANSACTION_ID = "0";

	public static final String REGEX_FORMAT_VALIDATE_ISSUER_RFC = ".*\\bre=\\b.*";
	public static final String REGEX_FORMAT_VALIDATE_RECEIVER_RFC = ".*\\brr=\\b.*";
	public static final String REGEX_FORMAT_VALIDATE_AMOUNT = ".*\\btt=\\b.*";
	public static final String REGEX_FORMAT_VALIDATE_UUID = ".*\\bid=\\b.*";
	public static final String REGEX_FORMAT_GET_UUID = "id=(.*)\\b.*";
	public static final String REGEX_FORMAT_VALIDATE_CARD = ".*card\":\"(.*)\"}";

	public static final String CHARACTER_DECIMAL_FORMAT = "#";
	public static final String CHARACTER_SEPARATE_PARAMETERS_QR = "&";
	public static final String CHARACTER_SEPARATE_PARAMETERS_VALUES_QR = "=";
	public static final int MAX_NUMBER_OF_DECIMAL_AMOUNT = 12;

	public static final String JSON_MSG_TRANSACTION_CONCIL = "TRANSACCIONES CONCILIADAS";
	public static final String JSON_MSG_TRANSACTION_NO_CONCIL = "TRANSACCIONES NO CONCILIADAS";

	public static final String JSON_MSG_INVOICE_CONCIL = "FACTURAS CONCILIADAS";
	public static final String JSON_MSG_INVOICE_NO_CONCIL = "FACTURAS NO CONCILIADAS";

	public static final String JSON_MSG_NO_CONCEPT = "SIN CONCEPTO";
	public static final String JSON_MSG_FIELD_CONCEPT = "concept";
	public static final String JSON_MSG_FIELD_AMOUNT = "amount";
	public static final String JSON_MSG_PARENT_FIELD_CONCEPT = "amount";
	public static final String JSON_MSG_FIELD_DATE = "date";
	public static final String JSON_MSG_PARENT_FIELD_TRX_SUM = "TRANSACTIONS_SUM";
	
	public static final int ID_CARD_HOLDER = 1;

	public static final String CARD_HOLDER = "CARD_HOLDER";
	public static final String SUPERVISOR = "SUPERVISOR";
	public static final String ADMIN = "ADMIN";
	
	public static final int LENGTH_CLIENT_ID_DISPERSION = 8;
	public static final String FILLER_CLIENT_ID_DISPERSION = "0";
	
	public static final String CLIENT_NAME  = "Nombre del Cliente";
	public static final String CLIENT_NUMBER  = "Número de Cliente";
	public static final String RFC_CLIENT  = "Descripción";
	public static final String USER_ID  = "Nombre de Usuario";
	public static final String CARD_NUMBER  = "Número de Tarjeta";
	public static final String USER_NAME  = "Nombre de Persona";
	public static final String BUDGET= "0";
	public static final String REPORT= "1";
	public static final String DEFAULT_COMPANY_ID = "-1";
	
	public static final String SUCCESS_RESPONSE_STATUS = "SUCCESS";
	public static final String ERROR_RESPONSE_STATUS = "ERROR";
	public static final String TICKET_EXISTS = "TICKET_EXISTS";
	
	public static final int DATE_LENGTH_AM = 14;
	public static final String DATE_FORMAT_TRX_AM = "yyyyMMdd Hmmss";
	public static final String DATE_FORMAT_TRX_PM = "yyyyMMdd HHmmss";
	public static final String DATE_FORMAT_TRX_RESULT = "yyyyMMdd HHmmss";
	public static final int DATE_LENGTH_PM = 15;
	
	/**
	 * Constant that indicates when the authentication is wrong in the tableau server.
	 */
	public static final String TABLEAU_TICKET_ERROR = "-1";
	public static final String TALBEAU_ADMIN_SIVALE = "adminSiVale";
	
	
	/**
	 * Constant that indicates that the company is active.
	 */
	public static final Integer ACTIVE_COMPANY = 1;
	public static final Integer NO_ACTIVE_COMPANY = 0;
	
	/**
	 * Budget Status
	 */
	public static final String REQUESTED  = "Solicitado";
	public static final String REQUEST_APPROVED  = "Aprobado";
	public static final String REQUEST_DENIED  = "Rechazado";
	public static final String DISPERSION_REQUESTED  = "Dispersion Solicitada";
	
	public static final String DISPERSION_DENIED  = "Dispersion Rechazada";
	public static final String REPORT_EDIT  = "En edición";
	public static final String REPORT_SEND  = "Pendiente";
	public static final String REPORT_APPROVED  = "Comprobado";
	public static final String REPORT_REJECTED  = "No Comprobado";
	
	/**
	 * LEVEL CONSTANTS, PROFILE
	 */
	public static final int PROFILE_LEVEL_TH = 0;
	public static final int PROFILE_LEVEL_SUPERVISOR = 30;
	public static final int PROFILE_LEVEL_ADMIN_CLIENT = 60;
	public static final int PROFILE_LEVEL_ADMIN_GRAL = 90;
	
	/**
	 * CAT PROFILE
	 */
	public static final int CAT_PROFILE_SUPERVISOR = 2;
	public static final int CAT_PROFILE_ADMIN = 0;                        
	
	/**
	 * CONSTANTS
	 */
	//public static final Integer NEW_BUDGET_STATUS = 9;
	
	public static final String COLUMN_ID_EXCEL = "NUMERO_DE_CUENTA";
	
	public static final String UNDEFINED_VALUE = "undefined";
	
	public static final Integer PLATFORM_ADMIN_COMPANY_ID = -1;
	
	public static final String [] MONTHS_ARRAY_LABELS = {	"Enero","Febrero","Marzo", "Abril", "Mayo", 
															"Junio", "Julio", "Agosto", "Septiembre", 
															"Octubre", "Noviembre", "Diciembre"};
	
}