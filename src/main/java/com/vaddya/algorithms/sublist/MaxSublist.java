package com.vaddya.algorithms.sublist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Max sublist search
 *
 * @author vaddya
 * @since March 05, 2017
 */
public class MaxSublist {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94);
        System.out.println(findMaxSublist(values));
    }

    public static Sublist findMaxSublist(List<Integer> list) {
        List<Integer> delta = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            delta.add(list.get(i + 1) - list.get(i));
        }
        Sublist overall = new Sublist(delta, 0, 1);
        Sublist current = new Sublist(delta, 0, 1);
        for (int i = 1; i < delta.size(); i++) {
            current.setEnd(i + 1);
            if (current.getSum() < delta.get(i)) {
                current.setBounds(i, i + 1);
            }
            if (current.getSum() > overall.getSum()) {
                overall.setBounds(current.getStart(), current.getEnd());
            }
        }
        return new Sublist(list, overall.getStart(), overall.getEnd() + 1);
    }

    public static Sublist bustFindMaxSublist(List<Integer> list) {
        List<Integer> delta = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            delta.add(list.get(i + 1) - list.get(i));
        }

        Sublist sublist = new Sublist(delta, 0, 1);
        for (int i = 0; i < delta.size(); i++) {
            int sum = 0;
            for (int j = i; j < delta.size(); j++) {
                sum += delta.get(j);
                if (sum > sublist.getSum()) {
                    sublist.setBounds(i, j + 1);
                }
            }
        }
        return new Sublist(list, sublist.getStart(), sublist.getEnd() + 1);
    }
}
