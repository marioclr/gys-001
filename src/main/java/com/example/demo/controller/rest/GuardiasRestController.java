package com.example.demo.controller.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.IDatosGuardia;
import com.example.demo.model.IDatosUsuario;
import com.example.demo.model.IEmpleadoInterno;
import com.example.demo.model.ValidaEmpleadoInterno;
import com.example.demo.model.ValidaPuesto;
import com.example.demo.service.IGuardiaInternaService;
import com.example.demo.service.IUsuarioService;

@RestController
@RequestMapping("/rest_guardias")
public class GuardiasRestController {

	@Autowired
	IUsuarioService serviceUsuarios;

	@Autowired
	IGuardiaInternaService servicioGuardiaInt;

	@GetMapping("/datos")
	List<IDatosUsuario> getUsuario (){
		return serviceUsuarios.datosUsuario(2);
	}

	@PostMapping("/ValidaPuestoAutorizado1")
	long ValidaPuestoAutorizado1(@RequestBody String tipo_ct, @RequestBody String clave_servicio, 
			@RequestBody String puesto, @RequestBody String nivel, @RequestBody String sub_nivel, 
			@RequestBody String tipo_jornada, @RequestBody String tipo_guardia){
		long value=0;
		value = servicioGuardiaInt.ValidaPuestoAutorizado(tipo_ct, clave_servicio, puesto, nivel, sub_nivel, tipo_jornada, tipo_guardia);
		return value;
	}

	@PostMapping("/ValidaPuestoAutorizado")
	long ValidaPuestoAutorizado(@RequestBody ValidaPuesto obj){
		long value=0;
		value = servicioGuardiaInt.ValidaPuestoAutorizado(obj.getTipo_ct(), obj.getClave_servicio(), obj.getPuesto(), obj.getNivel(), obj.getSub_nivel(), obj.getTipo_jornada(), obj.getTipo_guardia());
		return value;
	}

	@PostMapping("/ValidaEmpleadoInt")
	ValidaEmpleadoInterno ValidaEmpleadoInt(@RequestParam("emp_int") String emp_int){
		String date;
		IEmpleadoInterno emp = null;
		ValidaEmpleadoInterno validaEmpInterno = new ValidaEmpleadoInterno();
		//DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		date = formatter.format(new Date());
		try
		{
			emp = servicioGuardiaInt.ValidaEmpleadoInt(date, emp_int);
			validaEmpInterno.setEmpleado(emp);
			if (servicioGuardiaInt.ValidaPuestoAutorizado(emp.getId_tipo_ct(), emp.getId_clave_servicio(), emp.getId_puesto_plaza(), emp.getId_nivel(), emp.getId_sub_nivel(), emp.getId_tipo_jornada(), "I") > 0) {
				validaEmpInterno.setEsValido(true);
			} else {
				validaEmpInterno.setEsValido(false);
			}
			
		} catch (Exception ex) {
			validaEmpInterno.setEmpleado(emp);
			validaEmpInterno.setEsValido(false);
		}
		return validaEmpInterno;
	}

	@PostMapping("/ConsultaGuardias") 
	List<IDatosGuardia> ConsultaGuardias(@RequestParam("ClaveEmpleado") String claveEmpleado, @RequestParam("Tipo") String tipo){
		if (tipo.equals(String.valueOf("I")))
			return servicioGuardiaInt.ConsultaGuardiasInternas(claveEmpleado);
		else
			return servicioGuardiaInt.ConsultaGuardiasExternas(claveEmpleado);
	}

	@PostMapping("/ValidaPersonalExt")
	String ValidaPersonalExterno(@RequestParam("emp_ext") String rfc){
		String nombre = "";
		try
		{
			nombre = servicioGuardiaInt.ValidaPersonalExterno(rfc);
		} catch (Exception ex) {
			nombre = "";
		}		
		return nombre;
	}

}
