/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shortestpathproblem;

/**
 *
 * @author DELL
 */
public class Dijkstra {

    void Dijkstra(int G[][], int a, int z) {
        int n = G.length;
        int L[] = new int[n];
        Boolean S[] = new Boolean[n];
        for (int i = 0; i < n; i++) {
            L[i] = Integer.MAX_VALUE;
            S[i] = false;
        }
        L[a] = 0;
        int[] pre = new int[n];
        while (S[z] == false) {
            int min = Integer.MAX_VALUE;
            int u = -1;
            for (int k = 0; k < n; k++) {
                if (S[k] == false && L[k] < min) {
                    min = L[k];
                    u = k;
                }
            }
            S[u] = true;
            for (int v = 0; v < n; v++) {
                if (S[v] == false && G[u][v] != 0 && L[v] > L[u] + G[u][v]) {
                    L[v] = L[u] + G[u][v];
                    pre[v] = u;
                }
            }
        }
        System.out.println("a \t z \t L");
        System.out.println(a + "\t" + z + "\t" + L[z]);
        int current = z;
        while (current != a) {
            System.out.print(" <- " + current);
            current = pre[current];
        }
        System.out.println(" <- " + a);
    }

    public static void main(String[] args) {
        int G[][] = {
            {0, 4, 2, 0, 0, 0},
            {4, 0, 1, 5, 0, 0},
            {2, 1, 0, 8, 9, 0},
            {0, 5, 8, 0, 2, 4},
            {0, 0, 9, 2, 0, 3},
            {0, 0, 0, 4, 3, 0}
        };
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.Dijkstra(G, 0, 5);
    }
}
