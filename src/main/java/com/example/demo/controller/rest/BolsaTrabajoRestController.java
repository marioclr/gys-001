package com.example.demo.controller.rest;

import java.util.List;

import com.example.demo.model.BolsaTrabajoGuardias;
import com.example.demo.service.IBolsaTrabajoGuardiasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest_bolsaTrabajo")
public class BolsaTrabajoRestController {
    @Autowired
	IBolsaTrabajoGuardiasService servicioBolsaTrabGuardias;

    //Regresa todos los registros de bolsaTrabajo en formato json
    @GetMapping("/registros")
    List<BolsaTrabajoGuardias> getRegistros(){
        return servicioBolsaTrabGuardias.buscarTodos();
    } 

    // @GetMapping("/eliminar/{id}")
	// public String eliminarRegistroPersonal(@PathVariable("id") int id) {
	// 	servicioBolsaTrabGuardias.eliminar(id);
    //     return "redirect: /guardias/RegPersonalExt";
		
	// }
}
