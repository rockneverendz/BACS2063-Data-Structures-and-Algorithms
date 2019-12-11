package util;

import model.Laptop;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HashSetImplTest {

    Laptop laptop[] = new Laptop[]{
        new Laptop("Asus"),
        new Laptop("Beagle"),
        new Laptop("Corsair"),
        new Laptop("Dell"),
        new Laptop("Enigma"),
        new Laptop("Ford"),
        new Laptop("Gravity"),
        new Laptop("HP")
    };

    public HashSetImplTest() {
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
     * Test of size method, of class HashSetImpl.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        HashSetImpl instance = new HashSetImpl();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resize method, of class HashSetImpl.
     */
    @Test
    public void testResize() {
        System.out.println("resize");
        HashSetImpl instance = new HashSetImpl();
        instance.resize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class HashSetImpl.
     */
    @Test
    public void testGet() {
        System.out.println("put");
        HashSetImpl instance = new HashSetImpl();

        initializeHashset(instance);

        if (instance.get(0) != laptop[0]) {
            fail();
        }

        if (instance.get(2) != laptop[2]) {
            fail();
        }

        if (instance.get(8) != null) {
            fail();
        }

        if (instance.get(0) != laptop[0]) {
            fail();
        }

        if (instance.get(32) != laptop[2]) {
            fail();
        }

    }

    /**
     * Test of put method, of class HashSetImpl.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        HashSetImpl instance = new HashSetImpl();

        initializeHashset(instance);

        if (instance.size() != 16) {
            fail();
        }

        // Test overwriting of nodes
        instance.put(0, laptop[7]);

        if (instance.get(0) != laptop[7] || instance.size() != 17) {
            fail();
        }

        // Test removal of nodes
        instance.remove(0);

        if (instance.get(0) != null || instance.size() != 16) {
            fail();
        }

    }

    /**
     * Test of remove method, of class HashSetImpl.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object key = null;
        HashSetImpl instance = new HashSetImpl();
        Object expResult = null;
        Object result = instance.remove(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class HashSetImpl.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        HashSetImpl instance = new HashSetImpl();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containsKey method, of class HashSetImpl.
     */
    @Test
    public void testContainsKey() {
        System.out.println("containsKey");
        Object key = null;
        HashSetImpl instance = new HashSetImpl();
        boolean expResult = false;
        boolean result = instance.containsKey(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containsValue method, of class HashSetImpl.
     */
    @Test
    public void testContainsValue() {
        System.out.println("containsValue");
        Object value = null;
        HashSetImpl instance = new HashSetImpl();
        boolean expResult = false;
        boolean result = instance.containsValue(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class HashSetImpl.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        HashSetImpl instance = new HashSetImpl();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private void initializeHashset(HashSetImpl instance) {
        // Test node in different indices
        for (int i = 0; i < laptop.length; i++) {
            instance.put(i, laptop[i]);
        }

        // Test node in same indies
        for (int i = 0; i < laptop.length; i++) {
            instance.put((i + 1) * 16, laptop[i]);
        }
    }
}
