package com.example.demo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.IFechaHisPagas;
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
}
