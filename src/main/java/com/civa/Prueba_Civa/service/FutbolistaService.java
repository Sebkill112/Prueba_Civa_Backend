package com.civa.Prueba_Civa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.civa.Prueba_Civa.entity.Futbolista;
import com.civa.Prueba_Civa.interfaces.FutbolistaRepository;

@Service
public class FutbolistaService {

	@Autowired
	private FutbolistaRepository repo;

	public List<Futbolista> listaFutbolistas() {

		return repo.findAll();
	}

	public Optional<Futbolista> buscarPorId(int id) {

		return repo.findById(id);
	}

	public Futbolista grabar(Futbolista futbolista) {
		return repo.save(futbolista);
	}

	public void eliminar(int id) {
		repo.deleteById(id);
	}

}
