package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Paga;

public interface PagaRepository extends JpaRepository<Paga, Date> {

	List<Paga> findByEstado(String estado);
}
