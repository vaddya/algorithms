package module2.sorting;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static algorithms.Utils.gen;
import static algorithms.Utils.isSorted;
import static org.junit.Assert.assertTrue;

/**
 * Tester at technopolis
 *
 * @author vaddya
 * @since November 27, 2016
 */
@RunWith(value = Parameterized.class)
public class Tester {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameter
    public int[] array;

    @Parameters
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
                {0},
                {0, 0, 0, 0},
                {4, 3, 2, 1},
                {0, 1, 1, 0},
                {1},
                {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
                gen(1),
                gen(10),
                gen(100),
                gen(1000),
                gen(10000),
        });
    }

    @Test
    public void test01_checkInsertionAdvSort() throws IOException {
        assertTrue(isSorted(InsertionSortAdv.sort(array)));
    }

    @Test
    public void test02_checkInsertionSort() throws IOException {
        assertTrue(isSorted(InsertionSort.sort(array)));
    }

    @Test
    public void test03_checkMergeSort() throws IOException {
        assertTrue(isSorted(MergeSort.sort(array)));
    }

    @Test
    public void test04_checkQuickSort() throws IOException {
        assertTrue(isSorted(QuickSort.sort(array)));
    }

    @Test
    public void test05_checkQuickAdvSort() throws IOException {
        assertTrue(isSorted(QuickSortAdv.sort(array)));
    }

    @Test
    public void test05_checkShellSort() throws IOException {
        assertTrue(isSorted(ShellSort.sort(array)));
    }
}
