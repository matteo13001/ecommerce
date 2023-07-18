package org.elis.Ecommerce.Facade;

import org.elis.Ecommerce.Exceptions.DatiNonValidiException;
import org.elis.Ecommerce.Mapper.CategoriaMapper;
import org.elis.Ecommerce.Model.Categoria;
import org.elis.Ecommerce.Repository.CategoriaRepository;
import org.elis.Ecommerce.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import DtoRequest.CategoriaRequest;
import DtoResponse.CategoriaDTO;

@Service
public class CategoriaFacade {

	@Autowired
	CategoriaRepository repo;
	@Autowired
	CategoriaService c_serv;
	@Autowired
	CategoriaMapper c_map;
	
	
	public CategoriaDTO aggiungiCategoria(CategoriaRequest request) {
		if(request.getNome()==null)
			throw new DatiNonValidiException(request,"categoria non inserita");
			Categoria cat = c_serv.aggiungiCategoria(request.getNome());
			 return c_map.toDto(cat);
	}


	public void deleteCategoria(CategoriaRequest request) {
			Categoria cat= repo.findCategoriaByNome(request.getNome()).orElseThrow(()->new DatiNonValidiException("Categoria non trovata"));
			c_serv.deleteCategoria(cat);
		}
}
