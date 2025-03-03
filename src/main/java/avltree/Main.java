/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package avltree;

/**
 *
 * @author DELL
 */
public class Main {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insertRec(new Product(1, "Product A", 10.99));
        avlTree.insertRec(new Product(4, "Product B", 15.49));
        avlTree.insertRec(new Product(2, "Product C", 5.89));
        avlTree.insertRec(new Product(5, "Product D", 20.00));
        avlTree.insertRec(new Product(3, "Product E", 25.50));
        
        System.out.println("InOrder traversal:");
        avlTree.traverseInOder(avlTree.root);
        
        System.out.println("Product with maximum price:");
        System.out.println(avlTree.findMaxPrice());
        
        System.out.println("Product with  minimum price:");
        System.out.println(avlTree.findMinPrice());
        
        avlTree.delete(3);
        System.out.println("All Products after deletion:");
        avlTree.traverseInOder(avlTree.root);
    }
}
