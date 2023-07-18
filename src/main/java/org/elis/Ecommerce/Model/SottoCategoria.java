package org.elis.Ecommerce.Model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class SottoCategoria {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@Column(nullable = false,unique=true)
		private String nome;
		
		@ManyToMany
		@JoinTable(name = "prodotti_della_sottoCategoria", 
		joinColumns= @JoinColumn(name = "id_SottoCategoria"),
		inverseJoinColumns  = @JoinColumn(name= "id_prodotto"))
		private List<Prodotto> prodotti;
		
		@ManyToOne
		@JoinColumn(name = "id_categoria",nullable=false)
		private Categoria categoria;
		@Column(nullable=false)
		private boolean cancellato;
		

		public SottoCategoria() {}
		
		
		public SottoCategoria(String nome, Categoria categoria) {
			super();
			this.nome = nome;
			this.categoria = categoria;
		}


		public SottoCategoria(String nome, Categoria categoria, List<Prodotto> prodotti) {
			super();
			this.nome = nome;
			this.categoria = categoria;
			this.prodotti = prodotti;
		}

		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Categoria getCategoria() {
			return categoria;
		}
		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
		public List<Prodotto> getProdotti() {
			return prodotti;
		}
		public void setProdotti(List<Prodotto> prodotti) {
			this.prodotti = prodotti;
		}

		@Override
		public int hashCode() {
			return Objects.hash(categoria, nome);
		}
		

		public boolean isCancellato() {
			return cancellato;
		}


		public void setCancellato(boolean cancellato) {
			this.cancellato = cancellato;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SottoCategoria other = (SottoCategoria) obj;
			return Objects.equals(categoria, other.categoria) && Objects.equals(nome, other.nome);
		}
	}
