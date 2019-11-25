package util;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MergeSortTest {

    public MergeSortTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of mergeSort method, of class MergeSort.
     */
    @Test
    public void testMergeSort() {
        System.out.println("mergeSort");
        int[] array = {7, 2, 6, 3, 8, 4, 5};
        int[] sorted = {2, 3, 4, 5, 6, 7, 8};
        int low = 0;
        int high = array.length - 1;
        MergeSort instance = new MergeSort();
        instance.mergeSort(array, low, high);
        assertArrayEquals(sorted, array);
    }
}
