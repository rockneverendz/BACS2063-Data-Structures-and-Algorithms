/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.Laptop;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Verniy
 */
public class HashSetImplTest {

    Laptop laptop[];

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
        laptop = new Laptop[]{
            new Laptop("A"),
            new Laptop("B"),
            new Laptop("C"),
            new Laptop("D"),
            new Laptop("E"),
            new Laptop("F"),
            new Laptop("G"),
            new Laptop("H"),};
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of hash method, of class HashSetImpl.
     */
    @Test
    public void testHash() {
        System.out.println("hash");
        Object key = null;
        int expResult = 0;
        int result = HashSetImpl.hash(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        System.out.println("get");
        Object key = null;
        HashSetImpl instance = new HashSetImpl();
        Object expResult = null;
        Object result = instance.get(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of put method, of class HashSetImpl.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        HashSetImpl instance = new HashSetImpl();

        Object key = "sampleKey";
        Object value = laptop;

        for (int i = 0; i < laptop.length; i++) {
            instance.put(i, laptop[i]);
        }

        for (int i = 0; i < laptop.length; i++) {
            instance.put(i * 16, laptop[i]);
        }
        
        Object expResult = null;
        Object result = instance.put(key, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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

}
