package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.GuardiaInterna;
import com.example.demo.model.IDatosAdscripcion;
import com.example.demo.model.IDatosEmpleado;
import com.example.demo.model.IDatosGuardia;
import com.example.demo.model.IDatosJornada;
import com.example.demo.model.IDatosNivel;
import com.example.demo.model.IDatosPuesto;
import com.example.demo.model.IDatosServicio;
import com.example.demo.model.IEmpleadoInterno;

public interface GuardiaInternaRepository extends JpaRepository<GuardiaInterna, Integer> {

	@Query(value = "SELECT id_empleado, nombre, apellido_1, apellido_2 FROM m4t_empleados e WHERE e.id_empleado = ?1", nativeQuery = true)
	IDatosEmpleado findDatosEmpleado(String idEmpleado);

	@Query(value = "SELECT E.id_empleado, E.nombre, E.apellido_1, E.apellido_2, \r\n"
			+ " J.id_tipo_jornada, C.id_tipo_ct, E.id_legal, DI.id_centro_trabajo, n_centro_trabajo, DI.id_clave_servicio, S.n_clave_servicio, \r\n"
			+ " DI.id_puesto_plaza, P.n_puesto_plaza, DI.id_turno, DI.id_nivel, DI.id_sub_nivel, DI.id_tipo_tabulador, DI.id_zona \r\n"
			+ "FROM M4_DATOS_INDIVIDUO DI, m4t_puestos_plaza P, m4t_clave_servicio S, m4_hist_jornada_plaza J, m4_centros_trab C, m4t_empleados E \r\n"
			+ "WHERE DI.id_puesto_plaza = P.id_puesto_plaza And DI.id_sociedad = P.id_sociedad \r\n"
			+ " AND DI.id_empresa = P.id_empresa And DI.id_sociedad = E.id_sociedad And DI.id_empleado = E.id_empleado \r\n"
			+ " AND DI.id_empresa = S.id_empresa And DI.id_sociedad = S.id_sociedad And DI.id_clave_servicio = S.id_clave_servicio \r\n"
			+ " AND DI.id_plaza_empleado = J.id_plaza_empleado AND DI.id_centro_trabajo=C.id_centro_trabajo \r\n"
			+ "	AND (C.fec_fin >= TODAY OR C.fec_fin IS NULL) AND J.fec_inicio <= TODAY AND (J.fec_fin >= TODAY OR J.fec_fin IS NULL) \r\n"
			+ "	AND DI.F_INICIO_PLAZA <= TODAY AND (DI.F_FIN_PLAZA >= TODAY OR DI.F_FIN_PLAZA IS NULL) \r\n"
			+ "	AND DI.F_INICIO_EMPRESA <= TODAY AND (DI.F_FIN_EMPRESA >= TODAY OR DI.F_FIN_EMPRESA IS NULL) \r\n"
			+ "	AND DI.F_INICIO_CT <= TODAY AND (DI.F_FIN_CT >= TODAY OR DI.F_FIN_CT IS NULL) \r\n"
			+ "	AND DI.F_INICIO_CS <= TODAY AND (DI.F_FIN_CS >= TODAY OR DI.F_FIN_CS IS NULL) \r\n"
			+ "	AND DI.F_INICIO_PTO <= TODAY AND (DI.F_FIN_PTO >= TODAY OR DI.F_FIN_PTO IS NULL) \r\n"
			+ "	AND DI.F_INICIO_JOR <= TODAY AND (DI.F_FIN_JOR >= TODAY OR DI.F_FIN_JOR IS NULL) \r\n"
			+ "	AND DI.F_INICIO_TURNO <= TODAY AND (DI.F_FIN_TURNO >= TODAY OR DI.F_FIN_TURNO IS NULL) \r\n"
			+ "	AND DI.F_INICIO_SITPZA <= TODAY AND (DI.F_FIN_SITPZA >= TODAY OR DI.F_FIN_SITPZA IS NULL) \r\n"
			+ "	AND DI.F_INICIO_SITEMP <= TODAY AND (DI.F_FIN_SITEMP >= TODAY OR DI.F_FIN_SITEMP IS NULL) \r\n"
			+ "	AND di.id_tipo_tabulador<>'H' AND DI.id_empleado=?1", nativeQuery = true)
	IDatosEmpleado encuentraInfoEmpleado(String idEmpleado);

