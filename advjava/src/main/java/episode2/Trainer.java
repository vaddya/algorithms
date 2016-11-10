package episode2;

import episode2.pokemons.Pokemon;

/**
 * Trainer
 */
public class Trainer implements Commander {

    private Pokemon pokemon;

    public Trainer(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void trainPokemon() {
        pokemon.train();
    }

    public void feedPokemon() {
        pokemon.eat();
    }

    public void putToSleepPokemon() {
        pokemon.sleep();
    }

    @Override
    public Command nextCommand() {
        return Command.random();
    }
}
