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
	
	private String nombre; 
	private String bid; 
	private String idStars; 
	
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
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getIdStars() {
		return idStars;
	}
	public void setIdStars(String idStars) {
		this.idStars = idStars;
	}
	
	
}
