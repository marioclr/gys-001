package com.example.demo.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Adscripcion;
import com.example.demo.model.IDatosAdscripcion;
import com.example.demo.repository.AdscripcionRepository;
import com.example.demo.service.IAdscripcionService;

@Service
public class AdscripcionServiceJpa implements IAdscripcionService {

	@Autowired
	AdscripcionRepository repoAdscripcion;

	@Override
	public List<Adscripcion> buscarTodos() {
		return repoAdscripcion.findAll();
	}

}
