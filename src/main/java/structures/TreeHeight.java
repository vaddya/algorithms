package structures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TreeHeight {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int tree[] = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = scan.nextInt();
        }
        int height = findTreeHeight(tree);
        System.out.println(height);
    }

    /**
     * Вычислить высоту данного дерева.
     *
     * @param tree Корневое дерево с вершинами {0, ..., n−1},
     *             заданное как последовательность parent_0, ..., parent_n−1, гдеparent_i - родитель i-й  вершины
     * @return Высота дерева
     */
    public static int findTreeHeight(int[] tree) {
        int height = 1;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < tree.length; i++) {
            height = Math.max(height, distanceToRoot(tree, i, cache));
        }
        return height + 1;
    }

    private static int distanceToRoot(int[] tree, int curr, Map<Integer, Integer> cache) {
        if (cache.containsKey(curr)) {
            return cache.get(curr);
        }
        int height = 1;
        if (tree[curr] != -1) {
            height = 1 + distanceToRoot(tree, tree[curr], cache);
        }
        cache.put(curr, height);
        return height;
    }
}