package com.example.demo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.IDatosUsuario;
import com.example.demo.service.IUsuarioService;

@RestController
@RequestMapping("/rest_guardias")
public class GuardiasRestController {

	@Autowired
	IUsuarioService serviceUsuarios;
	
	@GetMapping("/datos")
	List<IDatosUsuario> getUsuario (){
		return serviceUsuarios.datosUsuario(2);
	}
}
