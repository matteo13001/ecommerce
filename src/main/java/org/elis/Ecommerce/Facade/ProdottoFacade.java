package org.elis.Ecommerce.Facade;

import java.util.List;

import org.elis.Ecommerce.Exceptions.DatiNonValidiException;
import org.elis.Ecommerce.Mapper.ProdottoMapper;
import org.elis.Ecommerce.Model.Marca;
import org.elis.Ecommerce.Model.Prodotto;
import org.elis.Ecommerce.Model.SottoCategoria;
import org.elis.Ecommerce.Model.Utente;
import org.elis.Ecommerce.Repository.MarcaRepository;
import org.elis.Ecommerce.Repository.ProdottoRepository;
import org.elis.Ecommerce.Repository.SottoCategoriaRepository;
import org.elis.Ecommerce.Repository.UtenteRepository;
import org.elis.Ecommerce.Service.MarcaService;
import org.elis.Ecommerce.Service.ProdottoService;
import org.elis.Ecommerce.Service.RigaDOrdineService;
import org.elis.Ecommerce.Service.SottoCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DtoRequest.ProdottoRequest;
import DtoResponse.ProdottoDTO;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ProdottoFacade {
	@Autowired
	ProdottoRepository repo;
	@Autowired
	SottoCategoriaRepository repo_sottoCat;
	@Autowired
	UtenteRepository repo_utente;
	@Autowired
	MarcaRepository repo_marca;
	@Autowired
	ProdottoService repo_service;
	@Autowired
	ProdottoMapper repo_map;
	

	
	
	public ProdottoDTO aggiungiProdotto(ProdottoRequest request) {
		Utente ut =repo_utente.findUtenteByUsernameAndCancellatoFalse(request.getUser_venditore()).orElseThrow(()->new DatiNonValidiException(request,"Username non trovato"));
		Marca m = repo_marca.findMarcaByNomeAndCancellatoFalse(request.getMarca()).orElseThrow(()->new DatiNonValidiException(request,"Marca non trovata"));
			List<SottoCategoria>sottocategorie= repo_sottoCat.findAllById(request.getId_sottoCategoria());
			Prodotto p =repo.findProdottoByNomeAndVenditore_UsernameAndCancellatoFalse(request.getNome(),request.getUser_venditore()).orElse(null);
			if(p!=null) {
				p.setQuantita(request.getQuantita()+p.getQuantita());
			repo_service.aggiungiProdotto(p);
			return repo_map.toDto(p);
			}
			Prodotto prodottoN = new Prodotto(request);;
			sottocategorie.forEach(s->s.getProdotti().add(prodottoN));
			prodottoN.setSottoCategoria(sottocategorie);
			prodottoN.setVenditore(ut);
			prodottoN.setMarca(m);
			repo_service.aggiungiProdotto(prodottoN);
			return repo_map.toDto(prodottoN);
	}
	public void deleteProdotto(long id) {
		Prodotto p =repo.findByIdAndCancellatoFalse(id).orElseThrow(()->new DatiNonValidiException("Prodotto non trovato"));
		p.setCancellato(true);
		repo.save(p);
	}
	
	public List<Prodotto> findAllProdotti(){
		return repo.findAll();	
	}
	public List<Prodotto> findAllProdottiByMarca(String marca){
		Marca m= repo_marca.findMarcaByNomeAndCancellatoFalse(marca).orElseThrow(()->new DatiNonValidiException("Marca non trovata"));
		return repo.findAllByMarcaAndCancellatoFalse(m);
		
	}
	
	
	
}