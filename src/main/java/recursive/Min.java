/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursive;

/**
 *
 * @author DELL
 */
public class Min {

    static int min(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        if (a[0] > a[n - 1]) {
            a[0] = a[n - 1];
        }
        return min(a, n - 1);
    }

    public static void main(String[] args) {
        int[] a = {7, 2, 10, 1, -9, 2};
        System.out.println(min(a, a.length));
    }
}
