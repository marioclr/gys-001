package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.demo.model.BolsaTrabajoGuardias;
import com.example.demo.model.IDatosUsuario;
import com.example.demo.model.Usuario;
import com.example.demo.service.IAdscripcionService;
import com.example.demo.service.IBolsaTrabajoGuardiasService;
import com.example.demo.service.IDelegacionService;
import com.example.demo.service.IGuardiaInternaService;
import com.example.demo.service.IPagaService;
import com.example.demo.service.IUsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	IPagaService servicioPagas;
	@Autowired
	IBolsaTrabajoGuardiasService servicioBolsaTrabGuardias;

	@GetMapping("/registro")
	String registro(Authentication authentication, HttpSession session, Model modelo) {

		// modelo.addAttribute("adscripciones", servicioGuardiaInt.getDatosAdscripciones());
		modelo.addAttribute("puestos", servicioGuardiaInt.getDatosPuestosGuardia());
		modelo.addAttribute("servicios", servicioGuardiaInt.getDatosServiciosGuardia());
		modelo.addAttribute("niveles", servicioGuardiaInt.getDatosNivelesGuardia());
		modelo.addAttribute("jornadas", servicioGuardiaInt.getDatosJornadasGuardia());
		return "/guardias/registro";
	}

	//Mostrar vista del formaulario para el registro de personal de guardias externas
	@GetMapping("/RegPersonalExt")
	public String bolsaTrabajo(Model modelo, BolsaTrabajoGuardias bolsaTrabajoGuardias) {
		modelo.addAttribute("titulo", "Registro de personal externo");
		// modelo.addAttribute("adscripciones", servicioGuardiaInt.getDatosAdscripciones());
		// // Se invoca el metodo que muestra las delegaciones
		// modelo.addAttribute("delegaciones", servicioBolsaTrabGuardias.getDatosDelegacion());
		return "/guardias/bolsaTrabajo";
	}
	//Guardar el registro de guardias externas
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

	//eliminar el registro de guardias externas
	@GetMapping("/eliminar/{id}")
	public String eliminarRegistroPersonal(@PathVariable("id") int id, RedirectAttributes attribute) {
		servicioBolsaTrabGuardias.eliminar(id);
		System.out.println("Se borro el registro: "+id);
		attribute.addFlashAttribute("msg","Registro eliminado");
		return "redirect:/guardias/RegPersonalExt";
	}

	//Modificar el registro de guardias externas
	@GetMapping("/editar/{id}")
	public String editarRegistroPersonal(@PathVariable("id") int id, Model modelo){
		BolsaTrabajoGuardias bolsaTrabajo =  servicioBolsaTrabGuardias.buscarId(id);
		System.out.println("Resultado de busqueda: "+bolsaTrabajo);
		modelo.addAttribute("titulo", "Editar registro de personal externo");
		modelo.addAttribute("bolsaTrabajoGuardias", bolsaTrabajo);
		return "guardias/bolsaTrabajo";
	}

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
		modelo.addAttribute("userName", username);
		modelo.addAttribute("permisos", datosUsuario);

		//Llenado de los select para la vista de registro y editar
		modelo.addAttribute("adscripciones", servicioGuardiaInt.getDatosAdscripciones());

		// Se invoca el metodo que muestra las delegaciones
		modelo.addAttribute("delegaciones", servicioBolsaTrabGuardias.getDatosDelegacion());
		modelo.addAttribute("puestos", servicioGuardiaInt.getDatosPuestosGuardia());
		modelo.addAttribute("servicios", servicioGuardiaInt.getDatosServiciosGuardia());
		modelo.addAttribute("niveles", servicioGuardiaInt.getDatosNivelesGuardia());
		modelo.addAttribute("jornadas", servicioGuardiaInt.getDatosJornadasGuardia());
		modelo.addAttribute("pagas", servicioPagas.buscarPorEstado("ACT"));
		

		//Para pdf y excel
		modelo.addAttribute("reg", servicioBolsaTrabGuardias.buscarRegistros());
	}
}
