// DijkstraAlgorithm.java
import java.util.*;

public class DijkstraAlgorithm {
    public int[] dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V]; 
        boolean[] sptSet = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }

    public int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 10, 0, 0, 0, 0},
                {0, 0, 5, 15, 0, 0},
                {0, 0, 0, 0, 20, 0},
                {0, 0, 0, 0, 0, 30},
                {0, 0, 0, 0, 0, 10},
                {0, 0, 0, 0, 0, 0}
        };
        DijkstraAlgorithm obj = new DijkstraAlgorithm();
        int[] dist = obj.dijkstra(graph, 0);

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < dist.length; i++) {
           
