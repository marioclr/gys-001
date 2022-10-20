package com.example.demo.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.IFechaHisPagas;
import com.example.demo.model.IPorcentajeNomina;
import com.example.demo.model.IProcesoNomina;
import com.example.demo.model.ProcesoNomina;

@Repository
public interface ProcesoNominaRepository extends JpaRepository<ProcesoNomina, Integer>{

    @Query(value = "Select Count(*) conteo, validado From fases_proceso_nomina Group By validado", nativeQuery = true)
    List<IPorcentajeNomina> getProcentajeProgreso();

    @Query(value = "Select fec_paga,(fec_paga || ' - ' || n_hist_paga) fechas \r\n"
                    +"From m4_hist_pagas \r\n"
                    +"Where (day(fec_paga) = '15' or \r\n"
                    +"(day(fec_paga) = '30' And month(fec_paga)='04') Or \r\n"
                    +"(day(fec_paga) = '30' And month(fec_paga)='06') Or \r\n"
                    +"(day(fec_paga) = '30' And month(fec_paga)='09') Or \r\n"
                    +"(day(fec_paga) = '30' And month(fec_paga)='11') Or \r\n"
                    +"(day(fec_paga) = '31' And month(fec_paga)='01') Or \r\n"
                    +"(day(fec_paga) = '31' And month(fec_paga)='03') Or \r\n"
                    +"(day(fec_paga) = '31' And month(fec_paga)='05') Or \r\n"
                    +"(day(fec_paga) = '31' And month(fec_paga)='07') Or \r\n"
                    +"(day(fec_paga) = '31' And month(fec_paga)='08') Or \r\n"
                    +"(day(fec_paga) = '31' And month(fec_paga)='10') Or \r\n"
                    +"(day(fec_paga) = '31' And month(fec_paga)='12') Or \r\n"
                    +"(day(fec_paga) = '28' And month(fec_paga)='02') Or \r\n"
                    +"(day(fec_paga) = '29' And month(fec_paga)='02'))"
                    +"And year(fec_paga) >= year(today) order by fec_paga desc", nativeQuery = true)
    List<IFechaHisPagas>getFechas();

    @Query(value = "Select * from fases_proceso_nomina", nativeQuery = true)
    List<IProcesoNomina> getMostrarFases();

    // llama al datatables
    @Query(value = "Select * From fases_proceso_nomina Where fec_pago = ? order by fec_ini", nativeQuery = true)
    List<IProcesoNomina> buscarFasesPorFecha(Date fecha_paga);


}
