package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://www.e-olymp.com/ru/problems/3967
 *
 * @author vaddya
 */
public class Ropes {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter writer = new PrintWriter("output.txt");
            int ropesNum = in.nextInt();
            int housesNum = in.nextInt();
            long[] ropes = new long[ropesNum];
            for (int i = 0; i < ropesNum; i++) {
                ropes[i] = in.nextLong();
            }
            writer.print(magic(housesNum, ropes));
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static long magic(int housesNum, long[] ropes) {
        long ropesSum = 0;
        for (long rope : ropes) {
            ropesSum += rope;
        }
        long best = ropesSum / housesNum;
        long left = 0;
        long right = best + 1;
        long good = 0;
        while (left < right - 1) {
            long current = (left + right) / 2;
            int count = 0;
            for (long rope : ropes) {
                count += rope / current;
            }
            if (count < housesNum) {
                right = current;
            } else {
                good = good > current ? good : current;
                left = current;
            }
        }
        return good;
    }
}
