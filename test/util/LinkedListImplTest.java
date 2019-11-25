package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListImplTest {

    final int[] array = new int[]{22, 2, 77, 6, 43, 76, 89};

    public LinkedListImplTest() {
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

    /* Description  : To test add, where the list is empty.
     * Precondition : List is empty
     * Postcondition: Data is added
     */
    @Test
    public void testAdd_EmptyList() {
        System.out.println("add - Empty List");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        // Add to empty list
        instance.add(0, 69);

        if (instance.get(0) != 69) {
            fail("Data is not added into empty LinkedList");
        }
    }

    /* Description  : To test add to the head of the list
     * Precondition : List not empty
     * Postcondition: Data is added as the head of the list
     */
    @Test
    public void testAdd_Head() {
        System.out.println("add - to Head");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        initializeLinkedList(instance);

        // Add to head
        instance.add(0, 69);

        if (instance.get(0) != 69) {
            fail("Data is not the head LinkedList");
        }
    }

    /* Description  : To test add to the tail of the list
     * Precondition : List not empty
     * Postcondition: Data is added as the tail of the list
     */
    @Test
    public void testAdd_Tail() {
        System.out.println("add - to Tail");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        initializeLinkedList(instance);

        // Add to tail, 6 is before tail. 7 is after tail
        instance.add(7, 69);

        if (instance.get(7) != 69) {
            fail("Data is not the tail LinkedList");
        }
    }

    /* Description  : To test add to the middle of the list
     * Precondition : List not empty
     * Postcondition: Data is added as the middle of the list
     */
    @Test
    public void testAdd_Middle() {
        System.out.println("add - to Middle");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        initializeLinkedList(instance);

        // Add to middle
        instance.add(5, 69);

        if (instance.get(5) != 69) {
            fail("Data is not the middle of LinkedList");
        }
    }

    /* Description  : To test add to the middle of the list
     * Precondition : List not empty
     * Postcondition: Data is added as the middle of the list
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        initializeLinkedList(instance);

        // Clear the list
        instance.clear();

        if (!instance.isEmpty()) {
            fail("LinkedList is not cleared!");
        }
    }

    /* Description  : To test get method
     * Precondition : List not empty
     * Postcondition: Data is returned
     */
    @Test
    public void testGet() {
        System.out.println("get");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        initializeLinkedList(instance);

        // Compare the results
        for (int i = 0; i < array.length; i++) {
            if (instance.get(i) != array[i]) {
                fail("LinkedList mismatch with Array.");
            }
        }
    }

    /* Description  : To test indexOf
     * Precondition : List not empty, no duplicates
     * Postcondition: Index returned same with array
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        initializeLinkedList(instance);

        // Compare the results
        for (int i = 0; i < array.length; i++) {
            if (instance.indexOf(array[i]) != i) {
                fail("Found index mismatch with array.");
            }
        }
    }

    /* Description  : To test isEmpty
     * Precondition : 
     * Postcondition: isEmpty is true when list is empty
     *              : isEmpty is false when list is not empty
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        // Empty check before adding data
        if (!instance.isEmpty()) {
            fail("LinkedList should be empty!");
        }

        // Add data
        initializeLinkedList(instance);

        // Empty check after adding data
        if (instance.isEmpty()) {
            fail("LinkedList should not be empty!");
        }

        // Clear the list
        instance.clear();

        // Empty check after clearing data
        if (!instance.isEmpty()) {
            fail("LinkedList should be empty!");
        }
    }

    /* Description  : To test remove of the head
     * Precondition : List has more than 1 elements
     * Postcondition: head should be removed 
     *              : new head should be next of removed head
     */
    @Test
    public void testRemove_Head() {
        System.out.println("remove");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        initializeLinkedList(instance);

        // Remove head
        instance.remove(0);

        if (instance.get(0) == array[0]) {
            fail("Data not removed.");
        } else if (instance.get(0) != array[1]) {
            fail("Mismatched head.");
        }
    }

    /* Description  : To test remove of the tail
     * Precondition : List has more than 1 elements
     * Postcondition: tail should be removed 
     *              : new tail should be prev of removed tail
     */
    @Test
    public void testRemove_Tail() {
        System.out.println("remove");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        initializeLinkedList(instance);

        // Remove head
        instance.remove(instance.size() - 1);

        if (instance.get(instance.size() - 1) == array[array.length - 1]) {
            fail("Data not removed.");
        } else if (instance.get(instance.size() - 1) != array[array.length - 2]) {
            fail("Mismatched tail.");
        }
    }

    /* Description  : To test Size
     * Precondition : 
     * Postcondition: size is 0 when list is empty
     *              : valid size when list is not empty
     */
    @Test
    public void testSize() {
        System.out.println("size");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        if (instance.size() != 0) {
            fail("Size should be 0!");
        }

        initializeLinkedList(instance);

        if (instance.size() != array.length) {
            fail("Size should be " + array.length + "!");
        }
    }

    /* Description  : To test add
     * Precondition : 
     * Postcondition: Every element should be successfully added
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        System.out.println("size");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        initializeLinkedList(instance);

        // Compare results
        for (int i = 0; i < array.length; i++) {
            if (instance.get(i) != array[i]) {
                fail("LinkedList mismatch with Array.");
            }
        }
    }

    /* Description  : To test remove
     * Precondition : 
     * Postcondition: Element should be removed from list
     */
    @Test
    public void testRemove_Object() {
        System.out.println("remove");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        // Remove head
        initializeLinkedList(instance);
        instance.remove((Object) array[0]);
        if (instance.get(0) != array[1]) {
            fail("Failed to remove head");
        }

        // Remove middle (not head nor tail)
        instance.clear();
        initializeLinkedList(instance);
        int mid = array.length / 2;
        instance.remove((Object) array[mid]);
        if (instance.get(mid) != array[mid + 1]) {
            fail("Failed to remove middle");
        }

        // Remove tail
        instance.clear();
        initializeLinkedList(instance);
        instance.remove((Object) array[array.length - 1]);
        if (instance.get(instance.size() - 1) != array[array.length - 2]) {
            fail("Failed to remove head");
        }
    }

    /* Description  : To test toArray
     * Precondition : List is not empty
     * Postcondition: Result of toArray is the same with source array
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        initializeLinkedList(instance);

        // Compare results
        Object[] temp = instance.toArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != (int) temp[i]) {
                fail("To Array mismatch with source.");
            }
        }
    }

    /* Description  : To test node
     * Precondition : List is not empty
     * Postcondition: Result of node match with source array
     */
    @Test
    public void testNode() {
        System.out.println("node");
        LinkedListImpl<Integer> instance = new LinkedListImpl<>();

        initializeLinkedList(instance);

        // Compare each element
        for (int i = 0; i < instance.size(); i++) {
            if (instance.get(i) != array[i]) {
                fail("LinkedList mismatch with Array.");
            }
        }
    }

    // Create a predefined LinkedList
    private void initializeLinkedList(LinkedListImpl<Integer> instance) {
        for (int i : array) {
            instance.add(i);
        }
    }
}
