/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avltree;

/**
 *
 * @author DELL
 */
public class AVLTree {

    AVLTreeNode root;

    private int getHeight(AVLTreeNode current) {
        if (current == null) {
            return 0;
        }
        return current.height;
    }

    private int getBalanceFactor(AVLTreeNode current) {
        if (current == null) {
            return 0;
        }
        return getHeight(current.right) - getHeight(current.left);
    }

    private AVLTreeNode balanceTree(AVLTreeNode current) {
        int balanceFactor = getBalanceFactor(current);
        if (balanceFactor > 1 && getBalanceFactor(current.left) >= 0) {
            return rotateRight(current);
        }
        if (balanceFactor < -1 && getBalanceFactor(current.right) <= 0) {
            return rotateLeft(current);
        }
        if (balanceFactor > 1 && getBalanceFactor(current.left) < 0) {
            current.left = rotateLeft(current.left);
            return rotateRight(current);
        }
        if (balanceFactor < -1 && getBalanceFactor(current.right) > 0) {
            current.right = rotateLeft(current.right);
            return rotateLeft(current);
        }
        return current;
    }

    private AVLTreeNode rotateLeft(AVLTreeNode current) {
        if (current == null || current.right == null) {
            return current;
        }
        AVLTreeNode a = current.right;
        AVLTreeNode b = a.left;
        a.left = current;
        current.right = b;
        current.height = Math.max(getHeight(current.left), getHeight(current.right)) + 1;
        a.height = Math.max(getHeight(a.left), getHeight(a.right)) + 1;
        return a;
    }

    private AVLTreeNode rotateRight(AVLTreeNode current) {
        if (current == null || current.left == null) {
            return current;
        }
        AVLTreeNode a = current.left;
        AVLTreeNode b = a.right;
        a.right = current;
        current.left = b;
        current.height = Math.max(getHeight(current.left), getHeight(current.right)) + 1;
        a.height = Math.max(getHeight(a.left), getHeight(a.right)) + 1;
        return a;
    }

    public void insertRec(Product product) {
        root = addRec(root, product);
    }

    private AVLTreeNode addRec(AVLTreeNode current, Product product) {
        if (current == null) {
            return new AVLTreeNode(product);
        }
        if (product.getId() < current.product.getId()) {
            current.left = addRec(current.left, product);
        } else if (product.getId() > current.product.getId()) {
            current.right = addRec(current.right, product);
        } else {
            return current;
        }
        current.height = 1 + Math.max(getHeight(current.left), getHeight(current.right));

        return balanceTree(current);
    }

    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private AVLTreeNode deleteRec(AVLTreeNode current, int id) {
        if (current == null) {
            return null;
        }
        if (id < current.product.getId()) {
            current.left = deleteRec(current.left, id);
        } else if (id > current.product.getId()) {
            current.right = deleteRec(current.right, id);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            AVLTreeNode largestValue = findLargestValue(current.left);
            largestValue.right = current.right;
            return current.left;
        }
        current.height = Math.max(getHeight(current.left), getHeight(current.right)) + 1;
        return balanceTree(current);
    }

    private AVLTreeNode findLargestValue(AVLTreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public void traverseInOder(AVLTreeNode current) {
        if (current != null) {
            traverseInOder(current.left);
            System.out.println(current.product);
            traverseInOder(current.right);
        }
    }

    public Product findMaxPrice() {
        return findMaxPriceRec(root, null);
    }

    private Product findMaxPriceRec(AVLTreeNode current, Product maxPriceProduct) {
        if (current == null) {
            return maxPriceProduct;
        }
        if (maxPriceProduct == null || current.product.getPrice() > maxPriceProduct.getPrice()) {
            maxPriceProduct = current.product;
        }
        maxPriceProduct = findMaxPriceRec(current.left, maxPriceProduct);
        maxPriceProduct = findMaxPriceRec(current.right, maxPriceProduct);
        return maxPriceProduct;
    }

    public Product findMinPrice() {
        return findMinPriceRec(root, null);
    }

    private Product findMinPriceRec(AVLTreeNode current, Product minPriceProduct) {
        if (current == null) {
            return minPriceProduct;
        }
        if (minPriceProduct == null || current.product.getPrice() < minPriceProduct.getPrice()) {
            minPriceProduct = current.product;
        }
        minPriceProduct = findMinPriceRec(current.left, minPriceProduct);
        minPriceProduct = findMinPriceRec(current.right, minPriceProduct);
        return minPriceProduct;
    }

}
