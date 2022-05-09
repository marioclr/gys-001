package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "m4sys_hist_pagas")
public class Paga {
	@Id
	@Column(name = "fec_paga", nullable=false, updatable=true)
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name = "n_hist_paga", nullable=false, updatable=true)
	private String descripcion;

	@Column(name = "coment", nullable=true, updatable=true)
	private String comentarios;

	private String estado;

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Paga [fecha=" + fecha + ", descripcion=" + descripcion + ", comentarios=" + comentarios + ", estado="
				+ estado + "]";
	}

}
