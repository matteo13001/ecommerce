package DtoRequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class RigaDOrdineRequest {
	@NotBlank(message = "il prodotto deve esistere")
	private String prodotto;
	@Min(value= 1)
	private int quantita;
	@NotBlank(message = "l'ordine deve esistere")
	private String ordine;
	@Positive(message = "l'username deve esistere")
	private long id_cliente;
	public String getProdotto() {
		return prodotto;
	}
	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public String getOrdine() {
		return ordine;
	}
	public void setOrdine(String ordine) {
		this.ordine = ordine;
	}
	public long getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	
	
}
