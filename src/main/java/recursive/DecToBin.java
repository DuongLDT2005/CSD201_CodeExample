/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursive;

/**
 *
 * @author DELL
 */
public class DecToBin {

    public static void DecToBin(int n) {
        int q = n / 2; // One step
        int r = n % 2; // One step
        if (q > 0) {
            DecToBin(q); // smaller problem
        }
        System.out.print(r);
    }

    public static void main(String[] args) {
        DecToBin(5);
    }
}
