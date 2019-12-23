package util;

/**
 * @author Yap Jun Yan
 */
public class TreeMap<K, V> implements IMap<K, V> {

    private Node<K, V> root;
    private int size = 0;
    private final IComparator<? super K> comparator;

    public TreeMap() {
        this.comparator = null;
    }

    public TreeMap(IComparator<? super K> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            throw new NullPointerException();
        }

        Node<K, V> p = getNode(key);
        return (p == null ? null : p.value);
    }

    public Node<K, V> getNode(Object key) {
        if (comparator != null) {
            // We use provided comparator to compare
            // comparator(key, node.key)
            return getNodeWithComparator(key);
        } else {
            // We use comparable to compare (K must implement compareTo)
            // key.compareTo(node.key)
            return getNodeDefault(key);
        }
    }

    private Node<K, V> getNodeWithComparator(Object key) {
        K k = (K) key;
        Node<K, V> node = root;
        while (node != null) {
            int result = comparator.compare(k, node.key);
            if (result < 0) {
                node = node.left;
            } else if (result > 0) {
                node = node.right;
            } else {
                // Found!
                return node;
            }
        }
        return null;
    }

    private Node<K, V> getNodeDefault(Object key) {
        Comparable<? super K> k = (Comparable<? super K>) key;
        Node<K, V> node = root;
        while (node != null) {
            int result = k.compareTo(node.key);
            if (result < 0) {
                node = node.left;
            } else if (result > 0) {
                node = node.right;
            } else {
                // Found!
                return node;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        Node<K, V> node = root;

        if (key == null) {
            throw new NullPointerException();
        }

        /*  
        case 1 : Tree is empty
        case 2 : comparator is defined (it exists)
            loop until tranversed to a leaf (no next node)
                case 2.1 : value is smaller than current node
                    move pointer to the left
                case 2.2 : value is larger than current node
                    move pointer to the right
                case 2.3 : value match
                    update value of this node
        case 3 : comparator is not defined (it doens't exists) thus we use comparable compareTo
            loop until tranversed to a leaf (no next node)
                case 3.1 : value is smaller than current node
                    move pointer to the left
                case 3.2 : value is larger than current node
                    move pointer to the right
                case 3.3 : value match
                    update value of this node
         */
        V result;
        if (node == null) {
            root = new Node<>(key, value, null);
            result = null;
        } else if (comparator != null) {
            result = putNodeWithComparator(key, value);
        } else {
            result = putNodeDefault(key, value);
        }

        size++;
        return result;
    }

    private V putNodeWithComparator(K key, V value) {
        Node<K, V> node = root;
        Node<K, V> parent;
        int result;
        do {
            parent = node;
            result = comparator.compare(key, node.key);
            if (result < 0) {
                node = node.left;
            } else if (result > 0) {
                node = node.right;
            } else {
                break; //Matching node!
            }
        } while (node != null);

        if (result < 0) {
            parent.left = new Node<>(key, value, parent);
        } else if (result > 0) {
            parent.right = new Node<>(key, value, parent);
        } else {
            V oldValue = parent.value;
            parent.value = value;
            return oldValue;
        }
        return null;
    }

    private V putNodeDefault(K key, V value) {
        Node<K, V> node = root;
        Node<K, V> parent;
        int result;
        Comparable<? super K> k = (Comparable<? super K>) key;
        do {
            parent = node;
            result = k.compareTo(node.key);
            if (result < 0) {
                node = node.left;
            } else if (result > 0) {
                node = node.right;
            } else {
                break; //Matching node!
            }
        } while (node != null);
        if (result < 0) {
            parent.left = new Node<>(key, value, parent);
        } else if (result > 0) {
            parent.right = new Node<>(key, value, parent);
        } else {
            V oldValue = parent.value;
            parent.value = value;
            return oldValue;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        Node<K, V> node = getNode(key);
        if (node == null) {
            return null;
        }

        V oldValue = node.value;
        removeNode(node);
        return oldValue;
    }

    private void removeNode(Node<K, V> node) {
        size--;

        /* 
        case 1 : have left and right node
            migrate successor's data to this node
            make it's successor the node you need to remove
        
        case 1 : have left node
            case 1.1 : no parent node (root)
            case 1.2 : check parent left is the one getting deleted
            case 1.3 : it's right side
        case 2 : have right node
            case 2.1 : no parent node (root)
            case 2.2 : check parent left is the one getting deleted
            case 2.3 : it's right side
        case 4 : have no node
            case 3.1 : have parent
            case 4.2 : no parent (it's the root)
        
         */
        if (node.left != null && node.right != null) {
            Node<K, V> successor = successor(node);
            node.key = successor.key;
            node.value = successor.value;
            node = successor; //successor to be removed
        }

        if (node.left != null) {
            if (node.parent == null) {
                node.left.parent = null;
                root = node.left;
            } else if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }
        } else if (node.right != null) {
            if (node.parent == null) {
                node.right.parent = null;
                root = node.right;
            } else if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
        } else {
            if (node.parent != null) {
                if (node == node.parent.left) {
                    node.parent.left = null;
                } else if (node == node.parent.right) {
                    node.parent.right = null;
                }
                node.parent = null;
            } else {
                root = null;
            }
        }
    }

    public Node<K, V> successor(Node<K, V> target) {

        /*
        case 1 : is target is null
            return null;
        case 2 : does target.right exists?
            target.right left most node
        case 3 : lookup parent
            loop until target is not parent's right node (until it's left)
         */
        if (target == null) {
            return null;
        } else if (target.right != null) {
            Node<K, V> parent = target.right;
            while (parent.left != null) {
                parent = parent.left;
            }
            return parent;
        } else {
            Node<K, V> parent = target.parent;
            Node<K, V> temp = target;
            while (parent != null && temp == parent.right) {
                temp = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public Node<K, V> predecessor(Node<K, V> target) {

        /*
        case 1 : is target is null
            return null;
        case 2 : does target.left exists?
            target.left right most node
        case 3 : lookup parent
            loop until target is not parent's left node (until it's right)
         */
        if (target == null) {
            return null;
        } else if (target.left != null) {
            Node<K, V> parent = target.left;
            while (parent.right != null) {
                parent = parent.right;
            }
            return parent;
        } else {
            Node<K, V> parent = target.parent;
            Node<K, V> temp = target;
            while (parent != null && temp == parent.left) {
                temp = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    // Node class
    static class Node<K, V> implements IMap.IEntry<K, V> {

        Node<K, V> parent;
        Node<K, V> left;
        Node<K, V> right;
        K key;
        V value;

        public Node(K key, V value, Node<K, V> parent) {
            this.parent = parent;
            this.key = key;
            this.value = value;
        }
    }
}
