/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author DELL
 */
public class BinarySearchTree {

    class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }

    }

    Node root;

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

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
    
    private Node findMinValue(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public int count() {
        return countRec(root);
    }

    private int countRec(Node root) {
        if (root == null) return 0;
        return 1 + countRec(root.left) + countRec(root.right);
    }
    // 11. Find minimum value node
    public Node min() {
        Node current = root;
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    // 12. Find maximum value node
    public Node max() {
        Node current = root;
        while (current != null && current.right != null) {
            current = current.right;
        }
        return current;
    }

    // 13. Sum of all values
    public int sum() {
        return sumRec(root);
    }

    private int sumRec(Node root) {
        if (root == null) return 0;
        return root.data + sumRec(root.left) + sumRec(root.right);
    }

    // 14. Average of all values
    public int avg() {
        int totalNodes = count();
        return totalNodes == 0 ? 0 : sum() / totalNodes;
    }

    public void preorder(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.data + " ");
        preorder(current.left);
        preorder(current.right);
    }

    public void inOrder(Node current) {
        if (current == null) {
            return;
        }
        inOrder(current.left);
        System.out.print(current.data + " ");
        inOrder(current.right);
    }
    
    public void postorder(Node current) {
        if (current == null) return;
        postorder(current.left);
        postorder(current.right);
        System.out.print(current.data + " ");
    }

    private Node findNode(int x, Node root) {
        if (root == null) {
            return null;
        }
        if (root.data == x) {
            return root;
        }
        if (root.data > x) {
            root = findNode(x, root.left);
        }
        if (root.data < x) {
            root = findNode(x, root.right);
        }
        return root;
    }

    public Node findNode(int x) {
        return findNode(x, root);
    }

    Node searchByBreathFirstTraversal(int data) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data == data) {
                return current;
            }
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return null;
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node current) {
        if (current == null) {
            return 0; // Cây rỗng có chiều cao 0
        }
        int leftHeight = heightRec(current.left);
        int rightHeight = heightRec(current.right);
        return Math.max(leftHeight, rightHeight) + 1; // Trả về chiều cao của cây con
    }

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
        System.out.println("\nHeight of bst: " + bstree.height());
    }
}
