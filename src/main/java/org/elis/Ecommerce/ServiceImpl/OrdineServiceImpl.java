package org.elis.Ecommerce.ServiceImpl;

import org.elis.Ecommerce.Model.Ordine;
import org.elis.Ecommerce.Repository.OrdineRepository;
import org.elis.Ecommerce.Repository.ProdottoRepository;
import org.elis.Ecommerce.Repository.RigaDOrdineRepository;
import org.elis.Ecommerce.Repository.UtenteRepository;
import org.elis.Ecommerce.Service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdineServiceImpl implements OrdineService{
	
	@Autowired
	OrdineRepository repo;
	
	@Override
	public Ordine aggiungiOrdine(Ordine ordine) {
			return repo.save(ordine);
	}

	@Override
	public void rimuoviOrdine(Ordine ordine) {
		ordine.setCancellato(true);
		repo.save(ordine);
	}
}		
