package org.elis.Ecommerce.Repository;

import java.util.Optional;

import org.elis.Ecommerce.Model.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineRepository extends JpaRepository<Ordine,Long>{
	public Optional<Ordine> findOrdineByDataInvioOrdineNullAndCliente_IdAndCancellatoFalse(Long id);
	public Optional<Ordine> findByIdAndCancellatoFalse(long id);
}
