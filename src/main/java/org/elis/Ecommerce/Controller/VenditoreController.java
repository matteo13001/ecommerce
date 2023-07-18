package org.elis.Ecommerce.Controller;

import org.elis.Ecommerce.Facade.ProdottoFacade;
import org.elis.Ecommerce.Facade.UtenteFacade;
import org.elis.Ecommerce.Model.Prodotto;
import org.elis.Ecommerce.Model.Utente;
import org.elis.Ecommerce.ServiceImpl.ProdottoServiceImpl;
import org.elis.Ecommerce.ServiceImpl.UtenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DtoRequest.LoginRequest;
import DtoRequest.ProdottoRequest;
import DtoRequest.RegistrazioneRequest;
import DtoResponse.ProdottoDTO;
import DtoResponse.UtenteDTO;

@RestController
@RequestMapping("/VenditoreController")
public class VenditoreController {
	
			
			@Autowired
			UtenteFacade utenteFacade;
			@Autowired
			ProdottoFacade prodottoFacade;
			
			@PostMapping("/utente/add")
			public ResponseEntity<UtenteDTO> registrati(@RequestBody RegistrazioneRequest request){
				UtenteDTO u=utenteFacade.aggiungiVenditore(request);
				if(u==null)return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				else return ResponseEntity.ok(u);
			}
			@PostMapping("/utente/login")
			public ResponseEntity<UtenteDTO> login(@RequestBody LoginRequest request){
				UtenteDTO u=utenteFacade.loginUtente(request);
				if(u==null)return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				 return ResponseEntity.ok(u);
			}
			@PostMapping("/prodotto/add")
			public ResponseEntity<ProdottoDTO> aggiungiProdotto(@RequestBody ProdottoRequest request){
				ProdottoDTO c = prodottoFacade.aggiungiProdotto(request);
				if (c == null) 
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
				return ResponseEntity.ok(c);
			}
			@PostMapping("/prodotto/delete/{id}")
			public ResponseEntity<Void> rimuoviProdotto(@PathVariable long id){
				 prodottoFacade.deleteProdotto(id);
				return ResponseEntity.ok().build();
			}
			@GetMapping("/prodotto/findAll")
			public ResponseEntity<Void> findAllProdotti(){
				prodottoFacade.findAllProdotti();
				return ResponseEntity.ok().build();
			}
			@GetMapping("/prodotto/findAllByMarca")
			public ResponseEntity<Void> findAllProdottiByMarca(String marca){
				prodottoFacade.findAllProdottiByMarca(marca);
				return ResponseEntity.ok().build();
			}
			

}
