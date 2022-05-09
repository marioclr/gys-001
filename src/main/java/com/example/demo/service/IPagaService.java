package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.model.Paga;

public interface IPagaService {
	void guardar(Paga paga);
	void eliminar(Paga paga);
	List<Paga> buscarTodas();
	Paga buscarPorid(Date fecha);
	List<Paga> buscarPorEstado(String estado);
}
