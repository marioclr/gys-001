package com.example.demo.controller;

// import com.example.demo.service.IUsuarioService;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.demo.model.IDatosUsuario;
import com.example.demo.model.Usuario;
import com.example.demo.service.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@Controller
@RequestMapping("/perfil")

public class PerfilesController {
	@Autowired
	IUsuarioService serviceUsuarios;
	
  
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


	//Funcion que mantiene al usuario y a las opciones en todas las rutas
	@ModelAttribute
	public void setGenericos(Authentication authentication, HttpSession session, Model modelo){
		String username = authentication.getName();
		Usuario usuario;
		
		if (session.getAttribute("usuario") == null){
			usuario = serviceUsuarios.buscarPorUsername(username);
			usuario.setPassword(null);
			session.setAttribute("usuario", usuario);
			for(GrantedAuthority rol: authentication.getAuthorities()){
				System.out.println("ROL: " + rol.getAuthority());	
			}
			System.out.println(usuario);
		} else {
			usuario = (Usuario) session.getAttribute("usuario");
		}
		List<IDatosUsuario> datosUsuario = serviceUsuarios.datosUsuario(usuario.getIdUsuario());
		modelo.addAttribute("permisos", datosUsuario);
		
	}
    
}
