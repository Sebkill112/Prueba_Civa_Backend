package com.civa.Prueba_Civa.auth;

import java.text.ParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.civa.Prueba_Civa.entity.Rol;
import com.civa.Prueba_Civa.entity.Usuario;
import com.civa.Prueba_Civa.interfaces.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@PostMapping(value = "login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		 try {
		        AuthResponse authResponse = authService.login(request);
		        return ResponseEntity.ok(authResponse);
		    } catch (Exception e) {
		        e.printStackTrace(); // Log the exception (consider using a proper logging framework).
		        String errorResponse = "Usuario y/o Contraseña invalida";
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(errorResponse);
		    }
	}

	@PostMapping(value = "register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request) throws ParseException {
	    
		  boolean emailExists = userRepository.existsByCorreo(request.getCorreo());
		   boolean usernameExists = userRepository.existsByUsername(request.getUsername());
	    
	    if (emailExists) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El Usuario con Correo: " + request.getCorreo() + " ya está registrado");
	    }else if (usernameExists){
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El Usuario con Username: " + request.getUsername() + " ya está registrado");
	    }else {
	    	Usuario user = new Usuario();

		    user.setDni(request.getDni());
			user.setNombre(request.getNombre());
			user.setApellido(request.getApellido());
			user.setCorreo(request.getCorreo());
			user.setUsername(request.getUsername());
			user.setClave(passwordEncoder.encode(request.getPassword()));
			Rol rol = new Rol();
			rol.setCodigo(request.getRol());
			user.setTipoRol(rol);
			
			userRepository.save(user);
		    
		    return ResponseEntity.ok("Usuario registrado correctamente");
	    }

	    
	}
	

}
