package algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * Utils class
 *
 * @author vaddya
 */
public class Utils {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(gen(1000)));
    }

    private static Random random = new Random(System.currentTimeMillis());

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            swap(array, i, i + random.nextInt(array.length - i));
        }
    }

    public static int[][] ARRAYS = new int[][] {
            gen(10), gen(100), gen(1000), gen(10000)
    };

    public static int[] gen(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(5);
        }
        return array;
    }

}
