package com.twobig.sivale.constants;

public class TravelsErrorCode{
	
	public enum ErrorCodeBudgetEnum {
		
		SUCCESS_CODE (Short.valueOf("1000"), "Exitoso"),
		
		EVENT_NAME_DUPLICATED(Short.valueOf("1001"), "Ya existe un evento con ese nombre"),
		
		BUDGET_WITH_EVENT_NULL(Short.valueOf("1002"), "El presupuesto no contiene evento"),
		
		GENERIC_ERROR_CODE(Short.valueOf("1003"), "El presupuesto no contiene evento"),
		
		MARSHAL_ERROR(Short.valueOf("1004"), "El presupuesto no contiene evento");
		
		/**
		 * Variable, constructor y método get del Id de el estatus.
		 */	
		private short code;
		private String message;
	
		private ErrorCodeBudgetEnum(short code, String message) {
			this.code = code;
			this.message = message;
		}
	
		/**
		 * @return the id
		 */
		public short getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}
	
	}
}
