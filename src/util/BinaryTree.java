package util;

import java.util.Comparator;

public class BinaryTree<T extends IComparable<T>> {

    private Node<T> root;
    private Comparator<T> comparator;

    public BinaryTree() {
    }

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    private int compare(T origin, T target) {
        if (comparator == null) {
            return origin.compareTo(target);
        } else {
            return comparator.compare(origin, target);
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (compare(data, node.data) == 0) {
            return node;
        }

        if (compare(data, node.data) < 0) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(Node<T> node, T data) {
        if (node == null) {
            return false;
        } else if (compare(data, node.data) == 0) {
            return true;
        } else if (compare(data, node.data) < 0) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    public void delete(T data) {
        root = delete(root, data);
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) {
            throw new RuntimeException("cannot delete.");
        } else if (compare(data, node.data) < 0) {
            node.left = delete(node.left, data);
        } else if (compare(data, node.data) > 0) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                // get data from the rightmost node in the left subtree
                node.data = retrieveData(node.left);
                // delete the rightmost node in the left subtree
                node.left = delete(node.left, node.data);
            }
        }
        return node;
    }

    private T retrieveData(Node<T> node) {
        while (node.right != null) {
            node = node.right;
        }

        return node.data;
    }

    public void preOrderTraversal() {
        preOrderHelper(root);
    }

    private void preOrderHelper(Node node) {
        if (node != null) {
            System.out.print(node + " ");
            preOrderHelper(node.left);
            preOrderHelper(node.right);
        }
    }

    public void inOrderTraversal() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node node) {
        if (node != null) {
            inOrderHelper(node.left);
            System.out.print(node + " ");
            inOrderHelper(node.right);
        }
    }

    // Node class
    static class Node<T> {

        Node<T> left;
        Node<T> right;
        T data;

        public Node() {
        }

        public Node(T t) {
            data = t;
        }
    }
}
