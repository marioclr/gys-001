package com.example.demo.service;

import java.util.List;

import com.example.demo.model.IDatosUsuario;
import com.example.demo.model.Usuario;

public interface IUsuarioService {

	List<IDatosUsuario> datosUsuario(Integer idUsuario);
	Usuario buscarPorUsername(String username);
}
