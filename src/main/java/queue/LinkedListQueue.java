/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;

/**
 *
 * @author DELL
 */
public class LinkedListQueue {
    class Node {
        int data;
        Node prev, next;

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node(int x) {
            this.data = x;
            this.prev = this.next = null;
        }
        
    }
    Node head, tail;

    public LinkedListQueue() {
        head = tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void addFirst(int x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            head.prev = new Node(x, null, head);
            head = head.prev;
        }
    }
    
    public void addLast(int x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            tail.next = new Node(x, tail, null);
            tail = tail.next;
        }
    }
    
    public Node removeFirst() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Node temp = head;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return temp;
    }
    
    public Node removeLast() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Node temp = tail;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return temp;
    }
    
    public Node first() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return head;
    }
    
    public Node last() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return tail;
    }
    
    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
            current = tail;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.prev;
            }
            System.out.println("null");
        }
    }
    
    public static void main(String[] args) {
        LinkedListQueue lq = new LinkedListQueue();
        lq.addLast(0);
        lq.addLast(1);
        lq.addLast(2);
        lq.addLast(3);
        lq.addFirst(4);
        lq.traverse();
        lq.removeFirst();
        lq.traverse();
        lq.removeLast();
        lq.traverse();
    }
}
