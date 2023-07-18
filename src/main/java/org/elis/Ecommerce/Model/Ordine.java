package org.elis.Ecommerce.Model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

	 
	
	@Entity
	public class Ordine{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@ManyToOne
		@JoinColumn(name = "cliente",nullable = false)
		private Utente cliente;
		@OneToMany(mappedBy = "ordine")
		private List<RigaDOrdine> righe;
		@Column()
		private LocalDateTime dataInvioOrdine;
		@Column
		private boolean cancellato;
		@Column
		private double prezzo_tot;
		

		public Ordine(Utente cliente) {}
		
		public Ordine() {
			super();
			this.prezzo_tot = 0;
		}

		public Ordine(Utente cliente, List<RigaDOrdine> righe) {
			super();
			this.cliente = cliente;
			this.righe = righe;
		}

		public Ordine(List<RigaDOrdine> righe, Utente cliente, LocalDateTime dataInvioOrdine) {
			super();
			this.righe=righe;
			this.cliente = cliente;
			this.dataInvioOrdine = dataInvioOrdine;
		}
		
		

		public double getPrezzo_tot() {
			return prezzo_tot;
		}

		public void setPrezzo_tot(double prezzo_tot) {
			this.prezzo_tot = prezzo_tot;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Utente getCliente() {
			return cliente;
		}

		public void setCliente(Utente cliente) {
			this.cliente = cliente;
		}

		public LocalDateTime getDataInvioOrdine() {
			return dataInvioOrdine;
		}

		public void setDataInvioOrdine(LocalDateTime dataInvioOrdine) {
			this.dataInvioOrdine = dataInvioOrdine;
		}
		

		public List<RigaDOrdine> getRighe() {
			return righe;
		}

		public void setRighe(List<RigaDOrdine> righe) {
			this.righe = righe;
		}

		public boolean isCancellato() {
			return cancellato;
		}

		public void setCancellato(boolean cancellato) {
			this.cancellato = cancellato;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Ordine other = (Ordine) obj;
			return id == other.id;
		}
		
		
	}
