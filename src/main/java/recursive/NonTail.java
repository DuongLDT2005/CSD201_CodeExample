/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursive;

/**
 *
 * @author DELL
 */
public class NonTail {

    public static void reverse() throws Exception {
        char ch = (char) System.in.read();
        if (ch != '\n') {
            reverse();
            System.out.print(ch);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\nEnter a string to be reversed:");
        reverse();
        System.out.println("\n");
    }
}
