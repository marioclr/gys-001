package com.example.demo.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.IDatosUsuario;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUsuarioService;

@Service
public class UsuarioServiceJpa implements IUsuarioService {

	@Autowired
	UserRepository repoUsuario;
	
	@Override
	public List<IDatosUsuario> datosUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		return repoUsuario.getDatosUsuarios(idUsuario);
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		return repoUsuario.findByUsername(username);
	}

}
