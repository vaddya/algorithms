package algorithms.sublist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

/**
 * Test MaxSublist method
 *
 * @author vaddya
 * @since March 05, 2017
 */
@RunWith(value = Parameterized.class)
public class MaxSublistTest {

    @Parameter
    public List<Integer> list;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(10, 11, 7, 10, 6)},
                {Arrays.asList(6, 8, 10, 7, 9, 15)},
                {Arrays.asList(100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94)},
                {Arrays.asList(16, 4, 6, 7, 9, 5)},
                {Arrays.asList(19, 29, 41, 15, 49, 9, 25)},
        });
    }

    @Test
    public void testFindMaxSublist() throws Exception {
        Sublist sublist = MaxSublist.findMaxSublist(list);
        Sublist bustSublist = MaxSublist.bustFindMaxSublist(list);
        assertEquals(bustSublist, sublist);
        System.out.println(list);
        System.out.println(sublist + "\n");
    }
}