package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TreeMapTest {

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

    private static class CompareInteger implements IComparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }

}
