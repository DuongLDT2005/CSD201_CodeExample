/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author DELL
 */
public class BFS {
    public void BFS(Graph G, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] enqueued = new boolean[G.getVertices()];
        for (int i = 0; i < G.getVertices(); i++) {
            enqueued[i] = false;
        }
        queue.offer(start);
        enqueued[start] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int i = 0; i < G.getVertices(); i++) {
                if (!enqueued[i] && G.getAdjMatrix()[u][i] > 0) {
                    queue.offer(i);
                    enqueued[i] = true;
                }
            }
        }
    }
}
