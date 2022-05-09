package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
// import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


//Se genera el modelo de la bolsa de trabajo
@Entity
@Table(name = "gys_bolsatrabajo")
public class BolsaTrabajoGuardias {
	@Id
	@Column (updatable = false, insertable= false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Size(min=12, max=13)
	private String rfc;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellidoPat;

	@NotEmpty
	private String apellidoMat;

	@NotEmpty
	private String id_div_geografica;
	
	@NotEmpty
	private String id_centro_trabajo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPat() {
		return apellidoPat;
	}
	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}
	public String getApellidoMat() {
		return apellidoMat;
	}
	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}
	public String getId_div_geografica() {
		return id_div_geografica;
	}
	public void setId_div_geografica(String id_div_geografica) {
		this.id_div_geografica = id_div_geografica;
	}
	public String getId_centro_trabajo() {
		return id_centro_trabajo;
	}
	public void setId_centro_trabajo(String id_centro_trabajo) {
		this.id_centro_trabajo = id_centro_trabajo;
	}
	@Override
	public String toString() {
		return "BolsaTrabajoGuardias [id=" + id + ", rfc=" + rfc + ", nombre=" + nombre + ", apellidoPat=" + apellidoPat
				+ ", apellidoMat=" + apellidoMat + ", id_div_geografica=" + id_div_geografica + ", id_centro_trabajo="
				+ id_centro_trabajo + "]";
	}
			
}
