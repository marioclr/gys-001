package com.example.demo.service.db;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.IFechaHisPagas;
import com.example.demo.model.IPorcentajeNomina;
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
    public List<IProcesoNomina> getMostrarFases() {
    
        return procesoNominaRepo.getMostrarFases();
    }


    // Mostrar porcentaje de progreso
    @Override
    public List<IPorcentajeNomina> getProcentajeProgreso() {
        return procesoNominaRepo.getProcentajeProgreso();
    }


    @Override
    public ProcesoNomina buscarFecha(Date fec_pago) {
        Optional<ProcesoNomina> opcional =  procesoNominaRepo.findById(fec_pago);
		if(opcional.isPresent()) {
			return opcional.get();
		}
		return null;
    }


    @Override
    public List<IProcesoNomina> getBuscarFasesPorFecha(Date fec_pago) {
       
        return procesoNominaRepo.buscarFasesPorFecha(fec_pago);
    }


    // https://es.stackoverflow.com/questions/311902/b%C3%BAsqueda-de-datos-entre-2-fechas-spring-boot
    
}
