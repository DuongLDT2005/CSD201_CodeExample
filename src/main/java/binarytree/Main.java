/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarytree;

/**
 *
 * @author DELL
 */
public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(12);
        binaryTree.insert(20);
        binaryTree.insert(6);
        binaryTree.insert(3);
        binaryTree.insert(9);
        binaryTree.insert(17);
        binaryTree.insert(4);
        binaryTree.insert(15);

        System.out.print("Level Order: ");
        binaryTree.levelOrder();
        System.out.println();
        System.out.print("PreOrder: ");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        System.out.print("InOrder: ");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        System.out.print("PostOrder: ");
        binaryTree.postOrder(binaryTree.root);
        System.out.println();

        int height = binaryTree.height();
        if (height == -1) {
            System.out.println("Tree is empty");
        } else {
            System.out.println("Height of binary tree: " + binaryTree.height());
        }
    }
}
