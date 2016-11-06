package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.e-olymp.com/ru/problems/2662
 *
 * @author vaddya
 */
public class MinMethod {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            sort(array);
            writer.print(inversions);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int inversions = 0;

    public static void sort(int[] array) {
        int curr = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                if (curr == min) {
                    curr = i;
                    inversions++;
                } else if (curr == i) {
                    curr = min;
                    inversions++;
                }
            }
            swap(array, i, min);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
