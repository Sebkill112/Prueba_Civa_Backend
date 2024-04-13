package com.civa.Prueba_Civa.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	String dni;
	String nombre;
	String apellido;
	String correo;
	String username;
	String password;
	Integer rol;


}
