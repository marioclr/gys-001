package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.model.GuardiaInterna;
import com.example.demo.model.IDatosAdscripcion;
import com.example.demo.model.IDatosEmpleado;
import com.example.demo.model.IDatosGuardia;
import com.example.demo.model.IDatosJornada;
import com.example.demo.model.IDatosNivel;
import com.example.demo.model.IDatosPuesto;
import com.example.demo.model.IDatosServicio;
import com.example.demo.model.IEmpleadoInterno;

public interface IGuardiaInternaService {

	GuardiaInterna buscarPorId(Integer id);
	GuardiaInterna guardar(GuardiaInterna guardiaInterna);
	List<GuardiaInterna> buscarTodos();
	IDatosEmpleado buscarEmpleado(String idEmpleado);
	IDatosEmpleado encuentraInfoEmpleado(String idEmpleado);
	List<IDatosAdscripcion> getDatosAdscripciones();
	List<IDatosPuesto> getDatosPuestosGuardia();
	List<IDatosPuesto> getDatosPuestosGuardia(String adsc);
	List<IDatosServicio> getDatosServiciosGuardia();
	List<IDatosServicio> getDatosServiciosGuardia(String adsc, String puesto);
	List<IDatosNivel> getDatosNivelesGuardia();
	List<IDatosNivel> getDatosNivelesGuardia(String adsc, String puesto, String servicio);
	List<IDatosJornada> getDatosJornadasGuardia();
	List<IDatosJornada> getDatosJornadasGuardia(String adsc, String puesto, String servicio, String niveles);
	long ValidaPuestoAutorizado(String tipo_ct, String clave_servicio, String puesto, String nivel, String sub_nivel, String tipo_jornada, String tipo_guardia);
	IEmpleadoInterno ValidaEmpleadoInt(String fecha, String empleado);
	List<IDatosGuardia> ConsultaGuardiasInternas(String claveEmpleado);
	List<IDatosGuardia> ConsultaGuardiasExternas(String claveEmpleado);
	String ValidaPersonalExterno(String rfc);
}
