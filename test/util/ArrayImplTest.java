package util;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Laptop;

public class ArrayImplTest {

    Laptop[] array;
    Laptop[] sorted;

    public ArrayImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        array = new Laptop[7];
        double[] price = {7, 2, 6, 3, 8, 4, 5};
        for (int i = 0; i < array.length; i++) {
            array[i] = new Laptop();
            array[i].setPrice(price[i]);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of mergeSort method, of class ArrayImpl.
     */
    @Test
    public void testMergeSort() {
        System.out.println("mergeSort");
        int low = 0;
        int high = array.length - 1;
        ArrayImpl instance = new ArrayImpl();
        instance.mergeSort((Object[]) array,
                low,
                high,
                new Laptop.SortLaptopByPrice()
        );

        for (int i = 0; i < array.length; i++) {
            if (array[i].getPrice() != i + 2) {
                fail();
            }
        }
    }
}
