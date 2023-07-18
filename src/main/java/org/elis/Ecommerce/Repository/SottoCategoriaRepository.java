package org.elis.Ecommerce.Repository;



import java.util.Optional;

import org.elis.Ecommerce.Model.SottoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SottoCategoriaRepository extends JpaRepository<SottoCategoria, Long>{
	Optional<SottoCategoria> findSottoCategoriaByNome(String nome); 
}
