package com.example.demo.model;

import java.util.Date;

public interface IDatosGuardia {
	String getClave_empleado(); // 1
	String getId_centro_trabajo();    // 2
	String getId_clave_servicio(); // 3
	String getId_puesto_plaza(); // 4
	String getId_nivel(); // 5
	String getId_sub_nivel(); // 6
	String getId_tipo_jornada(); // 7
	String getHoras(); // 8
	Date getFec_inicio(); // 9
	Date getFec_fin(); // 10
	Double getImporte(); // 11
	String getIdtipo_tabulador(); // 12
	Date getFec_paga(); // 13
	String getId_zona(); // 14
	String getRiesgos(); // 15
	String getEstado(); // 16
	String getId_ordinal(); // 17
}
