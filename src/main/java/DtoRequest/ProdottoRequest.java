package DtoRequest;

import java.util.List;

import org.elis.Ecommerce.Model.IVA;

public class ProdottoRequest {
	private String nome;
	private String descrizione;
	private String marca;
	private double prezzo;
	private int quantita;
	private List<Long>id_sottoCategoria;
	private String user_venditore;
	private int iva;
	
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
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public List<Long> getId_sottoCategoria() {
		return id_sottoCategoria;
	}
	public void setId_sottoCategoria(List<Long> id_sottoCategoria) {
		this.id_sottoCategoria = id_sottoCategoria;
	}
	public String getUser_venditore() {
		return user_venditore;
	}
	public void setUser_venditore(String user_venditore) {
		this.user_venditore = user_venditore;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	
	
}
