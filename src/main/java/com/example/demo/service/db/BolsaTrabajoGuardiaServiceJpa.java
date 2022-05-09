package com.example.demo.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BolsaTrabajoGuardias;
import com.example.demo.model.IDatosDelegacion;
import com.example.demo.repository.BolsaTrabajoGuardiasRepository;
import com.example.demo.service.IBolsaTrabajoGuardiasService;

@Service
public class BolsaTrabajoGuardiaServiceJpa implements IBolsaTrabajoGuardiasService{

	@Autowired
	private BolsaTrabajoGuardiasRepository bolsaTrabRepo;

	// @Override
	public BolsaTrabajoGuardias buscarId(Integer id) {
		Optional<BolsaTrabajoGuardias> opcional =  bolsaTrabRepo.findById(id);
		if(opcional.isPresent()) {
			return opcional.get();
		}
		return null;
	}

	public  void eliminar(Integer id){
		bolsaTrabRepo.deleteById(id);
	}
	
	// @Override
	public List<BolsaTrabajoGuardias> buscarTodos(){
		return bolsaTrabRepo.findAll();
	}

	// @Override
	public List<IDatosDelegacion> getDatosDelegacion() {

		return bolsaTrabRepo.getDatosDelegacion();
	}

	// @Override
	public void guardar(BolsaTrabajoGuardias bolsaTrabajo) {
		bolsaTrabRepo.save(bolsaTrabajo);
		
	}
	
	

}
