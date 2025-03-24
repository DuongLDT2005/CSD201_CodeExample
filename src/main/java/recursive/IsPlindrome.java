/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursive;

/**
 *
 * @author DELL
 */
public class IsPlindrome {

    static boolean isPlindrome(char c[], int n) {
        if (n == 1) {
            return true;
        }
        int m = c.length;
        if (c[m - n] != c[n - 1]) {
            return false;
        } else {
            return isPlindrome(c, n - 1);
        }
    }

    public static void main(String[] args) {
        char[] c = "radar".toCharArray();
        System.out.println(isPlindrome(c, c.length));
    }
}
