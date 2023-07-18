package org.elis.Ecommerce.Mapper;

import java.util.List;

import org.elis.Ecommerce.Model.RigaDOrdine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DtoResponse.RigaDOrdineDTO;

@Component
public class RigaDOrdineMapper {
	@Autowired
	OrdineMapper ord_map;
	
	public RigaDOrdineDTO toDto(RigaDOrdine rd) {
		if(rd == null) return null;
		RigaDOrdineDTO rdDTO = new RigaDOrdineDTO();
		rdDTO.setOrdine(ord_map.toDto(rd.getOrdine()));
		rdDTO.setProdotto(rd.getProdotto().getDescrizione());
		rdDTO.setQuantita(rd.getQuantita());
		return rdDTO;
	}
			
	public List<RigaDOrdineDTO> toDTOList(List<RigaDOrdine> a){
		if(a==null) return null;
		return a.stream().map(this::toDto).toList();
	}
}
