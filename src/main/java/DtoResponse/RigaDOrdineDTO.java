package DtoResponse;

public class RigaDOrdineDTO {
	private String prodotto;
	private int quantita;
	private OrdineDTO ordine;
	
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
	public OrdineDTO getOrdine() {
		return ordine;
	}
	public void setOrdine(OrdineDTO ordine) {
		this.ordine = ordine;
	}
}
