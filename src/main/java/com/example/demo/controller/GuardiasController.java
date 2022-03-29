package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.IDatosUsuario;
import com.example.demo.model.Usuario;
import com.example.demo.service.IAdscripcionService;
import com.example.demo.service.IUsuarioService;

@Controller
@RequestMapping("/guardias")
public class GuardiasController {

	@Autowired
	IUsuarioService serviceUsuarios;
	@Autowired
	IAdscripcionService servicioAdsc;

	@GetMapping("/registro")
	String registro(Authentication authentication, HttpSession session, Model modelo) {
		String username = authentication.getName();
		Usuario usuario;
		
		if (session.getAttribute("usuario") == null){
			usuario = serviceUsuarios.buscarPorUsername(username);
			session.setAttribute("usuario", usuario);
			System.out.println(usuario);
		} else {
			usuario = (Usuario) session.getAttribute("usuario");
		}
		List<IDatosUsuario> datosUsuario = serviceUsuarios.datosUsuario(usuario.getIdUsuario());
		modelo.addAttribute("permisos", datosUsuario);
		modelo.addAttribute("adscripciones", servicioAdsc.buscarTodos());
		return "/guardias/registro";
	}
}
