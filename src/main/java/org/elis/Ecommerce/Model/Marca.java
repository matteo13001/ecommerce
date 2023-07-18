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
public class Marca {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;
 @Column(nullable = false, unique=true)
 private String nome;
 @OneToMany (mappedBy="marca")
 List<Prodotto> prodotti;
 @Column(nullable = false)
 private boolean cancellato;
 
 
 public boolean isCancellato() {
	return cancellato;
}
public void setCancellato(boolean cancellato) {
	this.cancellato = cancellato;
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
 public List<Prodotto> getProdotti() {
  return prodotti;
 }
 public void setProdotti(List<Prodotto> prodotti) {
  this.prodotti = prodotti;
 }
 public Marca(String nome, List<Prodotto> prodotti) {
  super();
  this.nome = nome;
  this.prodotti = prodotti;
 }
 public Marca() {
  super();
 }
 
 public Marca(String nome) {
	super();
	this.nome = nome;
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
  Marca other = (Marca) obj;
  return id == other.id && Objects.equals(nome, other.nome);
 }
 
 
 
 
 
 
}
