package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.model.IFechaHisPagas;
import com.example.demo.model.IPorcentajeNomina;
import com.example.demo.model.IProcesoNomina;
import com.example.demo.model.ProcesoNomina;

public interface IProcesoNominaService {

    void guardar(ProcesoNomina procesoNomina);
    
    // Listar fases por fecha de pago   
    // List<IProcesoNomina> getBuscarFasesPorFecha();

    // Listar fechas de m4sys_hist_pagas
    List<IFechaHisPagas> getFechas();
    List<IProcesoNomina> getMostrarFases();

    List<IPorcentajeNomina> getProcentajeProgreso();
    ProcesoNomina buscarFecha(Date fec_pago);


    
}
