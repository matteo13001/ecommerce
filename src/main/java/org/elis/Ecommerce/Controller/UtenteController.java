package org.elis.Ecommerce.Controller;

import java.util.List;
import org.elis.Ecommerce.Facade.UtenteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DtoRequest.LoginRequest;
import DtoRequest.RegistrazioneRequest;
import DtoResponse.UtenteDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/UtenteController")
public class UtenteController {
	
	@Autowired
	UtenteFacade utenteFacade;
	
	@PostMapping("/utente/add")
	public ResponseEntity<UtenteDTO> registrati( @RequestBody RegistrazioneRequest request){
		UtenteDTO u=utenteFacade.aggiungiUtente(request);
		return ResponseEntity.ok(u);
	}
	@PostMapping("/utente/login")
	public ResponseEntity<UtenteDTO> login( @RequestBody LoginRequest request){
		UtenteDTO u=utenteFacade.loginUtente(request);
		 return ResponseEntity.ok(u);
	}
	@GetMapping("utente/findAll")
	public ResponseEntity<List<UtenteDTO>> findAll(){
		List<UtenteDTO> u=utenteFacade.findAll();
		 return ResponseEntity.ok(u);
	}


}
