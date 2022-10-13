package com.example.demo.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.IFechaHisPagas;
import com.example.demo.model.IProcesoNomina;
import com.example.demo.model.ProcesoNomina;
import com.example.demo.repository.ProcesoNominaRepository;
import com.example.demo.service.IProcesoNominaService;


@Service
public class ProcesoNominaServiceJpa implements IProcesoNominaService{
    @Autowired
	private ProcesoNominaRepository procesoNominaRepo;
    // Guardar registros de fases de proceso de nómina
    @Override
    public void guardar(ProcesoNomina procesoNomina) {
        procesoNominaRepo.save(procesoNomina);
        
    }   
    
    
    // Traer fechas de m4sys_hist_pagas
    @Override
    public List<IFechaHisPagas> getFechas(){
        return procesoNominaRepo.getFechas();
    }


    @Override
    public List<IProcesoNomina> getBuscarFasesPorFecha() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
