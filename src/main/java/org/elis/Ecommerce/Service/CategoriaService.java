package org.elis.Ecommerce.Service;

import org.elis.Ecommerce.Model.Categoria;


public interface CategoriaService {
	
	public Categoria aggiungiCategoria(String nome);
	public void deleteCategoria(Categoria cat);
}
