package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BolsaTrabajoGuardias;
import com.example.demo.model.IDatosBolsaTrabajo;
import com.example.demo.model.IDatosDelegacion;
import com.example.demo.model.IDatosRfc;

@Repository
public interface BolsaTrabajoGuardiasRepository extends JpaRepository<BolsaTrabajoGuardias, Integer> {
	
	//@Query(value="Select id_centro_trabajo Clave, n_centro_trabajo Descripcion, id_tipo_ct Tipo, id_zona Zona \r\n"
		//	+ "From m4t_centros_trab \r\n"
		//	+ "Where id_tipo_ct IN (Select Distinct id_tipo_ct From m4t_gys_matriz_puestos)", nativeQuery = true)
	//List<IDatosAdscripcion> getDatosAdscripciones();
	
	@Query(value ="Select b.id id, b.rfc rfc, b.nombre nombre, b.apellidopat apellidopat, b.apellidomat apellidomat, d.n_div_geografica n_div_geografica, (c.id_centro_trabajo||' - '||c.n_centro_trabajo) n_centro_trabajo \r\n"
	 +"From gys_bolsatrabajo b, m4t_delegaciones d, m4t_centros_trab c \r\n"
	 +"Where b.id_div_geografica=d.id_div_geografica and b.id_centro_trabajo = c.id_centro_trabajo order by id desc", nativeQuery = true)
	List<IDatosBolsaTrabajo> getBuscarRegistros();
	
	//Se hace la consulta para extraer los datos de las delegaciones ordenandolos del menor a mayor(id_div_geografica)
	@Query(value="Select id_div_geografica DivGeo, n_div_geografica Nombre From m4t_delegaciones order by DivGeo", nativeQuery = true)
	List<IDatosDelegacion> getDatosDelegacion();

	@Query(value="Select rfc From gys_bolsatrabajo", nativeQuery = true)
	List<IDatosRfc> getBuscarRfc();

	@Query(value="Select rfc From gys_bolsatrabajo Where rfc like %?% ", nativeQuery = true)
	List<IDatosRfc> buscarPorRfc(String rfc);
	
}
