package org.elis.Ecommerce.Facade;

import java.time.LocalDateTime;

import org.elis.Ecommerce.Exceptions.DatiNonValidiException;
import org.elis.Ecommerce.Mapper.OrdineMapper;
import org.elis.Ecommerce.Model.Ordine;
import org.elis.Ecommerce.Model.RigaDOrdine;
import org.elis.Ecommerce.Model.Ruolo;
import org.elis.Ecommerce.Repository.OrdineRepository;
import org.elis.Ecommerce.Repository.ProdottoRepository;
import org.elis.Ecommerce.Repository.RigaDOrdineRepository;
import org.elis.Ecommerce.Repository.UtenteRepository;
import org.elis.Ecommerce.Service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import DtoRequest.OrdineRequest;
import DtoResponse.OrdineDTO;

@Service
public class OrdineFacade {
	@Autowired
	OrdineRepository repo;
	@Autowired
	UtenteRepository utente_repo;
	@Autowired
	RigaDOrdineRepository rigaD_repo;
	@Autowired
	ProdottoRepository prodotto_repo;
	@Autowired
	OrdineService ordine_service;
	@Autowired
	OrdineMapper ordine_mapper;

	public OrdineDTO aggiungiOrdine(OrdineRequest request) {
		Ordine ordineDaConfermare= repo.findByIdAndCancellatoFalse(request.getId_Ordine()).orElseThrow(()->new DatiNonValidiException("Quest'ordine non esiste"));
		if(ordineDaConfermare.getCliente().getRuolo()==Ruolo.UTENTE&&ordineDaConfermare.getDataInvioOrdine()==null) {
			//operazioni e controlli sulla quantita dei prodotti
			if(ordineDaConfermare.getRighe().stream().anyMatch(r->r.getQuantita()>r.getProdotto().getQuantita()))throw new DatiNonValidiException("Impossibile confermare ordine: hai superato la quantità disponibile di un prodotto");
			ordineDaConfermare.getRighe().stream()
				.peek(r->r.getProdotto().setQuantita(r.getProdotto().getQuantita()-r.getQuantita()))
				//Stream<RigaDOrdine>
				.map(RigaDOrdine::getProdotto) //r->r.getProdotto() ---> su ogni oggetto chiamo il metodo che non prende parametri
				//Stream<Prodotto>
				.forEach(prodotto_repo::save);  //p->prodottoRepo.save(p) --> per ogni oggetto preso lo passo al metodo che lo prende come parametro
//			for(RigaDOrdine righe:ordineDaConfermare.getRighe()) {
//				if(righe.getQuantita()>righe.getProdotto().getQuantita())
//					throw new DatiNonValidiException("Impossibile confermare ordine: hai superato la quantità disponibile del prodotto: "+righe.getProdotto().getDescrizione());
//				else {
//					Prodotto p=prodottorepo.findById(righe.getProdotto().getId()).get();
//					p.setQuantita(p.getQuantita()-righe.getQuantita());
//					prodottorepo.save(p);
//				}
//			}	
			ordineDaConfermare.setDataInvioOrdine(LocalDateTime.now());
			ordine_service.aggiungiOrdine(ordineDaConfermare);
			return ordine_mapper.toDto(ordineDaConfermare);
		}
		return null;
	}

	public void rimuoviOrdine(OrdineRequest request) {
		Ordine or= repo.findByIdAndCancellatoFalse(request.getId_Ordine()).orElseThrow(()->new DatiNonValidiException("Categoria non trovata"));
		ordine_service.rimuoviOrdine(or);
	}
		
}

