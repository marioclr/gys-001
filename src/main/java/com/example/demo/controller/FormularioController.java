package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormularioController {
    @GetMapping("/form")
	public String login() {
		return "formulario";
	}

	@GetMapping("/perfil")
	public String perfil() {
		return "perfil";
	}
	@GetMapping("/opcion")
	public String opcion() {
		return "opcion";
	}

	@GetMapping("/acceso")
	public String acceso() {
		return "accesoPerfil";
	}






    
}
