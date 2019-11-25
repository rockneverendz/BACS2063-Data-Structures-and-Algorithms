package util;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MergeSortTest {

    Laptop[] array;
    Laptop[] sorted;

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
        array = new Laptop[]{
            new Laptop(7),
            new Laptop(2),
            new Laptop(6),
            new Laptop(3),
            new Laptop(8),
            new Laptop(4),
            new Laptop(5)
        };
        sorted = new Laptop[]{
            new Laptop(2),
            new Laptop(3),
            new Laptop(4),
            new Laptop(5),
            new Laptop(6),
            new Laptop(7),
            new Laptop(8)
        };
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
        int low = 0;
        int high = array.length - 1;
        MergeSort instance = new MergeSort();
        instance.mergeSort((Object[]) array,
                low,
                high, 
                (IComparator<Laptop>) (Laptop a, Laptop b) -> a.compareByPrice(b)
        );
        
        if (!Arrays.equals(sorted, array)) {
            System.out.println("To be Sorted = " + Arrays.toString(array));
            System.out.println("Sorted = " + Arrays.toString(sorted));
            fail("Array not equal.");
        }
    }

    class Laptop {

        private int price;

        public Laptop(int price) {
            this.price = price;
        }

        public int compareByPrice(Laptop laptop) {
            if (price == laptop.price) {
                return 0;
            } else if (price > laptop.price) {
                return 1;
            } else {
                return -1;
            }
        }
        
        // Overriding equals() to compare two Complex objects 
        @Override
        public boolean equals(Object o) {
            // If the object is compared with itself then return true   
            if (o == this) {
                return true;
            }

            /* Check if o is an instance of Laptop or not 
               "null instanceof [type]" also returns false */
            if (!(o instanceof Laptop)) {
                return false;
            }

            // typecast o to Laptop so that we can compare data members  
            Laptop laptop = (Laptop) o;

            // Compare the data members and return accordingly  
            return Integer.compare(this.price, laptop.price) == 0;
        }
        
        @Override
        public String toString(){
            return price + "";
        }
    }
}
