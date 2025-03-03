/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shortestpathproblem;

import java.util.*;

/**
 *
 * @author DELL
 */
public class DijkstraAlgorithm {

    public int dijkstra(int[][] graph, int n, int start, int end) {
        Map<Integer, Integer> L = new HashMap<>();
        for (int i = 0; i < n; i++) {
            L.put(i, Integer.MAX_VALUE);
        }
        L.put(start, 0);
        Set<Integer> S = new HashSet<>();
        while (!S.contains(end)) {
            int u = -1;
            int minL = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!S.contains(i) && L.get(i) < minL) {
                    minL = L.get(i);
                    u = i;
                }
            }
            S.add(u);
            for (int v = 0; v < n; v++) {
                if (!S.contains(v) && graph[u][v] != Integer.MAX_VALUE) {
                    int newDistance = L.get(u) + graph[u][v];
                    if (newDistance < L.get(v)) L.put(v, newDistance);
                }
            }
        }
        return L.get(end);
    }

}
