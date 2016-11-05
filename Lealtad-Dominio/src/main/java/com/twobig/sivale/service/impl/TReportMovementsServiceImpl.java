package com.twobig.sivale.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.twobig.sivale.bd.to.TCampaign;
import com.twobig.sivale.bd.to.TReportMovements;
import com.twobig.sivale.beans.ExcelBean;
import com.twobig.sivale.constants.RMConstants;
import com.twobig.sivale.dao.TReportMovementsDAO;
import com.twobig.sivale.service.TReportMovementsService;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TReportMovementsServiceImpl implements TReportMovementsService {
	
	@Autowired
	public TReportMovementsDAO tReportMovementsDAO;

	@Override
	public String uploadRMFile(TCampaign tCampaign, File file) {
		
		ExcelServiceImpl excelservice = new ExcelServiceImpl();
		ExcelBean excelBean = excelservice.getExcelData(file);
		
		List<HashMap<String, String>> rows = excelBean.getRows();
		
		//List<TReportMovements> listTReportMovements = new ArrayList<TReportMovements>();
		
		TReportMovements tReportMovements;
		
		tReportMovementsDAO.deleteAllByCampaign(tCampaign);
		
		for (HashMap<String, String> hashMap : rows) {
			
			tReportMovements = new TReportMovements();
			
			tReportMovements.setCampaign(tCampaign);
			
			tReportMovements.setMonth(hashMap.get(RMConstants.MES_EJECUCION));
			tReportMovements.setYear(Integer.parseInt(hashMap.get(RMConstants.YEAR)));
			tReportMovements.setIdStars(hashMap.get(RMConstants.ID_STARS));
			tReportMovements.setPuestoEnStars(hashMap.get(RMConstants.PUESTO_EN_STARS));
			tReportMovements.setEmployeeName(hashMap.get(RMConstants.NOMBRE_DEL_EMPLEADO));
			tReportMovements.setSivaleName(hashMap.get(RMConstants.NOMBRE_SIVALE));
			tReportMovements.setCardNumber(hashMap.get(RMConstants.NUMERO_DE_TARJETA_TITULAR));
			tReportMovements.setBid(hashMap.get(RMConstants.BID));
			tReportMovements.setRazonSocial(hashMap.get(RMConstants.RAZÓN_SOCIAL));
			tReportMovements.setMonto(Integer.parseInt(hashMap.get(RMConstants.MONTO)));
			tReportMovements.setCompania(hashMap.get(RMConstants.CAMPAIGN));
			tReportMovements.setMovements(hashMap.get(RMConstants.MOVIMIENTO));
			tReportMovements.setObservaciones(hashMap.get(RMConstants.OBSERVACIONES));
			
			//listTReportMovements.add(tReportMovements);
			
			tReportMovementsDAO.insertRM(tReportMovements);
			
		}
		
		return null;
	}

	@Override
	public List<TReportMovements> getAllTReportMovementsByCampaignId(Integer campaignId) {
		
		return tReportMovementsDAO.getAllTReportMovementsByCampaignId(campaignId);
		
	}
	
	

}
