package org.elis.Ecommerce.Service;

import org.elis.Ecommerce.Model.RigaDOrdine;

import DtoRequest.RigaDOrdineRequest;

public interface RigaDOrdineService {
	public RigaDOrdine aggiungiRiga(RigaDOrdine rO);
	public void eliminaRiga(RigaDOrdine rO);
}
