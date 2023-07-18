package org.elis.Ecommerce.Facade;


import org.elis.Ecommerce.Exceptions.DatiNonValidiException;
import org.elis.Ecommerce.Mapper.SottoCategoriaMapper;
import org.elis.Ecommerce.Model.Categoria;
import org.elis.Ecommerce.Model.SottoCategoria;
import org.elis.Ecommerce.Repository.CategoriaRepository;
import org.elis.Ecommerce.Repository.SottoCategoriaRepository;
import org.elis.Ecommerce.Service.SottoCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DtoRequest.SottoCategoriaRequest;
import DtoResponse.SottoCategoriaDTO;

@Service
public class SottoCategoriaFacade {
	@Autowired
	CategoriaRepository repoCat;
	@Autowired
	SottoCategoriaRepository repo;
	@Autowired
	SottoCategoriaService sC_service;
	@Autowired
	SottoCategoriaMapper sC_map;
	
	

	public SottoCategoriaDTO aggiungiSC(SottoCategoriaRequest request) {
		Categoria c= repoCat.findById(request.getId_categoria()).orElseThrow(()->new DatiNonValidiException("Categoria non trovata"));
		if(request.getNome() == null)
			throw new DatiNonValidiException("SottoCategoria non trovata");
		SottoCategoria sc = sC_service.aggiungiSC(request.getNome(),c);
		 return sC_map.toDto(sc);
		}
	public void deleteByNome(SottoCategoriaRequest request) {
		if(!repo.findSottoCategoriaByNome(request.getNome()).isEmpty()) {
			sC_service.deleteByNome(request.getNome());
				
		}
		
	}

}
