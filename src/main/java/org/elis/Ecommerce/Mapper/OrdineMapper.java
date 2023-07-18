package org.elis.Ecommerce.Mapper;

import java.util.List;

import org.elis.Ecommerce.Model.Ordine;
import org.springframework.stereotype.Component;

import DtoResponse.OrdineDTO;

@Component
public class OrdineMapper {
	
	public OrdineDTO toDto(Ordine ordine) {
		if(ordine==null) return null;
		OrdineDTO c = new OrdineDTO();
		c.setCliente(ordine.getCliente().getNome());
		c.setDataInvio(ordine.getDataInvioOrdine());
		c.setPrezzo_tot(ordine.getPrezzo_tot());
		return c;
	}
	public List<OrdineDTO> toDTOList(List<Ordine> ordini){
		List<OrdineDTO> u = ordini.stream().map(this::toDto).toList();
		return u;
	}
}
