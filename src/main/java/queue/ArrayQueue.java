/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;

/**
 *
 * @author DELL
 */
public class ArrayQueue {
    class Node {
        int data;

        public Node(int x) {
            this.data = x;
        }
        
    }
    
    Node[] arrayNode;
    int capacity, firstIndex, length;

    public ArrayQueue() {
        this(5);
    }

    public ArrayQueue(int capacity) {
        this.arrayNode = new Node[capacity];
        this.firstIndex = -1;
        this.length = 0;
        this.capacity = capacity;
    }
    
    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == capacity;
    }
    
    public void increaseSize() {
        int newCapacity = (int) (capacity * 1.5);
        Node[] temp = new Node[newCapacity];
        int current = 0;
        for (int i = firstIndex; i < firstIndex + length; i++) {
            temp[current++] = arrayNode[i % capacity];
        }
        arrayNode = temp;
        capacity = newCapacity;
        firstIndex = 0;
    }
    
    public void enQueue(int x) {
        if (isFull()) {
            increaseSize();
        } else {
            if (firstIndex == -1) {
                firstIndex = 0;
            }
            int lastIndex = (firstIndex + length) % capacity;
            arrayNode[lastIndex] = new Node(x);
            length++;
        }
    }
    
    public Node deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Node temp = arrayNode[firstIndex];
        firstIndex = (firstIndex + 1) % capacity;
        length--;
        return temp;
    }
    
    public Node front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return arrayNode[firstIndex];
    }
    
    public void traverse() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        for (int i = firstIndex; i < firstIndex + length; i++) {
            System.out.print(arrayNode[i % capacity].data + " -> ");
        }
        System.out.println("null");
        System.out.println(" -- FirstIndex: " + firstIndex + " -- Length: " + length);
        System.out.println(" -- capacity: " + capacity);
    }
    
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue();
        aq.enQueue(0);
        aq.enQueue(1);
        aq.enQueue(2);
        aq.enQueue(3);
        aq.traverse();
        System.out.println("After dequeue " + aq.deQueue().data);
        aq.traverse();
        System.out.println("First element " + aq.front().data);
        aq.traverse();
    }
    
}
