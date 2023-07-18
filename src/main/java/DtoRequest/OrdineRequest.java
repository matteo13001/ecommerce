package DtoRequest;

import java.util.List;

public class OrdineRequest {
	private Long id_Ordine;
	private List<Long> id_righe;
	private String username;

	
	
	public Long getId_Ordine() {
		return id_Ordine;
	}

	public void setId_Ordine(Long id_Ordine) {
		this.id_Ordine = id_Ordine;
	}

	public List<Long> getId_righe() {
		return id_righe;
	}

	public void setId_righe(List<Long> id_righe) {
		this.id_righe = id_righe;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
		
}
