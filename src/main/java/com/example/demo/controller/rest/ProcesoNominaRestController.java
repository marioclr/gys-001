package com.example.demo.controller.rest;

import java.text.SimpleDateFormat;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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

    @PostMapping("/buscarPorFecha")
    List<IProcesoNomina> buscarFasesPorFecha(@RequestParam("fec_paga") Date fec_pago){
        return servicioProcesoNomina.getBuscarFasesPorFecha(fec_pago);
    }

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
