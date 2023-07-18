package org.elis.Ecommerce.Repository;

import java.util.Optional;

import org.elis.Ecommerce.Model.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long>{
	Optional<Indirizzo> findIndirizzoByNumeroTelefono(String NTelefono);
}
