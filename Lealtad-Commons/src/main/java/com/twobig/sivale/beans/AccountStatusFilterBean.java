package com.twobig.sivale.beans;

import java.util.Date;

public class AccountStatusFilterBean {
	
	private String unidadDeNegocio;
	
	private String campaign;
	private String participanteIdStars;
	private String movimiento;
	private String observaciones;
	private Date  startDate;
	private Date endDate;
	
	public String getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getCampaign() {
		return campaign;
	}
	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}
	public String getUnidadDeNegocio() {
		return unidadDeNegocio;
	}
	public void setUnidadDeNegocio(String unidadDeNegocio) {
		this.unidadDeNegocio = unidadDeNegocio;
	}
	public String getParticipanteIdStars() {
		return participanteIdStars;
	}
	public void setParticipanteIdStars(String participanteIdStars) {
		this.participanteIdStars = participanteIdStars;
	}
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
	@Override
	public String toString() {
		return "AccountStatusFilterBean [campaign=" + campaign + ", unidadDeNegocio=" + unidadDeNegocio
				+ ", participanteIdStars=" + participanteIdStars + ", movimiento=" + movimiento + ", observaciones="
				+ observaciones + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
