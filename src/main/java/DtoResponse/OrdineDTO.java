package DtoResponse;

import java.time.LocalDateTime;

public class OrdineDTO {
	private String cliente;
	private LocalDateTime dataInvio;
	private double prezzo_tot;
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public LocalDateTime getDataInvio() {
		return dataInvio;
	}
	public void setDataInvio(LocalDateTime dataInvio) {
		this.dataInvio = dataInvio;
	}
	public double getPrezzo_tot() {
		return prezzo_tot;
	}
	public void setPrezzo_tot(double prezzo_tot) {
		this.prezzo_tot = prezzo_tot;
	}
	
	
}
