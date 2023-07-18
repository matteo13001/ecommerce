package org.elis.Ecommerce.Facade;

import org.elis.Ecommerce.Exceptions.DatiNonValidiException;
import org.elis.Ecommerce.Mapper.MarcaMapper;
import org.elis.Ecommerce.Model.Marca;
import org.elis.Ecommerce.Repository.MarcaRepository;
import org.elis.Ecommerce.Service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DtoRequest.MarcaRequest;
import DtoResponse.MarcaDTO;

@Service
public class MarcaFacade {

	@Autowired
	MarcaRepository repo;
	@Autowired
	MarcaService m_serv;
	@Autowired
	MarcaMapper m_map;
	

	public MarcaDTO aggiungiMarca(MarcaRequest request) {
		if(request==null)
		throw new DatiNonValidiException("Marca non trovata");
		Marca m = m_serv.aggiungiMarca(request.getNome());
		return m_map.toDto(m);
		
	}

	public void eliminaMarca(MarcaRequest request) {
			Marca m = repo.findMarcaByNomeAndCancellatoFalse(request.getNome()).orElseThrow(()->new DatiNonValidiException("Marca non trovata"));
			m_serv.eliminaMarca(m);
		}
}

