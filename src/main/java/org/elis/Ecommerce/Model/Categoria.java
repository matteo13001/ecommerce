package org.elis.Ecommerce.Model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, unique=true)
	private String nome;
	
	@OneToMany(mappedBy="categoria")
	private List<SottoCategoria> sottocategoria;
	@Column(nullable = false)
	private boolean cancellato;
	
	
	
	public Categoria() {
		super();
	}

	public Categoria(long id, String nome, List<SottoCategoria> sottocategoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.sottocategoria = sottocategoria;
	}
	

	public Categoria(String nome) {
		super();
		this.nome = nome;
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

	public List<SottoCategoria> getSottocategoria() {
		return sottocategoria;
	}

	public void setSottocategoria(List<SottoCategoria> sottocategoria) {
		this.sottocategoria = sottocategoria;
	}
	

	public boolean isCancellato() {
		return cancellato;
	}

	public void setCancellato(boolean cancellato) {
		this.cancellato = cancellato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return id == other.id && Objects.equals(nome, other.nome);
	}
	
	
	
}
