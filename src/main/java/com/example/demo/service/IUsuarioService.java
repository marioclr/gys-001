package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.IDatosUsuario;

public interface IUsuarioService {

	IDatosUsuario datosUsuario(Integer idUsuario);
}
