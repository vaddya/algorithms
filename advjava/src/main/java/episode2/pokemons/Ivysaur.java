package episode2.pokemons;

/**
 * Ivysaur
 */
public class Ivysaur extends Pokemon {

    public Ivysaur(String name, int health, int damage) {
        super(name, health, damage);
        trainBuff = 10;
        eatBuff = 15;
        sleepBuff = 30;
    }

}
