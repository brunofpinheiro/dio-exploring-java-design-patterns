package digitalinnovation.one.labpadroesprojetospring.repository;

import digitalinnovation.one.labpadroesprojetospring.model.Pokemon;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
}