	@Query(value="Select id_centro_trabajo Clave, n_centro_trabajo Descripcion, id_tipo_ct Tipo, id_zona Zona \r\n"
			+ "From m4t_centros_trab \r\n"
			+ "Where id_tipo_ct IN (Select Distinct id_tipo_ct From m4t_gys_matriz_puestos)", nativeQuery = true)
	List<IDatosAdscripcion> getDatosAdscripciones();

	@Query(value = "Select Distinct TRIM(P.id_puesto_plaza) Clave , n_puesto Descripcion, id_tipo_tabulador tipotabulador "
			+ "From m4t_puestos_plaza P, m4t_gys_matriz_puestos M "
			+ "Where TRIM(P.id_puesto_plaza)=TRIM(M.id_puesto_plaza) "
			+ "And id_tipo_ct IN (Select id_tipo_ct From m4t_centros_trab)", nativeQuery = true)
	List<IDatosPuesto> getDatosPuestosGuardia();

	@Query(value = "Select Distinct TRIM(P.id_puesto_plaza) Clave , n_puesto Descripcion, id_tipo_tabulador tipotabulador"
			+ "From m4t_puestos_plaza P, m4t_gys_matriz_puestos M "
			+ "Where TRIM(P.id_puesto_plaza)=TRIM(M.id_puesto_plaza) "
			+ "And id_tipo_ct IN (Select id_tipo_ct From m4t_centros_trab Where id_centro_trabajo ='?1')", nativeQuery = true)
	List<IDatosPuesto> getDatosPuestosGuardia(String adsc);

	@Query(value = "Select Distinct S.id_clave_servicio Clave, n_clave_servicio Descripcion "
			+ "From m4t_clave_servicio S, m4t_gys_matriz_puestos M "
			+ "Where S.id_clave_servicio=M.id_clave_servicio", nativeQuery = true)
	List<IDatosServicio> getDatosServiciosGuardia();

	@Query(value = "Select Distinct S.id_clave_servicio Clave, n_clave_servicio Descripcion "
			+ "From m4t_clave_servicio S, m4t_gys_matriz_puestos M "
			+ "Where S.id_clave_servicio=M.id_clave_servicio "
			+ "And id_tipo_ct IN (Select id_tipo_ct From m4t_centros_trab Where id_centro_trabajo = ?1"
			+ " And TRIM(id_puesto_plaza) = ?2", nativeQuery = true)
	List<IDatosServicio> getDatosServiciosGuardia(String adsc, String puesto);

	@Query(value = "Select Distinct id_nivel Nivel, id_sub_nivel Subnivel, id_nivel||id_sub_nivel Nivelsubnivel "
			+ "From m4t_gys_matriz_puestos "
			+ "Where id_tipo_ct IN (Select id_tipo_ct From m4t_centros_trab)", nativeQuery = true)
	List<IDatosNivel> getDatosNivelesGuardia();

	@Query(value = "Select Distinct id_nivel Nivel, id_sub_nivel Subnivel, id_nivel||id_sub_nivel Nivelsubnivel "
			+ "From m4t_gys_matriz_puestos "
			+ "And id_tipo_ct IN (Select id_tipo_ct From m4t_centros_trab Where id_centro_trabajo = ?1 "
			+ "And TRIM(id_puesto_plaza) = ?2 "
			+ "And id_clave_servicio = ?3", nativeQuery = true)
	List<IDatosNivel> getDatosNivelesGuardia(String adsc, String puesto, String servicio);

	@Query(value = "Select Distinct M.id_tipo_jornada Clave, n_tipo_jornada Descripcion "
			+ "From m4t_gys_matriz_puestos M, m4t_tip_jornada_st J "
			+ "Where M.id_tipo_jornada = J.id_tipo_jornada", nativeQuery = true)
	List<IDatosJornada> getDatosJornadasGuardia();

