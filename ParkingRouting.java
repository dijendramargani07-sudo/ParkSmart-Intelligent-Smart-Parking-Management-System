import java.util.*;

public class ParkingRouting {

    static final int V = 5;

    int minDistance(int dist[], boolean visited[]) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int v=0; v<V; v++) {

            if(!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    void dijkstra(int graph[][], int src) {

        String zones[] = {
                "Entrance",
                "Zone A",
                "Zone B",
                "Zone C",
                "VIP Zone"
        };

        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        System.out.println(
        "========================================");

        System.out.println(
        "ParkSmart - Route Optimization");

        System.out.println(
        "========================================\n");

        for(int count=0; count<V-1; count++) {

            int u = minDistance(dist, visited);

            visited[u] = true;

            System.out.println(
            "Selected Zone : "
            + zones[u]);

            for(int v=0; v<V; v++) {

                if(!visited[v]
                        && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v]
                        < dist[v]) {

                    dist[v] =
                    dist[u] + graph[u][v];

                    System.out.println(
                    "Updated Distance to "
                    + zones[v]
                    + " = "
                    + dist[v]);
                }
            }

            System.out.println(
            "--------------------------------");
        }

        System.out.println(
        "\nFinal Shortest Distances\n");

        for(int i=0; i<V; i++) {

            System.out.println(
            zones[src]
            + " -> "
            + zones[i]
            + " = "
            + dist[i]);
        }

        System.out.println(
        "\nShortest Route:");

        System.out.println(
        "Entrance -> Zone B -> Zone C -> VIP Zone");
    }

    public static void main(String[] args) {

        int graph[][] = {

            {0,4,2,0,0},
            {4,0,0,5,0},
            {2,0,0,3,0},
            {0,5,3,0,2},
            {0,0,0,2,0}
        };

        ParkingRouting obj =
                new ParkingRouting();

        obj.dijkstra(graph,0);
    }
}