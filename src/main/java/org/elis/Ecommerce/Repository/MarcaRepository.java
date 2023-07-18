package org.elis.Ecommerce.Repository;

import java.util.Optional;

import org.elis.Ecommerce.Model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca,Long>{
	public Optional<Marca> findMarcaByNomeAndCancellatoFalse(String name);
}
