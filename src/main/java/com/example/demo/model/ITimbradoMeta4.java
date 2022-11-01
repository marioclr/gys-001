package com.example.demo.model;

import java.util.Date;

public interface ITimbradoMeta4 {
    Integer getRegistros_meta4();
    Date getFec_pago_proceso();
    Double getIsr_Meta4();
    Double getIsr_Registrado_sb();
    Integer getLayout_Recibidos_sb();
    Integer getRecibos_No_Reportados();
    Integer getRegistros();
    Double getIsr();
    Integer getRegistros_no_timbrados();
    Double getIsr_no_timbrado();
    Integer getRegistros_timbrados();  
}
