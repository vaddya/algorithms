package module1.eolymp;

import algorithms.BinarySearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.e-olymp.com/ru/problems/3970
 *
 * @author vaddya
 */
public class Mutants {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            int num = in.nextInt();
            int[] mutants = new int[num];
            for (int i = 0; i < num; i++) {
                mutants[i] = in.nextInt();
            }
            int requests = in.nextInt();
            for (int i = 0; i < requests; i++) {
                int curr = in.nextInt();
                int left = BinarySearch.leftBinarySearch(mutants, curr);
                int right = BinarySearch.rightBinarySearch(mutants, curr);
                writer.println(left == -1 ? 0 : right - left + 1);
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
