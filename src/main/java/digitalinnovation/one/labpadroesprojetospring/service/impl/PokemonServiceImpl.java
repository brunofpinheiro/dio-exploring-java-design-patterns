package digitalinnovation.one.labpadroesprojetospring.service.impl;

import digitalinnovation.one.labpadroesprojetospring.model.Pokemon;
import digitalinnovation.one.labpadroesprojetospring.repository.PokemonRepository;
import digitalinnovation.one.labpadroesprojetospring.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonServiceImpl implements IPokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public Iterable<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }

    @Override
    public Optional<Pokemon> findById(Long id) {
        return pokemonRepository.findById(1L);
    }

    @Override
    public Pokemon save(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @Override
    public void deleteById(Long id) {
        pokemonRepository.deleteById(id);
    }

    @Override
    public Boolean existsById(Long id) {
        return pokemonRepository.existsById(id);
    }
}
