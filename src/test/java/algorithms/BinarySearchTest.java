package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * test at technopolis
 *
 * @author vaddya
 * @since November 27, 2016
 */
public class BinarySearchTest {

    @Test
    public void test() throws Exception {
        int[] data = { 10, 47, 50, 63, 89, 90, 99 };
        int[] find = { 84, 33, 10, 829 };
        int[] answers = { 0, 0, 1, 0 };
        int[] results = new int[4];
        for (int i = 0; i < find.length; i++) {
            results[i] = BinarySearch.leftBinarySearch(data, find[i]) == -1 ? 0 : 1;
        }
        assertArrayEquals(answers, results);
    }
}
