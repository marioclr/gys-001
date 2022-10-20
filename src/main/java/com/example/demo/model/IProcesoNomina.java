package com.example.demo.model;

import java.util.Date;

public interface IProcesoNomina {
    Integer getId();
    Date getFec_Pago();
    String getActividad();
    Date getFec_Ini();
    Date getFec_Fin();
    Boolean getValidado();    
    
}
