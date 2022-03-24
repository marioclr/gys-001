package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gys_Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String id_sociedad;
	private String id_empleado;
	private String username;
	private String password;
	private String id_div_geografica;
	private Integer estatus;

	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getId_sociedad() {
		return id_sociedad;
	}
	public void setId_sociedad(String id_sociedad) {
		this.id_sociedad = id_sociedad;
	}
	public String getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(String id_empleado) {
		this.id_empleado = id_empleado;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId_div_geografica() {
		return id_div_geografica;
	}
	public void setId_div_geografica(String id_div_geografica) {
		this.id_div_geografica = id_div_geografica;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", id_sociedad=" + id_sociedad + ", id_empleado=" + id_empleado
				+ ", username=" + username + ", password=" + password + ", id_div_geografica=" + id_div_geografica
				+ ", estatus=" + estatus + "]";
	}
}