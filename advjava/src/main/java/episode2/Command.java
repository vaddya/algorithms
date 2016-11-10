package episode2;

import java.util.Random;

/**
 * Command enum
 */
public enum Command {

    ATTACK,
    DEFENCE;

    private static Random random = new Random(System.currentTimeMillis());

    public static Command random() {
        int value = random.nextInt(4);
        return value > 0 ? values()[0] : values()[1];
    }
}
