package com.example.demo.controller;

// import com.example.demo.service.IUsuarioService;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/perfil")

public class PerfilesController {
	// @Autowired
	// IUsuarioService serviceUsuarios;
	
  
	@GetMapping("/crear")
	public String perfil() {
		return "perfil/perfil";
	}
	@GetMapping("/opcion")
	public String opcion() {
		return "perfil/opcion";
	}

	@GetMapping("/acceso")
	public String acceso() {
		return "perfil/accesoPerfil";
	}
    
}
