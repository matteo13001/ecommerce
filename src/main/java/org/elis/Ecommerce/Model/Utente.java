 package org.elis.Ecommerce.Model;

import java.util.Collection;
import java.util.List;
import java.util.Objects;


import DtoRequest.RegistrazioneRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

@Entity
public class Utente {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column(nullable = false,unique = true)
		private String username;
		@Column(nullable = false,updatable = false,unique = true)
		private String nome;
		@Column(nullable = false)
		private String cognome;
		@Column(nullable = false)
		private String email;
		@Column(nullable = false)
		private String password;
		
		@Column(nullable = false)
		@OneToMany(mappedBy = "utente")
		private List<Indirizzo> indirizzi;
		@Column
		private boolean cancellato;
		@OneToMany(mappedBy = "cliente")
		private List<Ordine> ordini;
		@Column 
		private Ruolo ruolo;
		public Utente() {

		}
		public Utente(String username, String nome, String cognome, String email, String password,
				List<Indirizzo> indirizzi, List<Ordine> ordini, Ruolo ruolo) {
			this.username = username;
			this.nome = nome;
			this.cognome = cognome;
			this.email = email;
			this.password = password;
			this.indirizzi = indirizzi;
			this.ordini = ordini;
			this.ruolo = ruolo;
		}
		
		
		public Utente(String username, String nome, String cognome, String email, String password,Ruolo ruolo) {
			super();
			this.username = username;
			this.nome = nome;
			this.cognome = cognome;
			this.email = email;
			this.password = password;
			this.ruolo= ruolo;
		}
		public Utente(String username, String nome, String cognome, String email, String password) {
			super();
			this.username = username;
			this.nome = nome;
			this.cognome = cognome;
			this.email = email;
			this.password = password;
		}
		public Utente(RegistrazioneRequest request) {
			this.username=request.getUsername();
			this.nome = request.getNome();
			this.cognome = request.getCognome();
			this.email = request.getEmail();
			this.password = request.getPassword();
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getUser() {
			return username;
		}
		public void setUser(String user) {
			this.username = user;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCognome() {
			return cognome;
		}
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public List<Indirizzo> getIndirizzi() {
			return indirizzi;
		}
		public void setIndirizzi(List<Indirizzo> indirizzi) {
			this.indirizzi = indirizzi;
		}
		public List<Ordine> getOrdini() {
			return ordini;
		}
		public void setOrdini(List<Ordine> ordini) {
			this.ordini = ordini;
		}
		public Ruolo getRuolo() {
			return ruolo;
		}
		public void setRuolo(Ruolo ruolo) {
			this.ruolo = ruolo;
		}
		@Override
		public int hashCode() {
			return Objects.hash(id, username);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Utente other = (Utente) obj;
			return id == other.id && Objects.equals(username, other.username);
		} 
}