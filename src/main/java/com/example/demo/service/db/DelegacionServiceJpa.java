package com.example.demo.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Delegacion;
import com.example.demo.repository.DelegacionRepository;
import com.example.demo.service.IDelegacionService;

@Service
public class DelegacionServiceJpa implements IDelegacionService {
	
	@Autowired
	DelegacionRepository repoDelegacion;
	
	@Override
	public List<Delegacion> buscarTodas() {
		return repoDelegacion.findAll();
	}

}
