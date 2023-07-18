package DtoResponse;

import java.util.List;

public class MarcaDTO {
	private String nome;
	private List<ProdottoDTO> prodotti;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<ProdottoDTO> getProdotti() {
		return prodotti;
	}
	public void setProdotti(List<ProdottoDTO> prodotti) {
		this.prodotti = prodotti;
	}
	
	
}
