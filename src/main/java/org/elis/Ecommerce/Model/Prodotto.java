package org.elis.Ecommerce.Model;

import java.util.List;
import java.util.Objects;


import DtoRequest.ProdottoRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Prodotto{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String descrizione;
	@Column(nullable = false)
	private double prezzo;
	@ManyToOne
	@JoinColumn(name = "id_marca",nullable = false)
	private Marca marca;
	@Column(nullable = false)
	private int quantita;
	@ManyToMany(mappedBy="prodotti")
	@Column(nullable=false)
	private List<SottoCategoria> sottoCategoria;
	@Column(nullable=false)
	private IVA iva;
	@Column(nullable=false)
	private boolean cancellato;
	@ManyToOne
	@JoinColumn(name = "venditore",nullable = false)
	private Utente venditore;
	@OneToMany(mappedBy = "prodotto")
	private List<RigaDOrdine> righe;
	
	
	public Prodotto() {}
	
	
	public Prodotto(String nome, String descrizione, double prezzo, Marca marca, int quantita,
			List<SottoCategoria> sottoCategoria,  Utente venditore) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.marca = marca;
		this.quantita = quantita;
		this.sottoCategoria = sottoCategoria;
		
		this.venditore = venditore;
	}
	
	
	public Prodotto(String nome, String descrizione, double prezzo, Marca marca, int quantita,
			List<SottoCategoria> sottoCategoria, IVA iva, Utente venditore) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.marca = marca;
		this.quantita = quantita;
		this.sottoCategoria = sottoCategoria;
		this.iva = iva;
		this.venditore = venditore;
	}
	
	
	public Prodotto(ProdottoRequest request) {
		this.nome = request.getNome();
		this.descrizione = request.getDescrizione();
		this.prezzo = request.getPrezzo();
		this.quantita = request.getQuantita();
		//this.iva=IVA.fromInt(request.getIva());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public List<SottoCategoria> getSottoCategoria() {
		return sottoCategoria;
	}

	public void setSottoCategoria(List<SottoCategoria> sottoCategoria) {
		this.sottoCategoria = sottoCategoria;
	}

	public IVA getIva() {
		return iva;
	}

	public Utente getVenditore() {
		return venditore;
	}

	public void setVenditore(Utente venditore) {
		this.venditore = venditore;
	}
	

	public boolean isCancellato() {
		return cancellato;
	}

	public void setCancellato(boolean cancellato) {
		this.cancellato = cancellato;
	}

	public List<RigaDOrdine> getRighe() {
		return righe;
	}

	public void setRighe(List<RigaDOrdine> righe) {
		this.righe = righe;
	}

	public void setIva(IVA iva) {
		this.iva = iva;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, venditore);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
		return id == other.id && Objects.equals(nome, other.nome) && Objects.equals(venditore, other.venditore);
	}
	public double getPrezzoIvato() {
		return iva.calcolaPrezzoIvato(prezzo);
	}
}