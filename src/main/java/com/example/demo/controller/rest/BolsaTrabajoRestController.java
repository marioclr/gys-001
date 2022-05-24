package com.example.demo.controller.rest;

import java.util.List;

import com.example.demo.model.BolsaTrabajoGuardias;
import com.example.demo.model.IDatosBolsaTrabajo;
import com.example.demo.model.IDatosRfc;
import com.example.demo.service.IBolsaTrabajoGuardiasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest_bolsaTrabajo")
public class BolsaTrabajoRestController {
    @Autowired
	IBolsaTrabajoGuardiasService servicioBolsaTrabGuardias;

    //Regresa todos los registros de bolsaTrabajo en formato json
    @GetMapping("/reg")
    List<BolsaTrabajoGuardias> getRegistro(){
        return servicioBolsaTrabGuardias.buscarTodos();
    } 

    // @GetMapping("/eliminar/{id}")
	// public String eliminarRegistroPersonal(@PathVariable("id") int id) {
	// 	servicioBolsaTrabGuardias.eliminar(id);
    //     return "redirect: /guardias/RegPersonalExt";
		
	// }

    @GetMapping("/registros")
    List<IDatosBolsaTrabajo> getRegistros(){
        return servicioBolsaTrabGuardias.buscarRegistros();
    }

    @GetMapping("/rfcs")
    List<IDatosRfc> getBuscarRfc(){
        return servicioBolsaTrabGuardias.getbuscarRfc();
    }

    @GetMapping("/rfc")
	public List<IDatosRfc> buscarPorRfc(@RequestParam("term") String rfc) {
		return servicioBolsaTrabGuardias.buscarPorRfc(rfc);
	}
}
