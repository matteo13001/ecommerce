package org.elis.Ecommerce.Mapper;

import java.util.List;
import org.elis.Ecommerce.Model.Prodotto;
import org.elis.Ecommerce.Model.SottoCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DtoResponse.SottoCategoriaDTO;


@Component
public class SottoCategoriaMapper {
	
	@Autowired
	ProdottoMapper map_prodotto;
	
	public SottoCategoriaDTO toDto2(SottoCategoria sc) {
		if(sc == null) return null;
		SottoCategoriaDTO scDTO = new SottoCategoriaDTO();
		scDTO.setCategoria(sc.getCategoria().getNome()); 
		scDTO.setNome(sc.getNome());
		scDTO.setProdotti(sc.getProdotti().stream()
				.map(Prodotto::getNome).toList());
		return scDTO;
	}
	public SottoCategoriaDTO toDto(SottoCategoria sc) {
		if(sc == null) return null;
		SottoCategoriaDTO scDTO = new SottoCategoriaDTO();
		scDTO.setCategoria(sc.getCategoria().getNome()); 
		scDTO.setNome(sc.getNome());
		return scDTO;
	}
			
	public List<SottoCategoriaDTO> toDTOList(List<SottoCategoria> a){
		if(a==null) return null;
		return a.stream().map(this::toDto).toList();
	}
	
}
