package util;

import java.util.Objects;

public class HashSetImpl<K, V> implements IMap<K, V> {

    transient Node<K, V>[] table;
    double loadFactor = 0.75;
    int threshold;
    int size;

    // https://www.baeldung.com/java-hashcode
    // implement hashCode() inside object classes 
    // so Object.hash() can use it effectively.
    static class Node<K, V> {

        final int hash; // The hash of the key (Immutable)
        final K key; // The key (Also immutable)
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object instanceof Node) {
                Node<?, ?> node = (Node<?, ?>) object;
                if (Objects.equals(this.key, node.getKey())
                        && Objects.equals(this.value, node.getValue())) {
                    return true;
                }
            }
            return false;
        }
    }

    static final int hash(Object key) {
        return (key == null)
                ? 0
                : key.hashCode();
    }

    public HashSetImpl() {
    }

    public HashSetImpl(int capacity) {
        this.threshold = tableSizeFor(capacity);
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    final void resize() {

        // Place everything to a temp variable
        Node<K, V>[] oldTable = table;
        int oldCapacity = (oldTable == null) ? 0 : oldTable.length;
        int oldThreshold = threshold;

        // New variable
        int newCapacity, newThreshold;

        // Three cases
        // 1. Table is not empty.
        // 2. Table is empty, but have a specified threshold.
        // 3. Table is empty, and does not have a specified threshold.
        if (oldCapacity > 0) {
            newCapacity = oldCapacity << 1;
            newThreshold = oldThreshold << 1;
        } else if (oldThreshold > 0) {
            newCapacity = oldThreshold;
            newThreshold = (int) (newCapacity * loadFactor);
        } else {
            newCapacity = 16;
            newThreshold = (int) (newCapacity * loadFactor);
        }

        Node<K, V>[] newTable = (Node<K, V>[]) new Node[newCapacity];
        threshold = newThreshold;
        table = newTable;

        /*   
        If oldTable is not empty
            For every index of the table
                If it's not null
                    place head to temp
                    delete temp
                    case 1 : temp.next is null
                        place temp in newTable[temp.hash AND with newCapacity -1]
                    case 2 : temp.next is not null
                        do
                            case 1 : resizing will not cause repositioning of node
                                add to low list
                            case 2 : resizing will cause repositioning
                                add to high list
                            temp = temp.next
                        while temp != null
        
                        if low list exists
                            clean lowTail.next
                            move it to lower half of the table (back to original index)
                        if high list exists
                            clean highTail.next
                            move it to higher half of the table (new index)
         */
        if (oldTable != null) {
            for (int j = 0; j < oldCapacity; ++j) {
                Node<K, V> temp;
                if ((temp = oldTable[j]) != null) {
                    oldTable[j] = null;
                    if (temp.next == null) {
                        newTable[temp.hash & (newCapacity - 1)] = temp;
                    } else {
                        Node<K, V> lowHead = null, lowTail = null;
                        Node<K, V> highHead = null, highTail = null;
                        do {
                            if ((temp.hash & oldCapacity) == 0) {
                                if (lowTail == null) {
                                    lowHead = temp;
                                } else {
                                    lowTail.next = temp;
                                }
                                lowTail = temp;
                            } else {
                                if (highTail == null) {
                                    highHead = temp;
                                } else {
                                    highTail.next = temp;
                                }
                                highTail = temp;
                            }
                            temp = temp.next;
                        } while (temp != null);
                        if (lowTail != null) {
                            lowTail.next = null;
                            newTable[j] = lowHead;
                        }
                        if (highTail != null) {
                            highTail.next = null;
                            newTable[j + oldCapacity] = highHead;
                        }
                    }
                }
            }
        }
        table = newTable;
    }

    @Override
    public V get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V put(K key, V value) {
        Node<K, V> temp;
        V oldValue = null;
        int hash = hash(key);
        int index;
        
        if (table == null || table.length == 0) {
            resize();
        }

        /*
        Use the length of the table (power of two) minus one
        eg (1000 will become 0111)
        AND the hash of the key to determine the location of the node
         */
        index = (table.length - 1) & hash;
        temp = table[index];

        /*
        case 1 : the specified location is empty
        case 2 : the specified location contain nodes
            case 1 : the first node matches hash and key
                ndoe exists
            case 2 : else
                for every linkedNode (start from second node)
                    temp = node
                    if temp == null
                        newNode
                        break
                    if node matches hash and key (not null)
                        node exists
                        break
            if node exists
                replace node
                return old node
        increse size
        if size > threshold
            resize
        
        */
        
        if (temp == null) {
            table[index] = new Node(hash, key, value);
        } else {
            boolean noMatches = false;

            while (compareKeys(hash, key, temp) == false) {
                if (temp.next == null) {
                    noMatches = true;
                    break;
                } else {
                    temp = temp.next;
                }
            }

            /*
            case 1 : there's no matching nodes. (new node)
            case 2 : temp is the matching nodes. (replace node)
             */
            if (noMatches) {
                Node<K, V> newNode = new Node(hash, key, value);
                newNode.prev = temp;
                temp.next = newNode;
            } else {
                oldValue = temp.value;
                temp.value = value;
            }

            if (++size > threshold) {
                resize();
            }
        }
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
     * https://stackoverflow.com/questions/51118300
     * Description  : Returns x where (x > cap) and x is a power of 2
     * Precondition : 
     * Postcondition: 
     * Return       : x where (x > cap) and x is a power of 2
     */
    private int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    /*
     * Description  : Compares the node with the specified key and hash
     * Precondition : 
     * Postcondition: 
     * Return       : true  - Match
     *                false - Does not match
     */
    private boolean compareKeys(int hash, K key, Node<K, V> node) {

        K nodeKey = node.key;

//        if (node.hash == hash) {
//            if (nodeKey == key) {
//                return true;
//            } else if (key != null){
//                if (key.equals(nodeKey)) {
//                    return true;
//                }
//            } else {
//                return false;
//            }
//        }
        return node.hash == hash
                && (nodeKey == key || (key != null && key.equals(nodeKey)));
    }
}