	@Query(value = "Select Distinct M.id_tipo_jornada Clave, n_tipo_jornada Descripcion "
			+ "From m4t_gys_matriz_puestos M, m4t_tip_jornada_st J "
			+ "Where M.id_tipo_jornada = J.id_tipo_jornada", nativeQuery = true)
	List<IDatosJornada> getDatosJornadasGuardia(String adsc, String puesto, String servicio, String niveles);
	
//	@Query(value = "Select NVL(COUNT(*), 0) From m4t_gys_matriz_puestos "
//			+ "Where id_tipo_ct = '?1'  And id_clave_servicio = '?2' "
//			+ "And TRIM(id_puesto_plaza) = '?3' And id_nivel = '?4' "
//			+ "And id_sub_nivel = '?5' And id_tipo_jornada = '?6' "
//			+ "And id_tipo_per = '?7'", nativeQuery = true)
//	int ValidaPuestoAutorizado(String tipo_ct, String clave_servicio, String puesto, String nivel, String sub_nivel, String tipo_jornada, String tipo_guardia);

	@Query(value = "Select NVL(COUNT(*), 0) From m4t_gys_matriz_puestos \r\n"
			+ "Where id_tipo_ct = ?1  And id_clave_servicio = ?2  \r\n"
			+ "And TRIM(id_puesto_plaza) = ?3 And id_nivel = ?4  \r\n"
			+ "And id_sub_nivel = ?5 And id_tipo_jornada = ?6  \r\n"
			+ "And id_tipo_per = ?7", nativeQuery = true)
	long ValidaPuestoAutorizado(String tipo_ct, String clave_servicio, String puesto, String nivel, String sub_nivel, String tipo_jornada, String tipo_guardia);
	
	@Query(value = "SELECT E.nombre, E.apellido_1, E.apellido_2, E.id_legal, C.id_tipo_ct, DI.id_centro_trabajo, n_centro_trabajo, " +
			"DI.id_clave_servicio, n_clave_servicio, DI.id_puesto_plaza, n_puesto_plaza, DI.id_turno, DI.id_nivel, DI.id_sub_nivel, " +
			"J.id_tipo_jornada, DI.id_tipo_tabulador, DI.Id_zona " +
            "FROM M4_DATOS_INDIVIDUO DI,  m4_hist_jornada_plaza J, m4_centros_trab C, m4t_empleados E, m4t_clave_servicio S, m4t_puestos_plaza P " +
            "WHERE DI.id_sociedad = E.id_sociedad And DI.id_empleado = E.id_empleado AND " +
            "DI.id_plaza_empleado = J.id_plaza_empleado AND DI.id_centro_trabajo=C.id_centro_trabajo AND " +
            "DI.id_clave_servicio = S.id_clave_servicio AND DI.id_sociedad = S.id_sociedad AND DI.id_empresa = S.id_empresa AND " +
            "DI.id_puesto_plaza = P.id_puesto_plaza AND DI.id_sociedad = P.id_sociedad AND DI.id_empresa = P.id_empresa AND " +
            "(C.fec_fin >= ?1 OR C.fec_fin IS NULL) AND J.fec_inicio <= ?1 AND (J.fec_fin >= ?1 OR J.fec_fin IS NULL) AND " +
            "DI.F_INICIO_PLAZA <= ?1 AND (DI.F_FIN_PLAZA >= ?1 OR DI.F_FIN_PLAZA IS NULL) " +
            "AND DI.F_INICIO_EMPRESA <= ?1 AND (DI.F_FIN_EMPRESA >= ?1 OR DI.F_FIN_EMPRESA IS NULL) " +
            "AND DI.F_INICIO_CT <= ?1 AND (DI.F_FIN_CT >= ?1 OR DI.F_FIN_CT IS NULL) " +
            "AND DI.F_INICIO_CS <= ?1 AND (DI.F_FIN_CS >= ?1 OR DI.F_FIN_CS IS NULL) " +
            "AND DI.F_INICIO_PTO <= ?1 AND (DI.F_FIN_PTO >= ?1 OR DI.F_FIN_PTO IS NULL) " +
            "AND DI.F_INICIO_JOR <= ?1 AND (DI.F_FIN_JOR >= ?1 OR DI.F_FIN_JOR IS NULL) " +
            "AND DI.F_INICIO_TURNO <= ?1 AND (DI.F_FIN_TURNO >= ?1 OR DI.F_FIN_TURNO IS NULL) " +
            "AND DI.F_INICIO_SITPZA <= ?1 AND (DI.F_FIN_SITPZA >= ?1 OR DI.F_FIN_SITPZA IS NULL) " +
            "AND DI.F_INICIO_SITEMP <= ?1 AND (DI.F_FIN_SITEMP >= ?1 OR DI.F_FIN_SITEMP IS NULL) " +
            "And di.id_tipo_tabulador<>'H' And DI.id_empleado=?2", nativeQuery = true)
	IEmpleadoInterno ValidaEmpleadoInt(String fecha, String empleado);	

//	@Query(value = "Select rowid, * from m4t_gys_matriz_puestos "
//			+ "Where id_tipo_ct = ?1 And id_clave_servicio = ?2 And "
//			+ "TRIM(id_puesto_plaza) = ?3 And id_nivel = ?4 And id_sub_nivel = ?5 And "
//			+ "id_tipo_jornada = ?6 And id_tipo_per = ?7", nativeQuery = true)
//	IPuestoAutorizado ValidaPuestoAutorizado(String tipo_ct, String clave_servicio, String puesto, String nivel, String sub_nivel, String tipo_jornada, String tipo_guardia);

