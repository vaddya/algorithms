package episode2.pokemons;

import episode2.Fighter;

/**
 * Pokemon
 */
public abstract class Pokemon implements Fighter {

    protected static final int MAX_HEALTH = 100;
    protected static final int MAX_DAMAGE = 50;

    protected String name;
    protected int health;
    protected int damage;
    protected boolean defensive = false;

    protected int trainBuff;
    protected int eatBuff;
    protected int sleepBuff;

    public Pokemon(String name, int health, int damage) {
        this.name = name;
        this.health = health < MAX_HEALTH ? health : MAX_HEALTH;
        this.damage = damage < MAX_DAMAGE ? damage : MAX_DAMAGE;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return health == 0;
    }

    public void train() {
        increaseDamage(trainBuff);
    }

    public void eat() {
        increaseHealth(eatBuff);
    }

    public void sleep() {
        increaseHealth(sleepBuff);
    }

    @Override
    public int attack() {
        defensive = false;
        return damage;
    }

    @Override
    public void defence() {
        defensive = true;
    }

    @Override
    public void damaged(int damage) {
        if (defensive) {
            System.out.println("but " + name + " blocked " + damage + " dmg");
        } else {
            decreaseHealth(damage);
        }
        defensive = false;
    }

    protected void increaseDamage(int damage) {
        this.damage += damage;
        if (this.damage > MAX_DAMAGE) {
            this.damage = MAX_DAMAGE;
        }
    }

    protected void increaseHealth(int health) {
        this.health += health;
        if (this.health > MAX_HEALTH) {
            this.health = MAX_HEALTH;
        }
    }

    protected void decreaseHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                '}';
    }
}
