package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "m4t_delegaciones")
public class Delegacion {

	@Id
	@Column(name = "id_div_geografica", nullable=false, updatable=true)
	private String id;
	
	@Column(name = "n_div_geografica", nullable=false, updatable=true)
	private String nombre;
	
	@Column(name = "fec_ult_actualizac", nullable=false, updatable=true)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name = "coment", nullable=false, updatable=true)
	private String observaciones;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
