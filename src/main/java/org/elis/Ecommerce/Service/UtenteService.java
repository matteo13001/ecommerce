package org.elis.Ecommerce.Service;

import java.util.List;
import org.elis.Ecommerce.Model.Ruolo;
import org.elis.Ecommerce.Model.Utente;
import DtoRequest.LoginRequest;
import DtoRequest.RegistrazioneRequest;
import DtoResponse.UtenteDTO;

public interface UtenteService {

	public Utente  aggiungiUtente(Utente u);
	public Utente  aggiungiAdmin(Utente u);
	public Utente aggiungiVenditore(Utente u);
	public Utente aggiungiCliente(String username, String nome, String cognome, String email, String password);
	public Utente findById(int id);
	public List<Utente> findByRuolo(Ruolo r);
	public boolean findByUser();
	public Utente login(LoginRequest request);
	public Utente findByUserPassword(String user,String password);
	public List<Utente> findAll();
	public boolean delete(Utente u);
	public void deleteById(long id );
}
