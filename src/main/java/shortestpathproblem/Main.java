/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shortestpathproblem;

/**
 *
 * @author DELL
 */
public class Main {

    public static void main(String[] args) {
        DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
        int n = 9;
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        //ab
        graph[0][1] = 4;
        graph[1][0] = 4;
        //ac
        graph[0][2] = 2;
        graph[2][0] = 2;
        //bc
        graph[1][2] = 1;
        graph[2][1] = 1;
        //bd
        graph[1][3] = 5;
        graph[3][1] = 5;
        //cd
        graph[2][3] = 8;
        graph[3][2] = 8;
        //ce
        graph[2][4] = 9;
        graph[4][2] = 9;
        //de
        graph[3][4] = 2;
        graph[4][3] = 2;
        //dz
        graph[3][5] = 4;
        graph[5][3] = 4;
        //ez
        graph[4][5] = 3;
        graph[5][4] = 3;
        
        System.out.println("The shortest path from vertex a to vertex z is: " + algorithm.dijkstra(graph, n, 0, 5));
    }
}
