package com.civa.Prueba_Civa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.civa.Prueba_Civa.entity.Posicion;
import com.civa.Prueba_Civa.interfaces.PosicionRepository;

@Service
public class PosicionService {
	
	
	
	@Autowired
	private PosicionRepository repository;
	
	
	public List<Posicion> listar() {
	
		return repository.findAll();
	}

}
