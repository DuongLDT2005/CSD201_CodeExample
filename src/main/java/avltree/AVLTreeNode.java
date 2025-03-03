/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avltree;

/**
 *
 * @author DELL
 */
public class AVLTreeNode {
    Product product;
    AVLTreeNode left;
    AVLTreeNode right;
    int height;

    public AVLTreeNode(Product product) {
        this.product = product;
        this.left = this.right = null;
        this.height = 1;
    }
}
