package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
// import javax.validation.Valid;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
// import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
// import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.BolsaTrabajoGuardias;
import com.example.demo.model.IDatosUsuario;
import com.example.demo.model.Usuario;
import com.example.demo.service.IAdscripcionService;
import com.example.demo.service.IDelegacionService;
import com.example.demo.service.IGuardiaInternaService;
import com.example.demo.service.IUsuarioService;
import com.example.demo.service.IBolsaTrabajoGuardiasService;


@Controller
@RequestMapping("/guardias")
public class GuardiasController {

	@Autowired
	IUsuarioService serviceUsuarios;
	@Autowired
	IAdscripcionService servicioAdsc;
	@Autowired
	IDelegacionService servicioDel;
	@Autowired
	IGuardiaInternaService servicioGuardiaInt;
	@Autowired
	IBolsaTrabajoGuardiasService servicioBolsaTrabGuardias;

	@GetMapping("/registro")
	String registro(Authentication authentication, HttpSession session, Model modelo) {

		modelo.addAttribute("adscripciones", servicioGuardiaInt.getDatosAdscripciones());
		modelo.addAttribute("puestos", servicioGuardiaInt.getDatosPuestosGuardia());
		modelo.addAttribute("servicios", servicioGuardiaInt.getDatosServiciosGuardia());
		modelo.addAttribute("niveles", servicioGuardiaInt.getDatosNivelesGuardia());
		modelo.addAttribute("jornadas", servicioGuardiaInt.getDatosJornadasGuardia());
		return "/guardias/registro";
	}

	@GetMapping("/RegPersonalExt")
	public String bolsaTrabajo(Model modelo, BolsaTrabajoGuardias bolsaTrabajoGuardias) {
		modelo.addAttribute("adscripciones", servicioGuardiaInt.getDatosAdscripciones());
		// Se invoca el metodo que muestra las delegaciones
		modelo.addAttribute("delegaciones", servicioBolsaTrabGuardias.getDatosDelegacion());
		return "/guardias/bolsaTrabajo";
	}

	@PostMapping("/guardarPerExt")
	public String guardarPersonalExterno(@Valid BolsaTrabajoGuardias bolsaTrabajo,  BindingResult result, RedirectAttributes attribute){
		
		if(result.hasErrors()){
			return "redirect:/guardias/RegPersonalExt";
		}
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Registro completado:");

		System.out.println("Registro: "+ bolsaTrabajo);
		System.out.println("---------------------------------------------------------------------------------");
		
		servicioBolsaTrabGuardias.guardar(bolsaTrabajo);
		attribute.addFlashAttribute("msg","Registro guardado");

		return "redirect:/guardias/RegPersonalExt";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarRegistroPersonal(@PathVariable("id") int id) {
		servicioBolsaTrabGuardias.eliminar(id);
		return "redirect: /";
	}
	
	// @GetMapping("/editar/{id}")
	// public String editarRegistroPersonal(@PathVariable("id") int id, Model modelo){
	// 	BolsaTrabajoGuardias bolsaTrabajo =  servicioBolsaTrabGuardias.buscarId(id);
	// 	modelo.addAttribute("bolsaTrabajo", bolsaTrabajo);
	// 	return "";
	// }




	// Funcion que mantiene al usuario y a las opciones en todas las rutas
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
		modelo.addAttribute("permisos", datosUsuario);

	}
}
