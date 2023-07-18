package org.elis.Ecommerce.Facade;

import org.elis.Ecommerce.Exceptions.DatiNonValidiException;
import org.elis.Ecommerce.Mapper.RigaDOrdineMapper;
import org.elis.Ecommerce.Model.Ordine;
import org.elis.Ecommerce.Model.Prodotto;
import org.elis.Ecommerce.Model.RigaDOrdine;
import org.elis.Ecommerce.Model.Utente;
import org.elis.Ecommerce.Repository.OrdineRepository;
import org.elis.Ecommerce.Repository.ProdottoRepository;
import org.elis.Ecommerce.Repository.RigaDOrdineRepository;
import org.elis.Ecommerce.Repository.UtenteRepository;
import org.elis.Ecommerce.Service.RigaDOrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DtoRequest.RigaDOrdineRequest;
import DtoResponse.RigaDOrdineDTO;

@Service
public class RigaDOrdineFacade {

	@Autowired
	RigaDOrdineRepository repo;
	@Autowired
	OrdineRepository ordine_repo;
	@Autowired
	ProdottoRepository prodotto_repo;
	@Autowired
	UtenteRepository utente_repo;
	@Autowired
	RigaDOrdineService riga_serv;
	@Autowired
	RigaDOrdineMapper riga_map;
	

	public RigaDOrdineDTO aggiungiRiga(RigaDOrdineRequest request) {
		if (request==null)
		return null;
		Utente u = utente_repo.findUtenteByIdAndCancellatoFalse(request.getId_cliente()).orElseThrow(()-> new DatiNonValidiException(request,"Utente non trovato"));
		Ordine oP = ordine_repo.findOrdineByDataInvioOrdineNullAndCliente_IdAndCancellatoFalse(request.getId_cliente()).orElse(null);
		Prodotto p = prodotto_repo.findProdottoByDescrizioneAndCancellatoFalse(request.getProdotto()).orElseThrow(()-> new DatiNonValidiException(request,"Prodotto non trovato"));
		if(oP == null) {
			oP =  new Ordine();
			oP.setCliente(u);
		}
		RigaDOrdine rO = repo.findRigaDordineByProdotto_IdAndOrdine_idAndCancellatoFalse(p.getId(), oP.getId()).orElse(null);
		if(rO == null) {		
			rO = new RigaDOrdine(p,request.getQuantita(),oP);
			if(p.getQuantita() < rO.getQuantita())
				throw new DatiNonValidiException(request,"la quantità supera il massimo disponibile");
			oP.setPrezzo_tot(oP.getPrezzo_tot()+p.getPrezzoIvato()*request.getQuantita());
				riga_serv.aggiungiRiga(rO);
				return riga_map.toDto(rO);
		}
		rO.setQuantita(rO.getQuantita()+ request.getQuantita());
		oP.setPrezzo_tot(oP.getPrezzo_tot()+p.getPrezzoIvato()*request.getQuantita());
			riga_serv.aggiungiRiga(rO);
			return riga_map.toDto(rO);
	
	}

	public void eliminaRiga(long id) {
			RigaDOrdine rigaDaCancellare=repo.findById(id).orElseThrow(()->new DatiNonValidiException("riga non esistente"));
			Ordine o=rigaDaCancellare.getOrdine();
			Prodotto p=rigaDaCancellare.getProdotto();
			o.setPrezzo_tot(o.getPrezzo_tot()-(p.getPrezzoIvato()*rigaDaCancellare.getQuantita()));
			ordine_repo.save(o);
			repo.deleteById(id);
		}
		
}
