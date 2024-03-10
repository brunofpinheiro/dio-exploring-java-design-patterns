package digitalinnovation.one.labpadroesprojetospring.service;

import digitalinnovation.one.labpadroesprojetospring.model.Pokemon;

import java.util.Optional;

public interface IPokemonService {
    Iterable<Pokemon> findAll();

    Optional<Pokemon> findById(Long id);

    Pokemon save(Pokemon pokemon);

    void deleteById(Long id);

    Boolean existsById(Long id);
}
