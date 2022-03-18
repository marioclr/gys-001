package com.example.demo.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.IDatosUsuario;
import com.example.demo.service.IUsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	IUsuarioService servicioDeUsuario;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String mostrarHome(HttpSession session) {
		if (session.getAttribute("usuario") == null){
			IDatosUsuario usuario = servicioDeUsuario.datosUsuario(1);	
			System.out.println("Usuario: " + usuario.getNombre());
			System.out.println("Perfil: " + usuario.getNombrePerfil());
			System.out.println("Opción: " + usuario.getNombreOpcion());
			session.setAttribute("usuario", usuario.getNombre());
		}
		return "blank";
	}

}
