/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author DELL
 */
public class BinaryTree {

    Node root;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left == null) {
                current.left = newNode;
                break;
            } else {
                queue.offer(current.left);
            }
            if (current.right == null) {
                current.right = newNode;
                break;
            } else {
                queue.offer(current.right);
            }
        }
    }

    public void levelOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public int height() {
        if (root == null) {
            return -1;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int height = -1;
        while (!queue.isEmpty()) {
            int levelNodes = queue.size();
            for (int i = 0; i < levelNodes; i++) {
                Node current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            height++;
        }
        return height;
    }
}
