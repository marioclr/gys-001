package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.IDatosUsuario;

public interface IUsuarioService {

	List<IDatosUsuario> datosUsuario(Integer idUsuario);
}
