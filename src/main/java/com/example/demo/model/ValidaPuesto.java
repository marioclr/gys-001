package com.example.demo.model;

public class ValidaPuesto {

	String tipo_ct;
	String clave_servicio; 
	String puesto;
	String nivel;
	String sub_nivel; 
	String tipo_jornada;
	String tipo_guardia;

	public String getTipo_ct() {
		return tipo_ct;
	}
	public void setTipo_ct(String tipo_ct) {
		this.tipo_ct = tipo_ct;
	}
	public String getClave_servicio() {
		return clave_servicio;
	}
	public void setClave_servicio(String clave_servicio) {
		this.clave_servicio = clave_servicio;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getSub_nivel() {
		return sub_nivel;
	}
	public void setSub_nivel(String sub_nivel) {
		this.sub_nivel = sub_nivel;
	}
	public String getTipo_jornada() {
		return tipo_jornada;
	}
	public void setTipo_jornada(String tipo_jornada) {
		this.tipo_jornada = tipo_jornada;
	}
	public String getTipo_guardia() {
		return tipo_guardia;
	}
	public void setTipo_guardia(String tipo_guardia) {
		this.tipo_guardia = tipo_guardia;
	}

	@Override
	public String toString() {
		return "ValidaPuesto [tipo_ct=" + tipo_ct + ", clave_servicio=" + clave_servicio + ", puesto=" + puesto
				+ ", nivel=" + nivel + ", sub_nivel=" + sub_nivel + ", tipo_jornada=" + tipo_jornada + ", tipo_guardia="
				+ tipo_guardia + "]";
	}
}
