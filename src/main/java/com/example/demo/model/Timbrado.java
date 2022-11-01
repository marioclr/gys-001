package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "fechas_timbrado_nomina")
public class Timbrado {
    @Id
	// @Column (updatable = false, insertable= false)
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private Integer id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fec_pago;
    private Double isr;
    private Integer registros;
    private Integer quincena;
    private Integer mes;
    private Integer anio;
    
    
    // public Integer getId() {
    //     return id;
    // }
    // public void setId(Integer id) {
    //     this.id = id;
    // }
    public Date getFec_pago() {
        return fec_pago;
    }
    public void setFec_pago(Date fec_pago) {
        this.fec_pago = fec_pago;
    }
    public Double getIsr() {
        return isr;
    }
    public void setIsr(Double isr) {
        this.isr = isr;
    }
    public Integer getQuincena() {
        return quincena;
    }
    public void setQuincena(Integer quincena) {
        this.quincena = quincena;
    }
    public Integer getMes() {
        return mes;
    }
    public void setMes(Integer mes) {
        this.mes = mes;
    }
    public Integer getAnio() {
        return anio;
    }
    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getRegistros() {
        return registros;
    }
    public void setRegistros(Integer registros) {
        this.registros = registros;
    }
    @Override
    public String toString() {
        return "FechasTimbrado [fec_pago=" + fec_pago + ", isr=" + isr +", registros=" + registros + ", quincena=" + quincena
                + ", mes=" + mes + ", anio=" + anio + "]";
    }
  
}
