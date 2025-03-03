/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

/**
 *
 * @author DELL
 */
public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);
        graph.addEdge(2, 6);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        BFS bfs = new BFS();
        bfs.BFS(graph, 0);
        System.out.println();
        bfs.BFS(graph, 4);
    }
}
