package com.example.demo.service.db;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Paga;
import com.example.demo.repository.PagaRepository;
import com.example.demo.service.IPagaService;

@Service
public class PagasServiceJpa implements IPagaService {

	@Autowired
	private PagaRepository repoPagas;
	
	@Override
	public void guardar(Paga paga) {
		
		repoPagas.save(paga);
	}

	@Override
	public void eliminar(Paga paga) {
		repoPagas.delete(paga);
	}

	@Override
	public List<Paga> buscarTodas() {
		return repoPagas.findAll();
	}

	@Override
	public Paga buscarPorid(Date fecha) {
		Optional<Paga> optional = repoPagas.findById(fecha);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Paga> buscarPorEstado(String estado) {
		return repoPagas.findByEstado(estado);
	}
}
