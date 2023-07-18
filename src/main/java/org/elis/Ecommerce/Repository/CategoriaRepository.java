package org.elis.Ecommerce.Repository;

import java.util.Optional;

import org.elis.Ecommerce.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	public Optional<Categoria> findCategoriaByNome(String nome);

}
