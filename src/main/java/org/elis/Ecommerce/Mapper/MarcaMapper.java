package org.elis.Ecommerce.Mapper;

import org.elis.Ecommerce.Model.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DtoResponse.MarcaDTO;

@Component
public class MarcaMapper {
	@Autowired
	ProdottoMapper prod_map;

	public MarcaDTO toDto(Marca marca) {
		if(marca == null) return null;
		MarcaDTO m = new MarcaDTO();
		m.setNome(marca.getNome());
		m.setProdotti(prod_map.toDTOList(marca.getProdotti()));
		return m;
	}
}
