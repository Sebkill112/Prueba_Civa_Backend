package com.civa.Prueba_Civa.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.civa.Prueba_Civa.entity.Futbolista;
import java.util.List;
import java.util.Optional;


public interface FutbolistaRepository extends JpaRepository<Futbolista, Integer>{
	
	

}
