/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

/**
 *
 * @author DELL
 */
public class ArrayStack {
    class Node {
        int data;

        public Node(int x) {
            this.data = x;
        }
        
    }
    Node[] arrayNode;
    int capacity;
    int lastIndex;

    public ArrayStack(int capacity) {
        this.arrayNode = new Node[capacity];
        this.lastIndex = -1;
        this.capacity = capacity;
    }

    public ArrayStack() {
        this(5);
    }
        
    public boolean isEmpty() {
        return lastIndex == -1;
    }
    
    public boolean isFull() {
        return lastIndex == capacity - 1;
    }
    
    public void increaseSize() {
        int newCapacity = capacity * 2;
        Node[] newArrayNode = new Node[newCapacity];
        System.arraycopy(arrayNode, 0, newArrayNode, 0, capacity);
        arrayNode = newArrayNode;
        capacity = newCapacity;
    }
    
    public void push(int x) {
        if (isFull()) {
            increaseSize();
        }
        arrayNode[++lastIndex] = new Node(x);
    }
    
    public Node pop() {
        return arrayNode[lastIndex--];
    }
    
    public Node top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return arrayNode[lastIndex];
    }
    
    public void traverse() {
        for (int i = 0; i <= lastIndex; i++) {
            System.out.print(arrayNode[i].data + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack();
        as.push(0);
        as.push(1);
        as.push(2);
        as.push(3);
        as.traverse();
        System.out.println("Node is pop: " + as.pop().data);
        System.out.println("Stack after pop: ");
        as.traverse();
        System.out.println("Node is top: " + as.top().data);
        as.traverse();
    }
}
