/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

import java.util.Stack;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        //Add elements to the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        //Print the top element of the stack
        System.out.println("Top element of the stack: " + stack.peek()); //Output: 30
        
        //Remove the top element from the stack
        int popped = stack.pop();
        System.out.println("Remove element: " + popped); //Output: 30
        
        //Check if the stack is empty
        System.out.println("Is the stack empty? " + stack.isEmpty()); //Output: false
        
        //Current size of the stack
        System.out.println("Size of the stack: " + stack.size()); //Output: 2
        
        //Search an element of the stack
        System.out.println(stack.search(10));
    }
}
