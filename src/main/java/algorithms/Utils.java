package algorithms;

import java.util.Random;

/**
 * Utils class
 *
 * @author vaddya
 */
public class Utils {

    private static Random random = new Random(37); // const

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

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[][] arrays = new int[][]{
            gen(100),
            gen(1000),
            gen(10000),
            gen(100000)
    };


    public static int[] gen(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n);
        }
        return array;
    }

    public static String[] genStrings(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            int length = 1 + random.nextInt(10);
            StringBuilder sb = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                sb.append((char) ('a' + random.nextInt(26)));
            }
            array[i] = sb.toString();
        }
        return array;
    }
}
