/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursive;

/**
 *
 * @author DELL
 */
public class Factorial {
    public static int factorial(int n) {
        //Dieu kien dung
        if (n == 0) {
            return 1;
        } else {    //Phan de quy
            return n * factorial(n - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(factorial(5));   //Output: 120
    }
}
