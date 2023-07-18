package org.elis.Ecommerce.Model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RigaDOrdine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name="id_prodotto",nullable = false)
	private Prodotto prodotto;
	@Column
	private int quantita;
	@ManyToOne
	@JoinColumn( name="id_ordine", nullable = false)
	private Ordine ordine;
	@Column(nullable=false)
	private boolean cancellato;
	public RigaDOrdine() {}
	
	
	public RigaDOrdine(Prodotto prodotto, int quantita, Ordine ordine) {
		super();
		this.prodotto = prodotto;
		this.quantita = quantita;
		this.ordine = ordine;
	}


	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public Prodotto getProdotto() {
		return prodotto;
	}
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public Ordine getOrdine() {
		return ordine;
	}
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	


	public boolean isCancellato() {
		return cancellato;
	}


	public void setCancellato(boolean cancellato) {
		this.cancellato = cancellato;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, ordine);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RigaDOrdine other = (RigaDOrdine) obj;
		return id == other.id && Objects.equals(ordine, other.ordine);
	}
	
	
}
