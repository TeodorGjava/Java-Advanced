package DefiningClasses.Exc.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {

    private int numberOfBadges = 0;
    private List<Pokemon> pokemons;

    public int getNumberOfBadges() {
        return numberOfBadges;
    }


    public void setNumberOfBadges() {
        this.numberOfBadges++;
    }

    public List<Pokemon> getPokemons() {
        return new ArrayList<>(this.pokemons);
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }
    public int pokeCollectionSize(){
        return pokemons.size();
    }
    private final UnaryOperator<Pokemon> damageTaken = pokemon -> new Pokemon(pokemon.getName(), pokemon.getElement(), pokemon.getHealth() - 10);

    public void missingPokemon(){
        this.pokemons= this.pokemons.stream().map(damageTaken)
                .filter(pokemon -> pokemon.getHealth()>0)
                .collect(Collectors.toList());
    }
    public Trainer() {
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }
}
