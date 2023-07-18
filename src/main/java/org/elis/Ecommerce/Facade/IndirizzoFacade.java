package org.elis.Ecommerce.Facade;

import org.elis.Ecommerce.Exceptions.DatiNonValidiException;
import org.elis.Ecommerce.Mapper.IndirizzoMapper;
import org.elis.Ecommerce.Model.Indirizzo;
import org.elis.Ecommerce.Model.Utente;
import org.elis.Ecommerce.Repository.IndirizzoRepository;
import org.elis.Ecommerce.Repository.UtenteRepository;
import org.elis.Ecommerce.Service.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DtoRequest.IndirizzoRequest;
import DtoResponse.IndirizzoDTO;

@Service
public class IndirizzoFacade {
	@Autowired
	IndirizzoRepository repo;
	@Autowired
	UtenteRepository utente_repo;
	@Autowired
	IndirizzoService indirizzo_service;
	@Autowired
	IndirizzoMapper indirizzo_map;
	
	

	public IndirizzoDTO aggiungiIndirizzo(IndirizzoRequest request) {
		if(request.getCap() == null || request.getComune() == null || request.getId_utente() < 0 || request.getIndirizzo1() == null || request.getNome()  == null || request.getNumeroTelefono() == null || request.getProvincia() == null )
			throw new DatiNonValidiException(request,"hai inserito dei dati sbagliati");	
	Utente u = utente_repo.findUtenteByIdAndCancellatoFalse(request.getId_utente()).orElseThrow(()->new DatiNonValidiException(request,"Utente non trovato"));
	Indirizzo i = new Indirizzo(request);
	i.setUtente(u);
		indirizzo_service.aggiungiIndirizzo(i);
			return indirizzo_map.toDto(i);
	}

	public void eliminaIndirizzo(IndirizzoRequest request) {
		Indirizzo i =repo.findIndirizzoByNumeroTelefono(request.getNumeroTelefono()).orElseThrow(()->new DatiNonValidiException("Indirizzo non trovato"));
		repo.save(i);
	}
}
