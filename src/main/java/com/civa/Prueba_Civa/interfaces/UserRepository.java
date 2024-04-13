package com.civa.Prueba_Civa.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.civa.Prueba_Civa.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findByUsername(String user);
	
	 boolean existsByCorreo(String correo);
	 
	 boolean existsByUsername(String username);
	 
}
