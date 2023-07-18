package org.elis.Ecommerce.Mapper;

import java.util.List;

import org.elis.Ecommerce.Model.Utente;
import org.springframework.stereotype.Component;

import DtoResponse.UtenteDTO;
@Component
public class UtenteMapper {
	
	public UtenteDTO toDto(Utente utente) {
		if(utente == null) return null;
		UtenteDTO u= new UtenteDTO();
		u.setCognome(utente.getCognome());
		u.setEmail(utente.getEmail());
		u.setIndirizzo(utente.getIndirizzi().toString());
		u.setNome(utente.getNome());
		u.setUsername(utente.getUsername());
		return u;
	}
	public List<UtenteDTO> toDTOList(List<Utente> utenti){
		List<UtenteDTO> u = utenti.stream().map(this::toDto).toList();
		return u;
	}
}
