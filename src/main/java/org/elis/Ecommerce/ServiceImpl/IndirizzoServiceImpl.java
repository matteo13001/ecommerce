package org.elis.Ecommerce.ServiceImpl;
import org.elis.Ecommerce.Model.Indirizzo;
import org.elis.Ecommerce.Repository.IndirizzoRepository;
import org.elis.Ecommerce.Repository.UtenteRepository;
import org.elis.Ecommerce.Service.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


	
@Service
public class IndirizzoServiceImpl implements IndirizzoService{
	@Autowired
	IndirizzoRepository repo;
	@Autowired
	UtenteRepository utente_repo;
	
	@Override
	public Indirizzo aggiungiIndirizzo(Indirizzo i) {
	return repo.save(i);
	}

	@Override
	public void eliminaIndirizzo(Indirizzo i) {
		i.setCancellato(true);
		repo.save(i);
	}

}
