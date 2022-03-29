package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "presupuesto")
public class Presupuesto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	@JoinColumn(name = "idDelegacion")
	private Delegacion delegacion;
	private Integer Anio;
	private Integer Mes;
	@OneToOne
	@JoinColumn(name = "idTipo")
	private TipoPresupuesto tipo;
	private Double importe;
	private Integer estatus;

	@Transient
	private Integer idMotivo;
	@Transient
	private String documento;
	@Transient
	private String observaciones;
	@Transient
	private Integer idUsuarioModifica;
	@Transient
	private Date fechaModificacion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Delegacion getDelegacion() {
		return delegacion;
	}
	public void setDelegacion(Delegacion delegacion) {
		this.delegacion = delegacion;
	}

	public Integer getAnio() {
		return Anio;
	}
	public void setAnio(Integer anio) {
		Anio = anio;
	}

	public Integer getMes() {
		return Mes;
	}
	public void setMes(Integer mes) {
		Mes = mes;
	}

	public TipoPresupuesto getTipo() {
		return tipo;
	}
	public void setTipo(TipoPresupuesto tipo) {
		this.tipo = tipo;
	}

	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Integer getIdMotivo() {
		return idMotivo;
	}
	public void setIdMotivo(Integer idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getIdUsuarioModifica() {
		return idUsuarioModifica;
	}
	public void setIdUsuarioModifica(Integer idUsuarioModifica) {
		this.idUsuarioModifica = idUsuarioModifica;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@Override
	public String toString() {
		return "Presupuesto [id=" + id + ", delegacion=" + delegacion + ", Anio=" + Anio + ", Mes=" + Mes + ", tipo="
				+ tipo + ", importe=" + importe + ", estatus=" + estatus + ", idMotivo=" + idMotivo + ", documento="
				+ documento + ", observaciones=" + observaciones + "]";
	}

}
