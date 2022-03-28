package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, estatus from gys_Usuario where username=?")
		.authoritiesByUsernameQuery("Select Distinct username, P.Descripcion Perfil " + 
			"From gys_Usuario U, gys_PrivilegiosUsuarios R, gys_Perfil P " + 
			"Where U.IdUsuario=R.IdUsuario And P.IdPerfil=R.IdPerfil " + 
			"And U.username = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		// //Recursos estaticos
        // .antMatchers(
        //     "/css/**",
        //     "/img/**",
        //     "/js/**",
        //     "/vendor/**"
        // ).permitAll()
        // //Permitir vista de login
        // .antMatchers("/login").permitAll()

        // .anyRequest().authenticated()

		//.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
        .defaultSuccessUrl("/", true)
        .and().logout().permitAll();
	}
	
	/**
	 *  Implementación de Spring Security que encripta passwords con el algoritmo Bcrypt
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) 
//	  throws Exception {
//	    auth.jdbcAuthentication()
//	      .dataSource(dataSource)
//	      .usersByUsernameQuery("Select clave, password From gys_Usuario where clave = ?")
//	      .authoritiesByUsernameQuery("Select Distinct clave, P.Descripcion NombrePerfil "
//	        + "From gys_Usuario U, gys_PrivilegiosUsuarios R, gys_Perfil P "
//	        + "Where U.IdUsuario=R.IdUsuario And P.IdPerfil=R.IdPerfil"
//	        + "And U.clave = ?");
//	}
}
