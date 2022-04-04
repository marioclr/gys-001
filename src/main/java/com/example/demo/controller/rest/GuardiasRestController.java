package com.example.demo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.IDatosUsuario;
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
}
