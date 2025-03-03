/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

/**
 *
 * @author DELL
 */
public class Graph {
    private int vertices;
    private int[][] adjMatrix;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjMatrix = new int[vertices][vertices];
    }
    
    public void addEdge(int source, int destination) {
        adjMatrix[source][destination] = 1;
        adjMatrix[destination][source] = 1;
    }

    public int getVertices() {
        return vertices;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
        
}
