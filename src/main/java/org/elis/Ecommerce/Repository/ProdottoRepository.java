package org.elis.Ecommerce.Repository;

import java.util.List;
import java.util.Optional;

import org.elis.Ecommerce.Model.Marca;
import org.elis.Ecommerce.Model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long>{
	public Optional<Prodotto> findProdottoByDescrizioneAndCancellatoFalse(String descrizione);
	public List<Prodotto> findAllByMarcaAndCancellatoFalse(Marca marca);
	public Optional<Prodotto> findProdottoByNomeAndVenditore_UsernameAndCancellatoFalse(String nome,String venditore);
	public Optional<Prodotto> findByIdAndCancellatoFalse(long id);
	@Query("select p from Prodotto p where cancellato=false")
	public List<Prodotto> findAll();
	public Optional<Prodotto> findByNome(String nome);
}
