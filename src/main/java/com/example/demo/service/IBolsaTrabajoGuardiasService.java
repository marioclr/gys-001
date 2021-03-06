package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BolsaTrabajoGuardias;
import com.example.demo.model.IDatosBolsaTrabajo;
import com.example.demo.model.IDatosDelegacion;
import com.example.demo.model.IDatosRfc;


public interface IBolsaTrabajoGuardiasService {

	BolsaTrabajoGuardias buscarId(Integer id);

	void guardar(BolsaTrabajoGuardias bolsaTrabajo);

	void eliminar(Integer id);

	List<BolsaTrabajoGuardias> buscarTodos();
	
	// List<IDatosBolsaTrabajo> buscarTodos2();
	
	List<IDatosDelegacion> getDatosDelegacion();

    List<IDatosBolsaTrabajo> buscarRegistros();

	List<IDatosRfc> getbuscarRfc();

	List<IDatosRfc> buscarPorRfc(String rfc);
	

}
