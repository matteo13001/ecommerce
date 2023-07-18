package org.elis.Ecommerce.Repository;

import java.util.Optional;

import org.elis.Ecommerce.Model.RigaDOrdine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RigaDOrdineRepository extends JpaRepository<RigaDOrdine,Long>{
	public Optional<RigaDOrdine> findRigaDordineByProdotto_IdAndOrdine_idAndCancellatoFalse(long id_prodotto,long id_ordine);
}
