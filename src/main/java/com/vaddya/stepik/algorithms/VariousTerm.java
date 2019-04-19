package com.vaddya.stepik.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VariousTerm {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();

            List<Integer> nums = find(n);

            System.out.println(nums.size());
            nums.forEach(i -> System.out.print(i + " "));
        }
    }

    /**
     * По данному числу 1≤n≤10^9 найдите максимальное число k,
     * для которого n можно представить как сумму k различных натуральных слагаемых.
     * Выведите в первой строке число k, во второй — k слагаемых.
     */
    public static List<Integer> find(int n) {
        List<Integer> nums = new ArrayList<>();

        int curr = 1;
        int left = n;
        while (left > 0) {
            if (left < curr) {
                nums.add(nums.remove(nums.size() - 1) + left);
                break;
            }

            left -= curr;
            nums.add(curr);
            curr++;
        }

        return nums;
    }
}
