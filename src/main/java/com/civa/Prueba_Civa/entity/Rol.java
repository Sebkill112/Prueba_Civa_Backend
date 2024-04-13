 package com.civa.Prueba_Civa.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_rol")
	private Integer codigo;
	@Column(name = "descripcion_rol")
	private String descripcion;

	// relación UNO A MUCHOS
	@OneToMany(mappedBy = "tipoRol") // NOMBRE DE LA ASOCIACION
	@JsonIgnore
	private List<Usuario> listaUsuarios;
	

}
