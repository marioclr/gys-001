package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.IDatosUsuario;
import com.example.demo.model.ProcesoNomina;
import com.example.demo.model.Usuario;
import com.example.demo.service.IProcesoNominaService;
import com.example.demo.service.IUsuarioService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

@Controller
@RequestMapping("/nomina")

public class ProcesoNominaController {

	@Autowired
	IUsuarioService serviceUsuarios;
    @Autowired
	IProcesoNominaService serviceProcesoNomina;

    @GetMapping("/procesoNomina")
	public String proceso(Model modelo, Authentication authentication, HttpSession session) {
		modelo.addAttribute("fechas", serviceProcesoNomina.getFechas());
		return "/nomina/procesoNomina";
	}

    @GetMapping("/registroNomina")
	public String registroProcesoNomina(ProcesoNomina procesoNomina, BindingResult result, Model modelo, RedirectAttributes attributes) {
		return "/nomina/fasesNomina";
	}

	// Guardar registro de fases de la nomina
	@PostMapping("/registroNomina")	
	public String guardarRegistroProcesoNomina(ProcesoNomina procesoNomina, BindingResult result, Model modelo, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println("Hubo errores");
			return "/nomina/fasesNomina";
		}
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Registro completado:");

		System.out.println("Registro: "+ procesoNomina);
		System.out.println("---------------------------------------------------------------------------------");
		
		serviceProcesoNomina.guardar(procesoNomina);
		attributes.addFlashAttribute("msg","Registro guardado");

		return "redirect:/nomina/registroNomina";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

// Funciones genericas
	@ModelAttribute
	public void setGenericos(Authentication authentication, HttpSession session, Model modelo) {
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
		modelo.addAttribute("userName", username);
		modelo.addAttribute("permisos", datosUsuario);

	}
    
}
