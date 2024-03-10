package digitalinnovation.one.labpadroesprojetospring.controller;

import digitalinnovation.one.labpadroesprojetospring.model.Pokemon;
import digitalinnovation.one.labpadroesprojetospring.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("pokemon")
public class PokemonController {
    @Autowired
    private IPokemonService pokemonService;

    @GetMapping
    public ResponseEntity<Iterable<Pokemon>> findAll() {
        Iterable<Pokemon> allPokemon = pokemonService.findAll();

        if (!allPokemon.iterator().hasNext())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(allPokemon);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pokemon>> findById(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonService.findById(id);

        if (pokemon.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(pokemon);
    }

    @PostMapping
    public ResponseEntity<Pokemon> save(@RequestBody Pokemon pokemon) {
        if (pokemon != null && !pokemon.getName().isEmpty()) {
            pokemonService.save(pokemon);
        }

        return ResponseEntity.ok(pokemon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        pokemonService.deleteById(id);

        Boolean pokemonStillExists = pokemonService.existsById(id);

        if (pokemonStillExists)
            return ResponseEntity.internalServerError().build();

        return ResponseEntity.ok().build();
    }
}
