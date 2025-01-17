/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursive;

/**
 *
 * @author DELL
 */
public class SumOfOddNumbers {
    public static int sumOddNumbers(int n) {
        //Dieu kien dung
        if (n == 1) {
            return 1;
        } else {    //Phan de quy
            return sumOddNumbers(n - 1) + (2 * n - 1);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Sum of first " + n + " odd numbers: " + sumOddNumbers(n));
    }
}
