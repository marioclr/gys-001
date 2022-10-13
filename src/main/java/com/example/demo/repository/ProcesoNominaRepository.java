package com.example.demo.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.IFechaHisPagas;
import com.example.demo.model.IProcesoNomina;
import com.example.demo.model.ProcesoNomina;

@Repository
public interface ProcesoNominaRepository extends JpaRepository<ProcesoNomina, Date>{


    @Query(value = "Select fec_paga,(fec_paga || ' - ' || n_hist_paga) fechas From m4sys_hist_pagas Where fec_paga >= '2022-10-15'", nativeQuery = true)
    List<IFechaHisPagas>getFechas();

    @Query(value = "Select * from fases_proceso_nomina Where fec_pago = ?", nativeQuery = true)
    List<IProcesoNomina> getBuscarFasesPorFecha(Date fec_pago);

}
