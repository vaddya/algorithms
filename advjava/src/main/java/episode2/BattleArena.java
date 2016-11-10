package episode2;

import episode2.pokemons.Bulbasaur;
import episode2.pokemons.Ivysaur;
import episode2.pokemons.Pokemon;

/**
 * Battle Arena
 */
public class BattleArena {

    public static void main(String[] args) throws InterruptedException {
        Trainer trainer1 = new Trainer(new Bulbasaur("Bul", 80, 15));
        Trainer trainer2 = new Trainer(new Ivysaur("Ivy", 70, 30));
        trainer1.feedPokemon(); // + 10 health
        trainer1.trainPokemon(); // + 5 dmg
        trainer2.putToSleepPokemon(); // + 30 health
        BattleArena arena = new BattleArena(trainer1, trainer2);
        arena.intro();
        arena.start();
        arena.summarize();
    }

    public void intro() {
        out("Today's fighters are:");
        out(trainer1.getPokemon().toString());
        out(trainer2.getPokemon().toString());
        out("");
    }

    public void summarize() {
        Pokemon winner = trainer1.getPokemon().isDead()
                ? trainer2.getPokemon()
                : trainer1.getPokemon();
        out(winner.getName() + " won in " + step + " steps!");
    }

    private Trainer trainer1;
    private Trainer trainer2;
    private int step = 0;

    public BattleArena(Trainer trainer1, Trainer trainer2) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
    }

    public void start() throws InterruptedException {
        out("Start!");
        Trainer trainer = trainer1;
        while (!isOver()) {
            makeStep(trainer);
            trainer = trainer == trainer1 ? trainer2 : trainer1;
            logCurrentHealth();
            Thread.sleep(1000);
        }
    }

    private void makeStep(Trainer trainer) {
        step++;
        Pokemon own = trainer.getPokemon();
        Pokemon enemy = trainer == trainer1 ? trainer2.getPokemon() : trainer1.getPokemon();

        if (trainer.nextCommand() == Command.ATTACK) {
            out(step + ") " + own.getName() + " attacks " + enemy.getName() + " for " + own.getDamage() + " dmg");
            enemy.damaged(own.attack());
        } else {
            out(step + ") " + own.getName() + " defends now");
            own.defence();
        }
    }

    private void logCurrentHealth() {
        System.out.println(trainer1.getPokemon().getName() + ": " + trainer1.getPokemon().getHealth() + " hp, "
                + trainer2.getPokemon().getName() + ": " + trainer2.getPokemon().getHealth() + " hp\n");
    }

    private static void out(String s) {
        System.out.println(s);
    }

    public boolean isOver() {
        return trainer1.getPokemon().isDead() || trainer2.getPokemon().isDead();
    }
}
