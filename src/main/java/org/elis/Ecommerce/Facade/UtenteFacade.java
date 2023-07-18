package org.elis.Ecommerce.Facade;

import java.util.List;
import java.util.Optional;

import org.elis.Ecommerce.Exceptions.DatiNonValidiException;
import org.elis.Ecommerce.Mapper.UtenteMapper;
import org.elis.Ecommerce.Model.Ruolo;
import org.elis.Ecommerce.Model.Utente;
import org.elis.Ecommerce.Repository.UtenteRepository;
import org.elis.Ecommerce.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DtoRequest.LoginRequest;
import DtoRequest.RegistrazioneRequest;
import DtoResponse.UtenteDTO;

@Service
public class UtenteFacade {
	@Autowired
	UtenteService ut_serv;
	@Autowired
	UtenteRepository repo;
	@Autowired
	UtenteMapper ut_map;
	
	public Utente aggiungiCliente(RegistrazioneRequest request)  {
		if(!request.getPassword().equals(request.getPasswordRipetuta()))
			throw new DatiNonValidiException(request, "le password devono coincidere");
		Utente u=ut_serv.aggiungiCliente(request.getUsername(),request.getNome(), request.getCognome(),request.getEmail(), request.getPassword());
		return u;
	}
	

	public UtenteDTO aggiungiUtente(RegistrazioneRequest request) {
		Utente u = aggiungiCliente(request); 
		ut_serv.aggiungiUtente(u);
		return ut_map.toDto(u);
	}

	public UtenteDTO aggiungiAdmin(RegistrazioneRequest request) {
		Utente u = aggiungiCliente(request); 
		ut_serv.aggiungiAdmin(u);
		return ut_map.toDto(u);
	}

	public UtenteDTO aggiungiVenditore(RegistrazioneRequest request) {
		Utente u = aggiungiCliente(request); 
			ut_serv.aggiungiVenditore(u);
		return ut_map.toDto(u);
		
	}
	
	public UtenteDTO loginUtente(LoginRequest request) {
		Optional<Utente> ut = repo.findUtenteByUsernameAndPasswordAndCancellatoFalse(request.getUsername(),request.getPassword());
		if(ut.isEmpty())
		throw new DatiNonValidiException(request,"username o password sbagliati");
		return ut_map.toDto(ut.get());
	}

	public UtenteDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UtenteDTO> findByRuolo(Ruolo r) {
		// TODO Auto-generated method stub
		return null;
	}

	public UtenteDTO findByUserPassword(String user, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<UtenteDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(UtenteDTO u) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}


	public boolean findByUser() {
		// TODO Auto-generated method stub
		return false;
	}


}
