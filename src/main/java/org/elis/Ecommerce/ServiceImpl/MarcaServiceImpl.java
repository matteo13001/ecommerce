package org.elis.Ecommerce.ServiceImpl;



import org.elis.Ecommerce.Model.Marca;
import org.elis.Ecommerce.Repository.MarcaRepository;
import org.elis.Ecommerce.Service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl implements MarcaService{

	@Autowired
	MarcaRepository repo;
	
	@Override
	public Marca aggiungiMarca(String nome) {
		Marca m = new Marca(nome);
		return repo.save(m);
		
	}

	@Override
	public void eliminaMarca(Marca m) {
			m.setCancellato(true);
			repo.save(m);
		}
}
