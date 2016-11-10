package episode2.pokemons;

/**
 * Bulbasaur
 */
public class Bulbasaur extends Pokemon {

    public Bulbasaur(String name, int health, int damage) {
        super(name, health, damage);
        trainBuff = 5;
        eatBuff = 10;
        sleepBuff = 20;
    }

}
