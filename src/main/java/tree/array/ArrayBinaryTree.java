/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.array;

/**
 *
 * @author DELL
 */
public class ArrayBinaryTree {

    class Node {

        int data;

        public Node(int x) {
            this.data = x;
        }

    }

    int length;
    int capacity;
    Node[] arrayNode;

    public ArrayBinaryTree(int capacity) {
        this.length = 0;
        this.capacity = capacity;
        this.arrayNode = new Node[capacity];
    }

    public ArrayBinaryTree() {
        this(7);
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == capacity;
    }

    public void increaseSize() {
        int newCapacity = capacity * 2;
        Node[] newArrayNode = new Node[newCapacity];
        System.arraycopy(arrayNode, 0, newArrayNode, 0, capacity);
        arrayNode = newArrayNode;
        capacity = newCapacity;
    }

    public void insert(int x) {
        if (isFull()) {
            increaseSize();
//            System.out.println("Tree is full");
//            return;
        }
        arrayNode[length++] = new Node(x);
    }

    public void preOrder(int root) {
        if (root >= length) {
            return;
        }
        if (isEmpty()) {
            System.out.println("Tree is empty");
        } else {
            System.out.print(arrayNode[root].data + " ");
            preOrder(2 * root + 1);
            preOrder(2 * root + 2);
        }
    }

    public void postOrder(int root) {
        if (root >= length) {
            return;
        }
        if (isEmpty()) {
            System.out.println("Tree is empty");
        } else {
            postOrder(2 * root + 1);
            postOrder(2 * root + 2);
            System.out.print(arrayNode[root].data + " ");
        }
    }

    public void inOrder(int root) {
        if (root >= length) {
            return;
        }
        if (isEmpty()) {
            System.out.println("Tree is empty");
        } else {
            inOrder(2 * root + 1);
            System.out.print(arrayNode[root].data + " ");
            inOrder(2 * root + 2);
        }
    }

    public static void main(String[] args) {
        ArrayBinaryTree abt = new ArrayBinaryTree();
        abt.insert(3);
        abt.insert(5);
        abt.insert(7);
        abt.insert(9);
        abt.insert(6);
        abt.insert(4);
        System.out.println("PreOrder: ");
        abt.preOrder(0);
        System.out.println("\nPostOrder: ");
        abt.postOrder(0);
        System.out.println("\nInOrder: ");
        abt.inOrder(0);
    }

}
