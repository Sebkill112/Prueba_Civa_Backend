package com.civa.Prueba_Civa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.civa.Prueba_Civa.entity.Futbolista;
import com.civa.Prueba_Civa.service.FutbolistaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/futbolista")
@RequiredArgsConstructor
public class FutbolistaController {

	
	@Autowired
	private FutbolistaService servicio;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Futbolista>> listar(){
		List<Futbolista> lista = servicio.listaFutbolistas();
		return ResponseEntity.ok(lista);
	}
	
    @GetMapping("/{id}")
	public ResponseEntity<Futbolista> obtenerFutbolistaPorId(@PathVariable int id) {
        Optional<Futbolista> futbolistaOptional = servicio.buscarPorId(id);
        if (futbolistaOptional.isPresent()) {
            return ResponseEntity.ok(futbolistaOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	
}
