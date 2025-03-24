/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

/**
 *
 * @author DELL
 */
public class LinkedListStack {
    class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int x) {
            this.data = x;
            this.next = null;
        }
        
    }
    Node head;
    public boolean isEmpty() {
        return head == null;
    }
    
    public void push(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    
    public Node pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        Node current = head;
        head = head.next;
        return current;
    }
    
    public Node top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return head;
    }
    
    public void traverse() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
    
    public static void main(String[] args) {
        LinkedListStack ls = new LinkedListStack();
        ls.push(0);
        ls.push(1);
        ls.push(2);
        ls.push(3);
        ls.traverse();
        System.out.println("Pop: " + ls.pop().data);
        System.out.println("Stack after pop: ");
        ls.traverse();
        System.out.println("Top: " + ls.top().data);
        ls.traverse();
    }
}
