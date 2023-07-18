package org.elis.Ecommerce.ServiceImpl;


import org.elis.Ecommerce.Exceptions.DatiNonValidiException;
import org.elis.Ecommerce.Model.Categoria;
import org.elis.Ecommerce.Model.SottoCategoria;
import org.elis.Ecommerce.Repository.CategoriaRepository;
import org.elis.Ecommerce.Repository.SottoCategoriaRepository;
import org.elis.Ecommerce.Service.SottoCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DtoRequest.SottoCategoriaRequest;

@Service
public class SottoCategoriaServiceImpl implements SottoCategoriaService{

	@Autowired
	CategoriaRepository repoCat;
	@Autowired
	SottoCategoriaRepository repo;
	
	@Override
	public SottoCategoria aggiungiSC(String nome, Categoria c) {
		SottoCategoria sc = new SottoCategoria(nome,c);
		 repo.save(sc);
		 return sc;
		}

	@Override
	public void deleteByNome(String nome) {
			SottoCategoria sc = repo.findSottoCategoriaByNome(nome).orElseThrow(()->new DatiNonValidiException("SottoCateogoria non trovata"));;
				sc.setCancellato(true);
		}
		
	}

