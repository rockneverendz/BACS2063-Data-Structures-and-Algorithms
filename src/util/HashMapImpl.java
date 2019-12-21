package util;

import java.util.Objects;

public class HashMapImpl<K, V> implements IMap<K, V> {

    transient Node<K, V>[] table;
    final private double loadFactor;
    private int threshold;
    private int size;

    // https://www.baeldung.com/java-hashcode
    // implement hashCode() inside object classes 
    // so Object.hash() can use it effectively.
    static class Node<K, V> implements IMap.IEntry<K, V> {

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

        public final boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object instanceof Node) {
                Node<?, ?> node = (Node<?, ?>) object;
                if (Objects.equals(this.key, node.key)
                        && Objects.equals(this.value, node.value)) {
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

    public HashMapImpl() {
        this.loadFactor = 0.75;
    }

    public HashMapImpl(int capacity) {
        this.loadFactor = 0.75;
        this.threshold = tableSizeFor(capacity);
    }

    @Override
    public int size() {
        return size;
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
                    case 1 : it's the only node
                        place temp in newTable[temp.hash AND with newCapacity -1]
                    case 2 : it's not the only node
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
                Node<K, V> temp = oldTable[j];
                if (temp != null) {
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
                                    temp.prev = lowTail;
                                }
                                lowTail = temp;
                            } else {
                                if (highTail == null) {
                                    highHead = temp;
                                } else {
                                    highTail.next = temp;
                                    temp.prev = highTail;
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
        int hash = hash(key);
        int index = (table.length - 1) & hash;
        Node<K, V> temp;

        /*
        case 1 : table is not empty and have valid length
            case 1.1 : the index contain nodes
                loop through the nodes
         */
        if (tableExists()) {
            if (table[index] != null) {

                temp = getNode(hash, key, table[index]);
                
                if (temp != null) {
                    return temp.value;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        Node<K, V> temp;
        V oldValue = null;
        int hash = hash(key);
        int index;

        if (!tableExists()) {
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
        case 1 : there's no node here
        case 2 : there's node here
            loop through the nodes
            case 2.1 : there's no matching nodes. (new node)
            case 2.2 : temp is the matching nodes. (replace node)
         */
        if (temp == null) {
            table[index] = new Node(hash, key, value);
        } else {
            temp = getNode(hash, key, temp);
            if (temp == null) {
                Node<K, V> newNode = new Node(hash, key, value);
                table[index].prev = newNode;
                newNode.next = table[index];
                table[index] = newNode;
            } else {
                oldValue = temp.value;
                temp.value = value;
            }
        }
        if (++size > threshold) {
            resize();
        }
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        V oldValue;
        int hash = hash(key);
        int index = (table.length - 1) & hash;
        Node<K, V> temp;

        /*
        case 1 : table is not empty and have valid length
            case 1.1 : the index contain nodes
                case 1.1.1 : it's the first node
                    case 1.1.1.1 : the only node in the index
                        empty out the index
                    case 1.1.1.2 : at least two nodes in the index
                        update next node
                    reduce size
                    return old value
                case 1.1.2 : its the middle or last node
                    update next pointer (if there's any)
                    update prev pointer
                    
         */
        if (tableExists()) {
            if (table[index] != null) {
                temp = table[index];

                if (compareKeys(hash, key, temp)) {
                    if (temp.next == null) {
                        table[index] = null;
                    } else {
                        temp.next.prev = temp.prev;
                        temp.next = null;
                    }

                    --size;
                    oldValue = temp.value;
                    temp.value = null;
                    return oldValue;
                }

                temp = getNode(hash, key, temp.next);
                
                if (temp != null) {
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                        temp.next = null;
                    }

                    temp.prev.next = temp.next;
                    temp.prev = null;

                    --size;
                    oldValue = temp.value;
                    temp.value = null;
                    return oldValue;
                }
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        V value = get(key);
        return (value != null);
    }

    @Override
    public boolean containsValue(Object value) {
        Node<K, V>[] tab;
        V v;

        /*
        case 1 : table is not empty and have at least one node
            for every index in the table
                for every node in the index
                    case 1.1 : values match
                        return true
         */
        if ((tab = table) != null && size > 0) {
            for (int i = 0; i < tab.length; ++i) {
                for (Node<K, V> e = tab[i]; e != null; e = e.next) {
                    if ((v = e.value) == value
                            || (value != null && value.equals(v))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        if (tableExists()) {
            size = 0;
            for (int i = 0; i < table.length; i++) {
                table[i] = null;
            }
        }

    }

    private boolean tableExists() {
        return table != null && table.length > 0;
    }

    /*
     * Description  : Returns x where (x > cap) and x is a power of 2
     *                https://stackoverflow.com/questions/51118300
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
     * Description  : Find the matching node through the node list 
     *                begin from the specified node
     * Return       : true  - A match!
     *                false - No matching nodes
     */
    private Node<K, V> getNode(int hash, Object key, Node<K, V> node) {
        while (compareKeys(hash, key, node) == false) {
            if (node.next == null) {
                return null;
            }
            node = node.next;
        }
        return node;
    }

    /*
     * Description  : Compares the node with the specified key and hash
     * Return       : true  - Match
     *                false - Does not match
     */
    private boolean compareKeys(int hash, Object key, Node<K, V> node) {
        K nodeKey = node.key;

        return node.hash == hash
                && (nodeKey == key || (key != null && key.equals(nodeKey)));
    }
}
