package org.elis.Ecommerce.Service;

import org.elis.Ecommerce.Model.Ordine;

public interface OrdineService {
	public Ordine aggiungiOrdine(Ordine ordine);
	public void rimuoviOrdine(Ordine ordine);
}
