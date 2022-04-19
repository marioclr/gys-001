package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.IDatosUsuario;
import com.example.demo.model.Usuario;
import com.example.demo.service.IUsuarioService;

@Controller
public class HomeController {

	@Autowired
	IUsuarioService serviceUsuarios;

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model modelo,
			Principal principal, RedirectAttributes flash) {
		if (principal != null) {
			// flash.addFlashAttribute("info", "Ya se ha iniciado sesión ateriormente");
			return "redirect:/";
		}

		if (error != null) {
			modelo.addAttribute("error", "Error: Nombre o contraseña incorrectos");
			
		}


		return "login";
	}

	@GetMapping("/")
	public String mostrarHome(Authentication authentication, HttpSession session, Model modelo) {
		String username = authentication.getName();
		Usuario usuario;

		if (session.getAttribute("usuario") == null) {
			usuario = serviceUsuarios.buscarPorUsername(username);
			usuario.setPassword(null);
			session.setAttribute("usuario", usuario);
			for (GrantedAuthority rol : authentication.getAuthorities()) {
				System.out.println("ROL: " + rol.getAuthority());
			}
			System.out.println(usuario);
		} else {
			usuario = (Usuario) session.getAttribute("usuario");
		}
			List<IDatosUsuario> datosUsuario = serviceUsuarios.datosUsuario(usuario.getIdUsuario());
			modelo.addAttribute("permisos", datosUsuario);
			return "blank";
	}
}