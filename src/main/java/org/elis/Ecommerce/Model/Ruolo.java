package org.elis.Ecommerce.Model;

public enum Ruolo {
	UTENTE("utente") ,
	VENDITORE ("venditore"),
	ADMIN ("admin"),;
	
private String ruolo;
	
	Ruolo(String r) {
		ruolo=r;
	}

	public String getRuolo() {
		return ruolo;
	}
}
