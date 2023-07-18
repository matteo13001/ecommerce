package org.elis.Ecommerce.Service;

import org.elis.Ecommerce.Model.Marca;

import DtoRequest.MarcaRequest;


public interface MarcaService {
		public Marca aggiungiMarca(String nome);
		public void eliminaMarca(Marca m);
}	
