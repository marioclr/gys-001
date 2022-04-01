package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/presupuesto")

public class PresupuestoController {
	
	@GetMapping("/guardias")
	String mostrarPresupuestoGuardias() {
		return "/presupuesto/presupuestoGuardias";
	}

	@GetMapping("/suplencias")
	String mostrarPresupuestoSuplencias() {
		return "/presupuesto/presupuestoSuplencias";
	}

	@GetMapping("/provac")
	String mostrarPresupuestoProvac() {
		return "/presupuesto/presupuestoProvac";
	}
	 


}
