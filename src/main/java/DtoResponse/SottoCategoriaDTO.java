package DtoResponse;

import java.util.List;

public class SottoCategoriaDTO {
	String nome;
	List<String> prodotti;
	String categoria;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<String> getProdotti() {
		return prodotti;
	}
	public void setProdotti(List<String> prodotti) {
		this.prodotti = prodotti;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
