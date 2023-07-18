package org.elis.Ecommerce.Mapper;

import java.util.List;

import org.elis.Ecommerce.Model.Prodotto;
import org.elis.Ecommerce.Model.SottoCategoria;
import org.springframework.stereotype.Component;

import DtoResponse.ProdottoDTO;

@Component
public class ProdottoMapper {
	public ProdottoDTO toDto(Prodotto prodotto) {
		if(prodotto==null)return null;
		ProdottoDTO p=new ProdottoDTO();
		p.setId(prodotto.getId());
		p.setDescrizione(prodotto.getDescrizione());
		p.setIva(prodotto.getIva());
		p.setMarca(prodotto.getMarca().getNome());
		p.setNome(prodotto.getNome());
		p.setPrezzo(prodotto.getPrezzo());
		p.setVenditore(prodotto.getVenditore().getNome());
		p.setSottoCategoria(prodotto.getSottoCategoria().stream()
				.map(SottoCategoria::getNome).toList());
		return p;
	}
	public List<ProdottoDTO> toDTOList(List<Prodotto> a){
		if(a==null) return null;
		return a.stream().map(this::toDto).toList();
	}
}
