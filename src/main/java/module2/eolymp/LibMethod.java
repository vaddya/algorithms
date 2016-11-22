package module2.eolymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.e-olymp.com/ru/problems/2664
 *
 * @author vaddya
 */
public class LibMethod {

    private static PrintWriter writer;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            writer = new PrintWriter("output.txt");
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            sort(array);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            boolean flag = false;
            int j = i - 1;
            while (j >= 0 && array[j] > array[j + 1]) {
                flag = true;
                swap(array, j, j + 1);
                j--;
            }
            if (flag) log(array);
        }
        return array;
    }

    private static void log(int[] array) {
        for (int i : array) {
            writer.print(i + " ");
        }
        writer.print("\n");
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
