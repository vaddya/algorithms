package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.e-olymp.com/ru/problems/869 todo
 *
 * @author vaddya
 * @since November 13, 2016
 */
public class AntiQuickSort {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            int n = in.nextInt();
            int[] array = new int[n];

            for (int i = 0; i <= n / 2; i++) {
                array[i] = 2 * i + 1;
            }
            int curr = array[n / 2] - 1;
            for (int i = n / 2 + 1; i < n; i++) {
                array[i] = curr;
                curr -= 2;
            }
            for (int i : array) {
                writer.print(i + " ");
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
