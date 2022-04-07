package com.example.demo.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Adscripcion;
// import com.example.demo.model.IDatosAdscripcion;

public interface AdscripcionRepository extends JpaRepository<Adscripcion, String> {

}
