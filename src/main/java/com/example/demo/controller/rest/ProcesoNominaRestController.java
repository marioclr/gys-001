package com.example.demo.controller.rest;

// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.IFechaHisPagas;
import com.example.demo.model.IPorcentajeNomina;
import com.example.demo.model.IProcesoNomina;
import com.example.demo.service.IProcesoNominaService;



@RestController
@RequestMapping("/rest_procesoNomina")
public class ProcesoNominaRestController {
    @Autowired
    IProcesoNominaService servicioProcesoNomina;
    
    @GetMapping("/fechas")
    List<IFechaHisPagas> getFechas(){
        return servicioProcesoNomina.getFechas();
    }

    @GetMapping("/fases")
    List<IProcesoNomina> getMostrarFases(){
        return servicioProcesoNomina.getMostrarFases();
    }

    @GetMapping("/porcentaje")
    List<IPorcentajeNomina> getPorcentajeProgreso(){
        return servicioProcesoNomina.getProcentajeProgreso();
    }

    // @PostMapping("/buscarPorFecha")
    // IProcesoNomina buscarFecha(@RequestParam("fec_pago") Date fec_pago){
    //     // DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    //     // fecha = formatter.format(fec_pago);
    //     return servicioProcesoNomina.buscarFecha(fec_pago);
    // }


    // @GetMapping("/buscarPorFecha2")
    // List<IProcesoNomina> buscarFecha(Date fec_pago){
    //     return (List<IProcesoNomina>) servicioProcesoNomina.buscarFecha("2020-01-15");
    // }
    
}
