package com.twobig.sivale.bd.to;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_report_movements")
public class TReportMovements implements java.io.Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private TCampaign campaign;
	private TUser user;
	private Integer reportMovementsId; 
	private Date date; 
	private String idStars;
	private String puestoEnStars;
	private String employeeName; 
	private String sivaleName; 
	private String cardNumber;
	private String bid; 
	private String razonSocial; 
	private Integer monto;
	private String movements;
	private String observaciones;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_movements_id")
	@SequenceGenerator(name = "report_movements_id", sequenceName = "REPORT_MOVEMENTS_ID_SEQ", initialValue = 0, allocationSize = 0)
	@Column(name = "report_movements_id", unique = true, nullable = false)
	public Integer getReportMovementsId() {
		return reportMovementsId;
	}
	
	public void setReportMovementsId(Integer reportMovementsId) {
		this.reportMovementsId = reportMovementsId;
	}
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_campaign", nullable = false)
	public TCampaign getCampaign() {
		return campaign;
	}
	
	public void setCampaign(TCampaign campaign) {
		this.campaign = campaign;
	}
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_user", nullable = true)
	public TUser getUser() {
		return user;
	}
	
	public void setUser(TUser user) {
		this.user = user;
	}
	
	@Column(name = "date", unique = true, nullable = false)
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "id_stars", unique = true, nullable = false)
	public String getIdStars() {
		return idStars;
	}
	
	public void setIdStars(String idStars) {
		this.idStars = idStars;
	}
	
	@Column(name = "puesto_en_stars", unique = true, nullable = false)
	public String getPuestoEnStars() {
		return puestoEnStars;
	}
	
	public void setPuestoEnStars(String puestoEnStars) {
		this.puestoEnStars = puestoEnStars;
	}
	
	@Column(name = "employee_name", unique = true, nullable = false)
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@Column(name = "sivale_name", unique = true, nullable = false)
	public String getSivaleName() {
		return sivaleName;
	}
	
	public void setSivaleName(String sivaleName) {
		this.sivaleName = sivaleName;
	}
	
	@Column(name = "card_number", unique = true, nullable = false)
	public String getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Column(name = "bid", unique = true, nullable = false)
	public String getBid() {
		return bid;
	}
	
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	@Column(name = "razon_social", unique = true, nullable = false)
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	@Column(name = "monto", unique = true, nullable = false)
	public Integer getMonto() {
		return monto;
	}
	
	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	
	@Column(name = "movements", unique = true, nullable = false)
	public String getMovements() {
		return movements;
	}
	
	public void setMovements(String movements) {
		this.movements = movements;
	}
	
	@Column(name = "observaciones", unique = true, nullable = false)
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	

}