	@Query(value = "Select G.id_empleado Clave_empleado, G.id_centro_trabajo, G.id_clave_servicio, G.id_puesto_plaza, "
			+ "G.id_nivel, G.id_sub_nivel, G.id_tipo_jornada, G.horas, G.fec_inicio, G.fec_fin, "
			+ "G.importe, PU.id_tipo_tabulador, G.fec_paga, C.id_zona, G.riesgos, P.estado, G.id_ordinal "
			+ "From mclr_guardias_emp G, m4sys_hist_pagas P, m4t_centros_trab C, m4t_puestos_plaza PU "
			+ "Where G.fec_paga = P.fec_paga And "
			+ "G.id_centro_trabajo = C.id_centro_trabajo And "
			+ "G.id_puesto_plaza = PU.id_puesto_plaza And "
			+ "id_empleado = ?1 And "
			+ "PU.id_sociedad = '01' And "
			+ "PU.id_empresa = '01' "
			+ "Order by G.fec_paga desc, G.fec_inicio", nativeQuery = true)
	List<IDatosGuardia> ConsultaGuardiasInternas(String claveEmpleado);

	@Query(value = "Select rfc Clave_empleado, id_centro_trabajo, id_clave_servicio, id_puesto_plaza, "
			+ "id_nivel, id_sub_nivel, id_tipo_jornada, horas, fec_inicio, fec_fin, "
			+ "importe, id_tipo_tabulador, fec_paga, id_zona, riesgos, estado, id_ordinal "
			+ "From mclr_guardias_ext G, m4sys_hist_pagas P, m4t_centros_trab C, m4t_puestos_plaza PU "
			+ "Where G.fec_paga = P.fec_paga And "
			+ "G.id_centro_trabajo = C.id_centro_trabajo And "
			+ "G.id_puesto_plaza = PU.id_puesto_plaza And "
			+ "rfc = ?1 And "
			+ "PU.id_sociedad = '01' And "
			+ "PU.id_empresa = '01' "
			+ "Order by G.fec_paga desc, G.fec_inicio", nativeQuery = true)
	List<IDatosGuardia> ConsultaGuardiasExternas(String claveEmpleado);

	@Query(value="Select nombre From mclr_gys_bolsa_trabajo Where id_legal = ?", nativeQuery = true)
	String ValidaPersonalExterno(String rfc);

}
