/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist.singlylinkedlist;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        
        //Add to the beginning
        list.addFirst(10);
        list.addFirst(20);
        list.display(); //20 -> 10 -> null
        
        //Add to the end
        list.addLast(30);
        list.display(); //20 -> 10 -> 30 -> null
        
        //Add to a specific position
        list.addAtPosition(25, 2);
        list.display(); //20 -> 10 -> 25 -> 30 -> null
        
        System.out.println("Sorted list");
        list.sortAsc();
        list.display();
        
        //Delete from the beginning
        list.deleteFirst();
        list.display(); //10 -> 25 -> 30 -> null
        
        //Delete from the end
        list.deleteLast();
        list.display(); //10 -> 25 -> null
        
        //Delete at a specific position
        list.deleteAtPosition(1);
        list.display(); //10 -> null
        
    }
}
