package lab1;

import algorithms.sorting.QuickSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.e-olymp.com/ru/problems/1459
 *
 * @author vaddya
 */
public class Revision {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            int n = in.nextInt();
            int[] droids = new int[n];
            for (int i = 0; i < n; i++) {
                droids[i] = in.nextInt();
            }
            QuickSort.sort(droids);
            writer.print(droids[0] + " " + droids[1]);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
