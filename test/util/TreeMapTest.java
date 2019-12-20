package util;

import model.CPU;
import model.GPU;
import model.Laptop;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TreeMapTest {

    CPU[] cpu = {
        new CPU("AMD A6", 500, 2.7, "AMD"),
        new CPU("AMD A8", 2, 2.7, "ND"),
        new CPU("AMD A9", 2, 2.7, "AMD"),
        new CPU("AMD A10", 2, 2.9, "AMD"),
        new CPU("AMD A12", 2, 2.9, "AMD"),
        new CPU("AMD E1", 2, 2.9, "AMD"),
        new CPU("AMD E2", 2, 2.9, "AMD"),
        new CPU("Intel celeron", 2, 3.0, "Intel"),
        new CPU("Intel Pentium", 2, 3.0, "Intel"),
        new CPU("Intel Core i3", 2, 3.0, "Intel"),
        new CPU("Intel Core i5", 2, 4.2, "Intel"),
        new CPU("Intel Core i7", 2, 4.2, "Intel"),
        new CPU("Intel core 19", 2, 4.0, "Intel")
    };

    GPU[] gpu = {
        new GPU("GeForce RTX", 4, "vidia"),
        new GPU("GeForce GTX", 3, "vidia"),
        new GPU("Radeon Vega", 4, "AMD"),
        new GPU("Radeon RX", 4, "AMD"),
        new GPU("Radeon R9", 3, "AD"),
        new GPU("Radeon R7", 2, "AMD"),
        new GPU("Radeon RS", 2, "AMD")
    };

    Laptop laptops[] = {
        new Laptop("Asus ZenBook 14          ", "Asus", 2099.00, 23, "ZenBook 14", cpu[7], gpu[6], 8, 256, 14.00, 1.19, "Black"),
        new Laptop("Asus VivoBook 14 X412FA-E", "Asus", 2599.00, 23, "VivoBook 14 X412FA-E", cpu[10], gpu[4], 8, 256, 14.00, 1.19, "Black"),
        new Laptop("Asus VivoBook 14 X412    ", "Asus", 2799.00, 23, "VivoBook 14 X412", cpu[10], gpu[1], 8, 256, 14.00, 1.19, "Black"),
        new Laptop("Asus ROG Zephyrus M GU502", "Asus", 3299.00, 23, "VivoBook 14 X403", cpu[9], gpu[5], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Asus ROG Zephyrus G GA502", "Asus", 3499.00, 23, "ROG Zephyrus M GU502", cpu[10], gpu[4], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Asus ROG Strix SCAR II   ", "Asus", 3499.00, 23, "ROG Strix SCAR II", cpu[10], gpu[1], 8, 256, 15.00, 1.19, "Black"),
        new Laptop("Asus ZenBook Flip 14     ", "Asus", 3500.00, 23, "ZenBook Flip 14", cpu[8], gpu[6], 8, 256, 14.00, 1.19, "Black"),
        new Laptop("Asus VivoBook 14 X403    ", "Asus", 3559.00, 23, "ROG Zephyrus G GA502", cpu[10], gpu[6], 8, 256, 14.00, 1.19, "Black")
    };

    int numbers[] = {15, 6, 23, 4, 7, 71, 5, 50};

    public TreeMapTest() {
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

    @Test
    public void testSize() {
        System.out.println("size");
        TreeMap<Integer, Integer> instance = new TreeMap<>(new CompareInteger());

        // Empty tree
        if (instance.size() != 0) {
            fail();
        }

        // Adding
        for (int i = 0; i < numbers.length; i++) {
            instance.put(numbers[i], i);
            if (instance.size() != i + 1) {
                fail();
            }
        }

        // After add
        if (instance.size() != numbers.length) {
            fail();
        }

        // Deleting
        for (int i = 0; i < numbers.length; i++) {
            instance.remove(numbers[i]);
            if (instance.size() != (numbers.length - (i + 1))) {
                fail();
            }
        }

        // After deletion
        if (instance.size() != 0) {
            fail();
        }
    }

    @Test
    public void testGet() {
        System.out.println("get");
        TreeMap<Integer, Integer> instance = new TreeMap<>(new CompareInteger());
        for (int i = 0; i < numbers.length; i++) {
            instance.put(numbers[i], i);
        }

        // Find root node
        if (instance.get(numbers[0]) != 0) {
            fail();
        }

        // Find a level 3 node
        if (instance.get(numbers[4]) != 4) {
            fail();
        }

        // Find key which doesn't exists
        if (instance.get(999) != null) {
            fail();
        }
    }

    @Test
    public void testPut() {
        System.out.println("put");
        TreeMap<Integer, Integer> instance = new TreeMap<>();
        for (int i = 0; i < numbers.length; i++) {
            instance.put(numbers[i], i);
        }
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        TreeMap<Integer, Integer> instance = new TreeMap<>(new CompareInteger());
        for (int i = 0; i < numbers.length; i++) {
            instance.put(numbers[i], i);
        }

        // If v is not found in the BST, we simply do nothing.
        if (instance.remove(999) != null){
            fail();
        }
        
        // Vertex v is currently one of the leaf vertex of the BST
        if (instance.remove(numbers[6]) != 6) {
            fail();
        }

        // Vertex v is an (internal/root) vertex of the BST and it has exactly one child
        if (instance.remove(numbers[2]) != 2) {
            fail();
        }

        // Vertex v is an (internal/root) vertex of the BST and it has exactly two children
        if (instance.remove(numbers[1]) != 1) {
            fail();
        }

        if (instance.size() != numbers.length - 3) {
            fail();
        }
    }

    @Test
    public void testSuccessor() {
        System.out.println("successor");
        TreeMap<Integer, Integer> instance = new TreeMap<>(new CompareInteger());
        for (int i = 0; i < numbers.length; i++) {
            instance.put(numbers[i], i);
        }

        // Find successor of 23 node
        if (instance.successor(instance.getNode(numbers[2]))
                != instance.getNode(numbers[7])) {
            fail();
        }

        // Find successor of 7 node
        if (instance.successor(instance.getNode(numbers[4]))
                != instance.getNode(numbers[0])) {
            fail();
        }

        // Find successor of 71 node
        if (instance.successor(instance.getNode(numbers[5]))
                != null) {
            fail();
        }
    }

    /**
     * Test of predecessor method, of class TreeMap.
     */
    @Test
    public void testPredecessor() {
        System.out.println("predecessor");
        TreeMap<Integer, Integer> instance = new TreeMap<>(new CompareInteger());
        for (int i = 0; i < numbers.length; i++) {
            instance.put(numbers[i], i);
        }

        // Find successor of 6 node
        if (instance.predecessor(instance.getNode(numbers[1]))
                != instance.getNode(numbers[6])) {
            fail();
        }

        // Find successor of 50 node
        if (instance.predecessor(instance.getNode(numbers[7]))
                != instance.getNode(numbers[2])) {
            fail();
        }

        // Find successor of 4 node
        if (instance.predecessor(instance.getNode(numbers[3]))
                != null) {
            fail();
        }
    }

    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        TreeMap<Integer, Integer> instance = new TreeMap<>(new CompareInteger());

        // Find successor of 6 node
        if (instance.isEmpty() == false) {
            fail();
        }

        for (int i = 0; i < numbers.length; i++) {
            instance.put(numbers[i], i);
        }

        // Find successor of 6 node
        if (instance.isEmpty() == true) {
            fail();
        }
    }

    @Test
    public void testContainsKey() {
        System.out.println("containsKey");
        Object key = null;
        TreeMap instance = new TreeMap();
        boolean expResult = false;
        boolean result = instance.containsKey(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testContainsValue() {
        System.out.println("containsValue");
        Object value = null;
        TreeMap instance = new TreeMap();
        boolean expResult = false;
        boolean result = instance.containsValue(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testClear() {
        System.out.println("clear");
        TreeMap instance = new TreeMap();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private static class CompareInteger implements IComparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }

}
