package com.example.demo.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String mostrarHome(HttpSession session, Model modelo) {
		if (session.getAttribute("usuario") == null){
			List<IDatosUsuario> usuarios = servicioDeUsuario.datosUsuario(2);
			modelo.addAttribute("permisos", usuarios);
			System.out.println(usuarios);
	

		}
		return "blank";
	}

}
