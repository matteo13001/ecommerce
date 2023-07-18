package org.elis.Ecommerce.Repository;

import java.util.Optional;

import org.elis.Ecommerce.Model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente,Long>{
	public Optional<Utente> findUtenteByUsernameAndPasswordAndCancellatoFalse(String username,String password);
	public Optional<Utente> findUtenteByIdAndCancellatoFalse(long id);
	public Optional<Utente> findUtenteByUsernameAndCancellatoFalse(String username);
	
}