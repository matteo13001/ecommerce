package org.elis.Ecommerce.Mapper;

import org.elis.Ecommerce.Model.Indirizzo;
import org.springframework.stereotype.Component;

import DtoResponse.IndirizzoDTO;

@Component
public class IndirizzoMapper {
	public IndirizzoDTO toDto(Indirizzo indirizzo) {
		if(indirizzo == null) return null;
	IndirizzoDTO i=new IndirizzoDTO();
	i.setCap(indirizzo.getCap());
	i.setComune(indirizzo.getComune());
	i.setIndirizzo1(indirizzo.getIndirizzo1());
	i.setIndirizzo2(indirizzo.getIndirizzo2());
	i.setNome(indirizzo.getNome());
	i.setNumeroTelefono(indirizzo.getNumeroTelefono());
	i.setProvincia(indirizzo.getProvincia());
	i.setUtente(indirizzo.getUtente().getUsername());
	return i;
	}
	
}
