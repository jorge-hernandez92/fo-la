package com.twobig.sivale.beans;

import java.util.Date;

public class AccountStatusBean {
	
	private Date startDate;
	private Date endDate;
	
	private String campaignName;
	
	private Integer monto;
	private String movements;
	
	private String programa;
	private String subprograma;
	private String unidadDeNegocio;
	private String N4;
	
	private String compania; 
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	public String getMovements() {
		return movements;
	}
	public void setMovements(String movements) {
		this.movements = movements;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public String getSubprograma() {
		return subprograma;
	}
	public void setSubprograma(String subprograma) {
		this.subprograma = subprograma;
	}
	public String getUnidadDeNegocio() {
		return unidadDeNegocio;
	}
	public void setUnidadDeNegocio(String unidadDeNegocio) {
		this.unidadDeNegocio = unidadDeNegocio;
	}
	public String getN4() {
		return N4;
	}
	public void setN4(String n4) {
		N4 = n4;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	@Override
	public String toString() {
		return "AccountStatusBean [startDate=" + startDate + ", endDate=" + endDate + ", campaignName=" + campaignName
				+ ", monto=" + monto + ", movements=" + movements + ", programa=" + programa + ", subprograma="
				+ subprograma + ", unidadDeNegocio=" + unidadDeNegocio + ", N4=" + N4 + ", compania=" + compania + "]";
	}
	
}
