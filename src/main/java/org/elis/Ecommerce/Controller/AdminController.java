package org.elis.Ecommerce.Controller;

import org.elis.Ecommerce.Facade.CategoriaFacade;

import org.elis.Ecommerce.Facade.MarcaFacade;
import org.elis.Ecommerce.Facade.ProdottoFacade;
import org.elis.Ecommerce.Facade.SottoCategoriaFacade;
import org.elis.Ecommerce.Facade.UtenteFacade;
import org.elis.Ecommerce.Model.Prodotto;
import org.elis.Ecommerce.Service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import DtoRequest.CategoriaRequest;
import DtoRequest.LoginRequest;
import DtoRequest.MarcaRequest;
import DtoRequest.ProdottoRequest;
import DtoRequest.RegistrazioneRequest;
import DtoRequest.SottoCategoriaRequest;
import DtoResponse.CategoriaDTO;
import DtoResponse.MarcaDTO;
import DtoResponse.ProdottoDTO;
import DtoResponse.SottoCategoriaDTO;
import DtoResponse.UtenteDTO;
import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/AdminController")
public class AdminController {
		
		@Autowired
		UtenteFacade utenteFacade;

		@Autowired
		CategoriaFacade Facade;

		@Autowired 
		MarcaFacade marcaFacade;
		
		@Autowired
		ProdottoFacade prodottoFacade;
		
		@Autowired
		SottoCategoriaFacade sottoCategoriaFacade;
		
		@Autowired
		CategoriaFacade categoriaFacade;
		
		@Autowired ProdottoService prodottoService;
		
		@PostMapping("/admin/add")
		public ResponseEntity<UtenteDTO> registrati(@RequestBody RegistrazioneRequest request){
			UtenteDTO u=utenteFacade.aggiungiAdmin(request);
			return ResponseEntity.ok(u);
		}
		@PostMapping("/admin/login")
		public ResponseEntity<UtenteDTO> login(@RequestBody LoginRequest request){
			UtenteDTO u=utenteFacade.loginUtente(request);
			 return ResponseEntity.ok(u);
		}
		@PostMapping("/admin/categoria/add")
		public ResponseEntity<CategoriaDTO> aggiungiCategoria( @RequestBody CategoriaRequest request){
			CategoriaDTO c =categoriaFacade.aggiungiCategoria(request);
			return ResponseEntity.ok(c);
		}
		@PostMapping("/admin/categoria/delete")
		public ResponseEntity<Void> eliminaCategoria( @RequestBody CategoriaRequest request){
			categoriaFacade.deleteCategoria(request);
			return ResponseEntity.ok().build();
	}
		@PostMapping("/admin/marca/add")
		public ResponseEntity<MarcaDTO> aggiungiMarca(@RequestBody MarcaRequest request){
			MarcaDTO m = marcaFacade.aggiungiMarca(request);
			return ResponseEntity.ok(m);
		}
		@PostMapping("/admin/marca/delete")
		public ResponseEntity<Void> eliminaMarca(@RequestBody MarcaRequest request){
			marcaFacade.eliminaMarca(request);
			return ResponseEntity.ok().build();
		}
	/*	@PostMapping("/admin/prodotto/add")
		public ResponseEntity<ProdottoDTO> aggiungiProdotto(@RequestBody ProdottoRequest request){
			ProdottoDTO c = prodottoFacade.aggiungiProdotto(request);
			return ResponseEntity.ok(c);
			
		}
		*/
		
		@PostMapping("/admin/prodotto/delete/{id}")
		public ResponseEntity<Void> rimuoviProdotto(@PathVariable long id){
			 prodottoFacade.deleteProdotto(id);
			return ResponseEntity.ok().build();
		}
		@GetMapping("/admin/prodotto/findAll")
		public ResponseEntity<Void> findAllProdotti(){
			prodottoFacade.findAllProdotti();
			return ResponseEntity.ok().build();
		}
		@GetMapping("/admin/prodotto/findAllByMarca")
		public ResponseEntity<Void> findAllProdottiByMarca(String marca){
			prodottoFacade.findAllProdottiByMarca(marca);
			return ResponseEntity.ok().build();
		}
		@PostMapping("/admin/sottoCategoria/add")
		public ResponseEntity<SottoCategoriaDTO> aggiungiSC(@RequestBody SottoCategoriaRequest request){
			SottoCategoriaDTO sc = sottoCategoriaFacade.aggiungiSC(request);
			return ResponseEntity.ok(sc);
		}
		@PostMapping("/admin/sottoCategoria/delete")
		public ResponseEntity<Void> eliminaSC(@RequestBody SottoCategoriaRequest request){
				sottoCategoriaFacade.deleteByNome(request);
			return ResponseEntity.ok().build();
		}
		
	
		
}
