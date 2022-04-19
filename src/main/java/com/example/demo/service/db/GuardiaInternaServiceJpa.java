package com.example.demo.service.db;

//import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.GuardiaInterna;
import com.example.demo.model.IDatosAdscripcion;
import com.example.demo.model.IDatosEmpleado;
import com.example.demo.model.IDatosGuardia;
import com.example.demo.model.IDatosJornada;
import com.example.demo.model.IDatosNivel;
import com.example.demo.model.IDatosPuesto;
import com.example.demo.model.IDatosServicio;
import com.example.demo.model.IEmpleadoInterno;
import com.example.demo.repository.GuardiaInternaRepository;
import com.example.demo.service.IGuardiaInternaService;

@Service
public class GuardiaInternaServiceJpa implements IGuardiaInternaService {

	@Autowired GuardiaInternaRepository repoGuardiaInterna;

	@Override
	public GuardiaInterna buscarPorId(Integer id) {
		Optional<GuardiaInterna> opcional = repoGuardiaInterna.findById(id);
		if(opcional.isPresent()) {
			return opcional.get();
		}
		return null;
	}

	@Override
	public GuardiaInterna guardar(GuardiaInterna guardiaInterna) {
		return repoGuardiaInterna.save(guardiaInterna);
	}

	@Override
	public List<GuardiaInterna> buscarTodos() {
		return repoGuardiaInterna.findAll();
	}

	@Override
	public IDatosEmpleado buscarEmpleado(String idEmpleado) {
		return repoGuardiaInterna.findDatosEmpleado(idEmpleado);
	}

	@Override
	public IDatosEmpleado encuentraInfoEmpleado(String idEmpleado) {
		return repoGuardiaInterna.encuentraInfoEmpleado(idEmpleado);
	}

	@Override
	public List<IDatosAdscripcion> getDatosAdscripciones() {
		return repoGuardiaInterna.getDatosAdscripciones();
	}

	@Override
	public List<IDatosPuesto> getDatosPuestosGuardia(String adsc) {
		return repoGuardiaInterna.getDatosPuestosGuardia(adsc);
	}

	@Override
	public List<IDatosServicio> getDatosServiciosGuardia(String adsc, String puesto) {
		return repoGuardiaInterna.getDatosServiciosGuardia(adsc, puesto);
	}

	@Override
	public List<IDatosNivel> getDatosNivelesGuardia(String adsc, String puesto, String servicio) {
		return repoGuardiaInterna.getDatosNivelesGuardia(adsc, puesto, servicio);
	}

	@Override
	public List<IDatosJornada> getDatosJornadasGuardia(String adsc, String puesto, String servicio, String niveles) {
		return repoGuardiaInterna.getDatosJornadasGuardia(adsc, puesto, servicio, niveles);
	}

	@Override
	public List<IDatosPuesto> getDatosPuestosGuardia() {
		return repoGuardiaInterna.getDatosPuestosGuardia();
	}

	@Override
	public List<IDatosServicio> getDatosServiciosGuardia() {
		return repoGuardiaInterna.getDatosServiciosGuardia();
	}

	@Override
	public List<IDatosNivel> getDatosNivelesGuardia() {
		return repoGuardiaInterna.getDatosNivelesGuardia();
	}

	@Override
	public List<IDatosJornada> getDatosJornadasGuardia() {
		return repoGuardiaInterna.getDatosJornadasGuardia();
	}

	@Override
	public long ValidaPuestoAutorizado(String tipo_ct, String clave_servicio, String puesto, String nivel,
			String sub_nivel, String tipo_jornada, String tipo_guardia) {
		
		return repoGuardiaInterna.ValidaPuestoAutorizado(tipo_ct, clave_servicio, puesto, nivel, sub_nivel, tipo_jornada, tipo_guardia);
	}

	@Override
	public IEmpleadoInterno ValidaEmpleadoInt(String fecha, String empleado) {
		return repoGuardiaInterna.ValidaEmpleadoInt(fecha, empleado);
	}

	@Override
	public List<IDatosGuardia> ConsultaGuardiasInternas(String claveEmpleado) {
		return repoGuardiaInterna.ConsultaGuardiasInternas(claveEmpleado);
	}

	@Override
	public List<IDatosGuardia> ConsultaGuardiasExternas(String claveEmpleado) {
		return repoGuardiaInterna.ConsultaGuardiasExternas(claveEmpleado);
	}

	@Override
	public String ValidaPersonalExterno(String rfc) {
		return repoGuardiaInterna.ValidaPersonalExterno(rfc);
	}
}
