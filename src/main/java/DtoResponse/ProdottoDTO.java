package DtoResponse;

import java.util.List;

import org.elis.Ecommerce.Model.IVA;

public class ProdottoDTO {
	private long id;
	private String nome;
	private String marca;
	private String descrizione;
	private double prezzo;
	private IVA iva;
	private String venditore;
	private int quantita;
	private List<String> sottoCategoria;
	
	

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

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
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

		public IVA getIva() {
			return iva;
		}

		public void setIva(IVA iva) {
			this.iva = iva;
		}

		public String getVenditore() {
			return venditore;
		}

		public void setVenditore(String venditore) {
			this.venditore = venditore;
		}

		public int getQuantita() {
			return quantita;
		}

		public void setQuantita(int quantita) {
			this.quantita = quantita;
		}

		public List<String> getSottoCategoria() {
			return sottoCategoria;
		}

		public void setSottoCategoria(List<String> sottoCategoria) {
			this.sottoCategoria = sottoCategoria;
		}
		
		
}
