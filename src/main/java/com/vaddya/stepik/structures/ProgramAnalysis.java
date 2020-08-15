package com.vaddya.stepik.structures;

import java.util.Scanner;

public class ProgramAnalysis {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int varNum = scan.nextInt();
            int eqNum = scan.nextInt();
            int ineqNum = scan.nextInt();
            Pair[] equalities = new Pair[eqNum];
            for (int i = 0; i < eqNum; i++) {
                equalities[i] = new Pair(scan.nextInt(), scan.nextInt());
            }
            Pair[] inequalities = new Pair[ineqNum];
            for (int i = 0; i < ineqNum; i++) {
                inequalities[i] = new Pair(scan.nextInt(), scan.nextInt());
            }
            System.out.println(isAchievable(varNum, equalities, inequalities) ? 1 : 0);
        }
    }

    /**
     * Система равенств и неравенств
     * <p>
     * Проверить, можно ли присвоить переменным целые значения, чтобы
     * выполнить заданные равенства вида xi = xj и неравенства вида xp != xq.
     * Вход. Число переменных n, а также список равенств вида xi = xj и неравенства вида xp != xq.
     * Выход. Проверить, выполнима ли данная система.
     */
    public static boolean isAchievable(int varNum, Pair[] equalities, Pair[] inequalities) {
        int[] parents = new int[varNum];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (Pair equality : equalities) {
            parents[equality.fst - 1] = equality.snd - 1;
        }
        for (Pair inequality : inequalities) {
            int fstParent = getParent(inequality.fst - 1, parents);
            int sndParent = getParent(inequality.snd - 1, parents);
            if (fstParent == sndParent) {
                return false;
            }
        }
        return true;
    }

    private static int getParent(int root, int[] parents) {
        while (parents[root] != root) {
            root = parents[root];
        }
        return root;
    }

    public static class Pair {
        private final int fst;
        private final int snd;

        public Pair(int fst, int snd) {
            this.fst = fst;
            this.snd = snd;
        }
    }
}
