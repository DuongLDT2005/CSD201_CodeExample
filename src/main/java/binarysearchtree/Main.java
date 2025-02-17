/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearchtree;

/**
 *
 * @author DELL
 */
public class Main {

    public static void main(String[] args) {
        BinarySearchTree bstree = new BinarySearchTree();
        bstree.inseartLap(15);
        bstree.inseartLap(20);
        bstree.inseartLap(7);
        bstree.inseartLap(12);
        bstree.inseartLap(24);
        bstree.inseartLap(13);
        bstree.inseartLap(3);
        bstree.inseartLap(9);
        bstree.inseartLap(10);
        bstree.delete(15);
//        bstree.insertRec(15);
//        bstree.insertRec(20);
//        bstree.insertRec(7);
//        bstree.insertRec(12);
//        bstree.insertRec(24);
//        bstree.insertRec(13);
//        bstree.insertRec(3);
//        bstree.insertRec(9);
//        bstree.insertRec(10);
        bstree.inOrder(bstree.root);
    }
}
