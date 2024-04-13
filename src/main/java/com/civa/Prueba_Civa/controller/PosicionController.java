package com.civa.Prueba_Civa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.civa.Prueba_Civa.entity.Posicion;
import com.civa.Prueba_Civa.service.PosicionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posicion")
@RequiredArgsConstructor
public class PosicionController {
	
	
	@Autowired
	private PosicionService servicio;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Posicion>> listar(){
		List<Posicion> lista = servicio.listar();
		return ResponseEntity.ok(lista);
	}
	

}
