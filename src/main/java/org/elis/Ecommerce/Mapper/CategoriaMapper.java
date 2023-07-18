package org.elis.Ecommerce.Mapper;

import org.elis.Ecommerce.Model.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DtoResponse.CategoriaDTO;

@Component
public class CategoriaMapper {
	@Autowired 
	SottoCategoriaMapper sc_map;
	public CategoriaDTO toDto(Categoria categoria) {
		if(categoria==null) return null;
		CategoriaDTO c = new CategoriaDTO();
		c.setNome(categoria.getNome());
		c.setStcgDTO(sc_map.toDTOList(categoria.getSottocategoria()));
		return c;
	}
}
