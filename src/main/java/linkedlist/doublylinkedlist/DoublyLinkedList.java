/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist.doublylinkedlist;

/**
 *
 * @author DELL
 */
public class DoublyLinkedList {

    class Node {

        int data;
        Node prev, next;

        public Node() {
        }

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

    }
    Node head, tail;

    public DoublyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void addFirst(int x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            Node newNode = new Node(x, null, head);
            head.prev = newNode;
            head = head.prev;
        }
    }

    public void addLast(int x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            Node newNode = new Node(x, tail, null);
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            if (head == tail) {
                head = tail = null;
                return;
            }
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            if (head == tail) {
                head = tail = null;
                return;
            }
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deleteData(int x) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                if (current == head) {
                    deleteFirst();
                } else if (current == tail) {
                    deleteLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
        }
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void backTraverse() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.addLast(0);
        dl.addFirst(2);
        dl.addLast(6);
        dl.addLast(3);
        dl.addLast(9);
        dl.traverse();
        dl.deleteFirst();
        dl.traverse();
        dl.deleteLast();
        dl.traverse();
        dl.deleteData(3);
        dl.traverse();
        dl.backTraverse();
    }

}
