package org.elis.Ecommerce.Service;

import org.elis.Ecommerce.Model.Categoria;
import org.elis.Ecommerce.Model.SottoCategoria;

import DtoRequest.SottoCategoriaRequest;

public interface SottoCategoriaService {
	SottoCategoria aggiungiSC(String nome, Categoria c);
	void deleteByNome(String nome);
}
