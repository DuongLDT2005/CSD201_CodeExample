/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist.circularlinkedlist;

/**
 *
 * @author DELL
 */
public class CircularLinkedList {

    class Node {

        int data;
        Node next;

        public Node(int x) {
            this.data = x;
            this.next = null;
        }

    }
    Node head;

    public CircularLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = newNode;
            head.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = newNode;
            head.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            if (head.next == head) {
                head = null;
            } else {
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                current.next = head.next;
                head = head.next;
            }
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else if (head.next == head) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != head) {
                current = current.next;
            }
            current.next = head;
        }
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            if (current.next == head) {
                System.out.println();
                return;
            } else {
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        cl.addFirst(0);
        cl.addFirst(1);
        cl.addLast(2);
        cl.addLast(3);
        cl.traverse();
        cl.removeFirst();
        cl.traverse();
        cl.removeLast();
        cl.traverse();
    }
}
