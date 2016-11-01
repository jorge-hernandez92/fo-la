package com.twobig.sivale.dao.impl;

import com.twobig.sivale.bd.to.TReportMovements;
import com.twobig.sivale.dao.TReportMovementsDAO;

public class TReportMovementsDAOImpl extends GenericDAOImpl<TReportMovements, Long> implements TReportMovementsDAO {

	public TReportMovementsDAOImpl() {
		super(TReportMovements.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean insertRM(){
		
		return true;
	}

	
	

}
