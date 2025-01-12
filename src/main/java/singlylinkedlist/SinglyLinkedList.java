/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package singlylinkedlist;

/**
 *
 * @author DELL
 */
public class SinglyLinkedList {
    Node head;
    
    //Add new node at the beginning of linked list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    //Add new node at the end of linked list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    //Add new node to a specific position
    public void addAtPosition(int data, int p) {
        Node newNode = new Node(data);
        if (p == 0) {
            addFirst(data);
            return;
        }
        Node current = head;
        for (int i = 0; i < p - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    
    //Delete from the beginning
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }
    
    //Delete from the end
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) { //Truong hop list co 1 phan tu
            head = null;
            return;
        }
        Node current = head;
        while(current.next.next != null) { //Duyet current den node ke cuoi
            current = current.next;
        }
        current.next = null;
    }
    
    //Delete at a specific position
    public void deleteAtPosition(int p) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (p == 0) {
            deleteFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < p - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Position out of bounds");
        } else {
            current.next = current.next.next;
        }
    }
    
    //Traversal from first node to last node
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
