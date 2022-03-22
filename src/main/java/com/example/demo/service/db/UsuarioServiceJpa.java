package com.example.demo.service.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.IDatosUsuario;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUsuarioService;

@Service
public class UsuarioServiceJpa implements IUsuarioService {

	@Autowired
	UserRepository repoUsuario;
	
	@Override
	public IDatosUsuario datosUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		return repoUsuario.getDatosUsuarios(idUsuario);
	}

}
