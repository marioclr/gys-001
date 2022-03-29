package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GuardiasInternas")
public class GuardiaInterna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String idSociedad;
	private String idEmpleado;
	private Date inicio;
	private Date fin;
	@OneToOne
	@JoinColumn(name = "id")
	private Presupuesto presupuesto;
	@OneToOne
	@JoinColumn(name = "id")
	private TipoMovimiento tipoMovimiento;
	@OneToOne
	@JoinColumn(name = "id")
	private TipoRiesgo tipoRiesgo;
	@OneToOne
	@JoinColumn(name = "id")
	private MotivoGuardia motivoGuardia;
	private Float horas;
    private Double importe;
    private String folio;
    private String observaciones;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdSociedad() {
		return idSociedad;
	}
	public void setIdSociedad(String idSociedad) {
		this.idSociedad = idSociedad;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public Presupuesto getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}
	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public TipoRiesgo getTipoRiesgo() {
		return tipoRiesgo;
	}
	public void setTipoRiesgo(TipoRiesgo tipoRiesgo) {
		this.tipoRiesgo = tipoRiesgo;
	}
	public MotivoGuardia getMotivoGuardia() {
		return motivoGuardia;
	}
	public void setMotivoGuardia(MotivoGuardia motivoGuardia) {
		this.motivoGuardia = motivoGuardia;
	}
	public Float getHoras() {
		return horas;
	}
	public void setHoras(Float horas) {
		this.horas = horas;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	@Override
	public String toString() {
		return "GuardiasInternas [id=" + id + ", idSociedad=" + idSociedad + ", idEmpleado=" + idEmpleado + ", inicio="
				+ inicio + ", fin=" + fin + ", presupuesto=" + presupuesto + ", tipoMovimiento=" + tipoMovimiento
				+ ", tipoRiesgo=" + tipoRiesgo + ", motivoGuardia=" + motivoGuardia + ", horas=" + horas + ", importe="
				+ importe + ", folio=" + folio + ", observaciones=" + observaciones + "]";
	}

}
