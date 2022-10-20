package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.model.IFechaHisPagas;
import com.example.demo.model.IPorcentajeNomina;
import com.example.demo.model.IProcesoNomina;
import com.example.demo.model.ProcesoNomina;

public interface IProcesoNominaService {

    //Guardar fase
    void guardar(ProcesoNomina procesoNomina);

    // Listar fechas de m4sys_hist_pagas en combobox
    List<IFechaHisPagas> getFechas();

    // Listar todas las fases (REST_CONTROLLER)
    List<IProcesoNomina> getMostrarFases();

    //Conteo de validado
    List<IPorcentajeNomina> getProcentajeProgreso();

    //buscar el detalle de la fase para actualizar
    ProcesoNomina buscarFaseFecha(Integer id);

    // Buscar fases por fecha de pago (POST)
    List<IProcesoNomina> getBuscarFasesPorFecha(Date fec_pago);

    //Buscar fase para dataTables
    List<IProcesoNomina> getBuscarFase(Date fase);


    
}
