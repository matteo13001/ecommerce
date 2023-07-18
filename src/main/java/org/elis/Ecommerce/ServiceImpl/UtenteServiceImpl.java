package org.elis.Ecommerce.ServiceImpl;


import java.util.List;
import java.util.Optional;

import org.elis.Ecommerce.Exceptions.DatiNonValidiException;
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
public class UtenteServiceImpl implements UtenteService{
	
	@Autowired
	UtenteRepository repo ;
	
	@Override
	public Utente aggiungiCliente(String username,String nome,String cognome,String email,String password)  {
		
		Utente u=new Utente(username, nome,  cognome, email,  password);
		return u;
	}
	
	
	@Override
	public Utente aggiungiUtente(Utente u) {
		Utente ut = aggiungiCliente(u.getUsername(),u.getNome(),u.getCognome(),u.getEmail(),u.getPassword()); 
		ut.setRuolo(Ruolo.UTENTE);
		repo.save(ut);
		return ut;
	}

	@Override
	public Utente aggiungiAdmin(Utente u) {
		Utente ut = aggiungiCliente( u.getUsername(),u.getNome(),u.getCognome(),u.getEmail(),u.getPassword()); 
		ut.setRuolo(Ruolo.ADMIN);
		repo.save(ut);
		return ut;
	}

	@Override
	public Utente aggiungiVenditore(Utente u) {
		Utente ut = aggiungiCliente( u.getUsername(),u.getNome(),u.getCognome(),u.getEmail(),u.getPassword()); 
			ut.setRuolo(Ruolo.VENDITORE);
			repo.save(ut);
		return ut;
		
	}
	@Override
	public Utente login(LoginRequest request) {
		Optional<Utente> opt = repo.findUtenteByUsernameAndPasswordAndCancellatoFalse(request.getUsername(),request.getPassword());
		if(opt.isEmpty())
		throw new DatiNonValidiException(request,"username o password sbagliati");
		return opt.get();
	}

	@Override
	public Utente findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findByRuolo(Ruolo r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente findByUserPassword(String user, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Utente u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean findByUser() {
		// TODO Auto-generated method stub
		return false;
	}


}
