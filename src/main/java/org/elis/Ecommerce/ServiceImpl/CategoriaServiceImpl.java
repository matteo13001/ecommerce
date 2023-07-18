package org.elis.Ecommerce.ServiceImpl;


import org.elis.Ecommerce.Model.Categoria;
import org.elis.Ecommerce.Repository.CategoriaRepository;
import org.elis.Ecommerce.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	CategoriaRepository repo;
	
	@Override
	public Categoria aggiungiCategoria(String nome) {
			Categoria cat = new Categoria(nome);
			 return repo.save(cat);
	}

	@Override
	public void deleteCategoria(Categoria cat) {
			cat.setCancellato(true);
			repo.save(cat);
		}
	}
