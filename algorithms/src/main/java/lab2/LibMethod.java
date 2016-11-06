package lab2;

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

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
