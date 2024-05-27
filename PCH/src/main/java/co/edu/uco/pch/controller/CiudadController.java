package co.edu.uco.pch.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.pch.business.facade.impl.ciudad.ConsultarCiudadesFacade;
import co.edu.uco.pch.business.facade.impl.ciudad.RegistrarCiudadFacade;
import co.edu.uco.pch.controller.response.CiudadResponse;
import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.dto.CiudadDTO;

@RestController
@RequestMapping("/api/v1/ciudades")
public class CiudadController {
	
	@GetMapping("/dummy")
	public CiudadDTO dummy() {
		
		return CiudadDTO.build();
		
	}
	
	public ResponseEntity<CiudadResponse> consultar(){
		
		var hhtpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try {
			
			var ciudadDto = CiudadDTO.build();
			var facade = new ConsultarCiudadesFacade();
			
			ciudadResponse.setDatos(facade.execute(null));
			ciudadResponse.getMensajes().add("Ciudades consultadas exitosamente");
			
		} catch (final PCHException excepcion) {
			hhtpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			hhtpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar la informacion de las ciudades";
			ciudadResponse.getMensajes().add(mensajeUsuario);
			
			excepcion.printStackTrace();
		}
		
		
		return new ResponseEntity<>(ciudadResponse, hhtpStatusCode);
		
	}
	
	@PostMapping
    public ResponseEntity<CiudadResponse> crear(@RequestBody CiudadDTO ciudad){
		
		var hhtpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try {
			var facade = new RegistrarCiudadFacade();
			facade.execute(ciudad);
			ciudadResponse.getMensajes().add("Ciudad creada exitosamente");
			
		} catch (final PCHException excepcion) {
			hhtpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			hhtpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = "Se ha presentado un problema tratando de registrar la informacion de la nueva ciudad";
			ciudadResponse.getMensajes().add(mensajeUsuario);
			
			excepcion.printStackTrace();
		}
		
		
		return new ResponseEntity<>(ciudadResponse, hhtpStatusCode);
		
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<CiudadResponse> eliminar(@PathVariable UUID id){
		
		var hhtpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try {
			//var facade = new EliminarrCiudadFacade();
			//facade.execute(id);
			ciudadResponse.getMensajes().add("Ciudad eliminada exitosamente");
			
		} catch (final PCHException excepcion) {
			hhtpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			hhtpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = "Se ha presentado un problema tratando de eliminar la informacion de la nueva ciudad";
			ciudadResponse.getMensajes().add(mensajeUsuario);
			
			excepcion.printStackTrace();
		}
		
		
		return new ResponseEntity<>(ciudadResponse, hhtpStatusCode);
		
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<CiudadResponse> modificar(@PathVariable UUID id, @RequestBody CiudadDTO ciudadDto){
		
		var hhtpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try {
			//var facade = new ModificarCiudadFacade();
			//facade.execute(id);
			ciudadResponse.getMensajes().add("Ciudad modificada exitosamente");
			
		} catch (final PCHException excepcion) {
			hhtpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getMensajeUsuario());
			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			hhtpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = "Se ha presentado un problema tratando de modificar la informacion de la nueva ciudad";
			ciudadResponse.getMensajes().add(mensajeUsuario);
			
			excepcion.printStackTrace();
		}
		
		
		return new ResponseEntity<>(ciudadResponse, hhtpStatusCode);
		
	}
	

}
