package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
// import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "fases_proceso_nomina")
public class ProcesoNomina {
    // PK fec_pago
    @Id
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fec_pago;
    private String actividad;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fec_ini;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fec_fin;
    private Boolean validado = false;

    public Date getFec_pago() {
        return fec_pago;
    }
    public void setFec_pago(Date fec_pago) {
        this.fec_pago = fec_pago;
    }

    public String getActividad() {
        return actividad;
    }
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    public Date getFec_ini() {
        return fec_ini;
    }
    public void setFec_ini(Date fec_ini) {
        this.fec_ini = fec_ini;
    }

    public Date getFec_fin() {
        return fec_fin;
    }
    public void setFec_fin(Date fec_fin) {
        this.fec_fin = fec_fin;
    }

    public Boolean getValidado() {
        return validado;
    }
    public void setValidado(Boolean validado) {
        this.validado = validado;
    }

    @Override
    public String toString() {
        return "ProcesoNomina [actividad=" + actividad + ", fec_fin=" + fec_fin + ", fec_ini=" + fec_ini + ", fec_pago="
                + fec_pago + ", validado=" + validado + "]";
    }
    
}
