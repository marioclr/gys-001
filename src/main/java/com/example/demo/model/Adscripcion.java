package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m4t_centros_trab")
public class Adscripcion {
	
	@Id
	@Column(name = "id_centro_trabajo", nullable=false, updatable=true)
	private String id;

	@Column(name = "n_centro_trabajo", nullable=false, updatable=true)
	String descripcion;

	@Column(name = "id_tipo_ct", nullable=false, updatable=true)
	String tipo;

	@Column(name = "id_zona", nullable=false, updatable=true)
	String zona;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "Adscripcion [id=" + id + ", descripcion=" + descripcion + ", tipo=" + tipo
				+ ", zona=" + zona + "]";
	}

}
