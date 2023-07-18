package org.elis.Ecommerce.Service;

import org.elis.Ecommerce.Model.Indirizzo;

import DtoRequest.IndirizzoRequest;

public interface IndirizzoService {
	public Indirizzo aggiungiIndirizzo(Indirizzo i );
	public void eliminaIndirizzo(Indirizzo i);
}
