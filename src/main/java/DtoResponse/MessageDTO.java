package DtoResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageDTO {
	private List<String> errori;
	private int codice;
	private LocalDateTime data;
	private Object requestObj;
	
	

	
	public MessageDTO(String errore,int codice, Object requestObj) {
		super();
		this.errori = new ArrayList<>();
		errori.add(errore);
		this.codice = codice;
		this.requestObj = requestObj;
	}
	public MessageDTO(String errore, int codice) {
		super();
		this.errori = new ArrayList<>();
		errori.add(errore);
		this.codice = codice;
	}
	public MessageDTO(List<String> errori, int codice) {
		super();
		this.errori = errori;
		this.codice = codice;
	}
	public MessageDTO(List<String> errori, int codice, LocalDateTime data, Object requestObj) {
		super();
		this.errori = errori;
		this.codice = codice;
		this.data = data;
		this.requestObj = requestObj;
	}
	public List<String> getErrori() {
		return errori;
	}
	public void setErrori(List<String> errori) {
		this.errori = errori;
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Object getRequestObj() {
		return requestObj;
	}
	public void setRequestObj(Object requestObj) {
		this.requestObj = requestObj;
	}
	
	
	
	
}
