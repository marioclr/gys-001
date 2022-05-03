package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BolsaTrabajoGuardias;
import com.example.demo.model.IDatosDelegacion;

@Repository
public interface BolsaTrabajoGuardiasRepository extends JpaRepository<BolsaTrabajoGuardias, Integer> {
	
	//@Query(value="Select id_centro_trabajo Clave, n_centro_trabajo Descripcion, id_tipo_ct Tipo, id_zona Zona \r\n"
		//	+ "From m4t_centros_trab \r\n"
		//	+ "Where id_tipo_ct IN (Select Distinct id_tipo_ct From m4t_gys_matriz_puestos)", nativeQuery = true)
	//List<IDatosAdscripcion> getDatosAdscripciones();
	
	//Se hace la consulta para extraer los datos de las delegaciones ordenandolos del menor a mayor(id_div_geografica)
	@Query(value="Select id_div_geografica DivGeo, n_div_geografica Nombre From m4t_delegaciones order by DivGeo", nativeQuery = true)
	List<IDatosDelegacion> getDatosDelegacion();

	
}
