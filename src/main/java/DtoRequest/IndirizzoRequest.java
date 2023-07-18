package DtoRequest;

public class IndirizzoRequest {
	private String indirizzo1;
	private String Indirizzo2;
	private String Provincia;
	private String cap;
	private String numeroTelefono;
	private String comune;
	private String nome;
	private long id_utente;
	
	public String getIndirizzo1() {
		return indirizzo1;
	}
	public void setIndirizzo1(String indirizzo1) {
		this.indirizzo1 = indirizzo1;
	}
	public String getIndirizzo2() {
		return Indirizzo2;
	}
	public void setIndirizzo2(String indirizzo2) {
		Indirizzo2 = indirizzo2;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getId_utente() {
		return id_utente;
	}
	public void setId_utente(long id_utente) {
		this.id_utente = id_utente;
	}
	
	
}
