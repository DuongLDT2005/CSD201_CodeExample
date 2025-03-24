/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.balancebst_array;

/**
 *
 * @author DELL
 */
public class BalanceBST {

    class Node {

        int data;
        Node right, left;

        public Node(int x, Node left, Node right) {
            this.data = x;
            this.left = left;
            this.right = right;
        }

        public Node(int x) {
            this(x, null, null);
        }
    }
    Node root;
    int idx = -1;
    Node[] arrayNodes = new Node[20];

    public BalanceBST() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return 1 + maxInt(height(node.left), height(node.right));
    }

    int maxInt(int a, int b) {
        return a > b ? a : b;
    }

    boolean isBalanced(Node node) {
        return Math.abs(height(node.left) - height(node.right)) <= 1;
    }

    int getBalance(Node node) {
        return height(node.left) - height(node.right);
    }

    //balance tree bằng cách đưa vào array
    void balance(Node[] arrayNodes, int firstIndex, int lastIndex) {
        if (firstIndex <= lastIndex) {
            int mid = (firstIndex + lastIndex) / 2;
            insertRec(arrayNodes[mid].data);
        }
    }

    void balance() {
        //save tree to array
        saveOrder(root, arrayNodes);
        for (int i = 0; i <= idx; i++) {
            System.out.print(arrayNodes[i].data + "   ");
        }

        root = null;//delete tree
        int firstIdx = 0, lastIdx = idx;
        int mid = (firstIdx + lastIdx) / 2;
        balance(arrayNodes, firstIdx, lastIdx);
    }

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

    void saveOrder(Node root, Node[] arr) {
        if (root.left != null) {
            saveOrder(root.left, arr);
        }
        arr[++idx] = root;
        if (root.right != null) {
            saveOrder(root.right, arr);
        }

    }

    //balance tree bằng rotation
    Node balanceRot(Node node) {
        if (getBalance(node) < -1) { //right subtree higher than left subtree
            if (getBalance(node.right) > 0) {//left subtree higher than right subtree(of node.right)
                node.right = rightRotate(node.right);
            }
            node = leftRotate(node);
        }

        if (getBalance(node) > 1) {
            if (getBalance(node.left) < 0) {
                node.left = leftRotate(node.left);
            }
            node = rightRotate(node);
        }

        return node;
    }

    void balanceRot() {
        root = balanceRot(root);
    }

    Node leftRotate(Node root) {
        Node temp = root.right;
        Node temp2 = temp.left;
        temp.left = root;
        root.right = temp2;
        return temp;
    }

    Node rightRotate(Node root) {
        Node temp = root.left;
        Node temp2 = temp.right;
        temp.right = root;
        root.left = temp2;
        return temp;
    }

    //chen vao cay va tu tai can bang neu co
    Node insertBalance(int x, Node node) {
        if (node == null) {
            node = new Node(x);
            return node;
        }
        if (x < node.data) {
            node.left = insertBalance(x, node.left);
        }
        if (x > node.data) {
            node.right = insertBalance(x, node.right);
        }

        node = balanceRot(node);

        return node;
    }

    void insertBalance(int x) {
        root = insertBalance(x, root);
    }

    public void inOrder(Node current) {
        if (current == null) {
            return;
        }
        inOrder(current.left);
        System.out.print(current.data + " ");
        inOrder(current.right);
    }

    public static void main(String[] args) {
        BalanceBST bBSTree = new BalanceBST();
        bBSTree.insertRec(30);
        bBSTree.insertRec(20);
        bBSTree.insertRec(50);
        bBSTree.insertRec(40);
        bBSTree.insertRec(60);
        bBSTree.insertRec(35);
        bBSTree.insertRec(45);
        bBSTree.balance();
        System.out.println("\n========after rotation=================");
        bBSTree.balanceRot();
        bBSTree.insertBalance(30);
        bBSTree.insertBalance(50);
        bBSTree.insertBalance(10);
        bBSTree.insertBalance(60);
        bBSTree.inOrder(bBSTree.root);

        System.out.println("\n============after add 60============");
        bBSTree.inOrder(bBSTree.root);

        System.out.println("\n============after add 65============");
        bBSTree.insertBalance(65);
        bBSTree.inOrder(bBSTree.root);

    }
}
