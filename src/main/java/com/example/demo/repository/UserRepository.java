package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.IDatosUsuario;
import com.example.demo.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer> {

	@Query(value ="Select E.Nombre, P.Descripcion NombrePerfil, O.Nombre NombreOpcion, O.Componente \r\n"
			+ "From gys_Usuario U, gys_PrivilegiosUsuarios R, gys_Perfil P, gys_Opcion O, m4t_empleados E\r\n"
			+ "Where U.IdUsuario=R.IdUsuario\r\n"
			+ "  And P.IdPerfil=R.IdPerfil\r\n"
			+ "  And R.IdOpcion=O.IdOpcion\r\n"
			+ "  And U.id_sociedad=E.id_sociedad\r\n"
			+ "  And U.id_empleado=E.id_empleado\r\n"
			+ "  And U.IdUsuario=?\r\n"
			+ "Order by U.IdUsuario, R.IdPerfil, O.IdOpcion", nativeQuery = true)
	List<IDatosUsuario> getDatosUsuarios(Integer idUsuario);
	
	Usuario findByUsername(String username);
}
