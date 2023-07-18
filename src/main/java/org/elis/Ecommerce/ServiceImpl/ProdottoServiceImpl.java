package org.elis.Ecommerce.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.elis.Ecommerce.Exceptions.DatiNonValidiException;
import org.elis.Ecommerce.Model.Marca;
import org.elis.Ecommerce.Model.Prodotto;
import org.elis.Ecommerce.Model.SottoCategoria;
import org.elis.Ecommerce.Model.Utente;
import org.elis.Ecommerce.Repository.MarcaRepository;
import org.elis.Ecommerce.Repository.ProdottoRepository;
import org.elis.Ecommerce.Repository.SottoCategoriaRepository;
import org.elis.Ecommerce.Repository.UtenteRepository;
import org.elis.Ecommerce.Service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DtoRequest.ProdottoRequest;
@Service
public class ProdottoServiceImpl implements ProdottoService{
	
	@Autowired
	ProdottoRepository repo;
	@Autowired
	SottoCategoriaRepository repo_sottoCat;
	@Autowired
	UtenteRepository repo_utente;
	@Autowired
	MarcaRepository repo_marca;
	
	
	
	
	@Override
	public Prodotto aggiungiProdotto(Prodotto p) {
			return repo.save(p);
	}

	@Override
	public void deleteProdotto(Prodotto p) {
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
