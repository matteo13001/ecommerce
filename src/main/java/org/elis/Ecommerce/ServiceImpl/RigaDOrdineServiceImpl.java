package org.elis.Ecommerce.ServiceImpl;


import org.elis.Ecommerce.Model.RigaDOrdine;
import org.elis.Ecommerce.Repository.OrdineRepository;
import org.elis.Ecommerce.Repository.ProdottoRepository;
import org.elis.Ecommerce.Repository.RigaDOrdineRepository;
import org.elis.Ecommerce.Repository.UtenteRepository;
import org.elis.Ecommerce.Service.RigaDOrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RigaDOrdineServiceImpl implements RigaDOrdineService{

	@Autowired
	RigaDOrdineRepository repo;
	@Autowired
	OrdineRepository ordine_repo;
	@Autowired
	ProdottoRepository prodotto_repo;
	@Autowired
	UtenteRepository utente_repo;
	
	@Override
	public RigaDOrdine aggiungiRiga(RigaDOrdine rO) {
			return repo.save(rO);
	}

	@Override
	public void eliminaRiga(RigaDOrdine rO) {
		   rO.setCancellato(true);
			repo.save(rO);
		}
		
}
