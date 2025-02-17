/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarysearchtree;

/**
 *
 * @author DELL
 */
public class BinarySearchTree {

    Node root;

    //add node using iteration
    public void inseartLap(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (data < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else if (data > current.data) {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            } else {
                return;
            }
        }
    }

    //Recursion
    public void insertRec(int data) {
        root = addRec(root, data);
    }

    private Node addRec(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        if (data < current.data) {
            current.left = addRec(current.left, data);
        } else if (data > current.data) {
            current.right = addRec(current.right, data);
        } else {
            return current;
        }
        return current;
    }

    //delete using copying
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node current, int data) {
        if (current == null) {
            return null;//node does not exist
        }
        if (data < current.data) {
            current.left = deleteRec(current.left, data); //traverse left subtree
        } else if (data > current.data) {
            current.right = deleteRec(current.right, data); //traverse right subtree
        } else {
            //found node
            //1.leaf
            if (current.left == null && current.right == null) {
                return null;
            }
            //2. 1 child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            //3. 2 children
            //copying
            //find predecessor: max node of left tree
//            Node largestValue = findLargestValue(current.left);
            // node to delete = predecessor
//            current.data = largestValue.data;
            //delete predecessor
//            current.left = deleteRec(current.left, largestValue.data);

            //merging
            //find predecessor: max node of left tree
            Node largestValue = findLargestValue(current.left);
            //match right subtree to left subtree
            largestValue.right = current.right;
            //return left subtree after merging
            return current.left;
        }
        return current;
    }

    //find max node of left subtree
    private Node findLargestValue(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
}
