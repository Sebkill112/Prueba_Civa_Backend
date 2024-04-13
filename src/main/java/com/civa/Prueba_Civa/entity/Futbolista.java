package com.civa.Prueba_Civa.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "futbolistas")
@Getter
@Setter
public class Futbolista {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "nombres")
	    private String nombres;

	    @Column(name = "apellidos")
	    private String apellidos;

	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" , timezone = "America/Lima")
		@Temporal(TemporalType.DATE)
	    @Column(name = "fecha_nacimiento")
	    private Date fechaNacimiento;

	    @Column(name = "caracteristicas")
	    private String caracteristicas;

	    @ManyToOne
	    @JoinColumn(name = "posicion_id")
	    private Posicion posicion;

}
