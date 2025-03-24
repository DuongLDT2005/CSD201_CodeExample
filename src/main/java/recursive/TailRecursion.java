/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursive;

/**
 *
 * @author DELL
 */
public class TailRecursion {

    void nonTail(int i) {
        if (i > 0) {
            tail(i - 1);
            System.out.print(i + "");
            tail(i - 1);
        }
    }

    static void tail(int n) {
        if (n > 0) {
            System.out.print(n + " ");
            tail(n - 1);
        }
    }

    public static void main(String[] args) {
        tail(10);
        System.out.println();
    }
}
