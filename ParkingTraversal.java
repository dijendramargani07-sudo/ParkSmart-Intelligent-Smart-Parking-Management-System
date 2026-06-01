import java.util.*;

public class ParkingTraversal {

    static Map<String,List<String>> graph =
            new LinkedHashMap<>();

    static void bfs(String start) {

        Queue<String> queue =
                new LinkedList<>();

        Set<String> visited =
                new HashSet<>();

        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()) {

            String node = queue.poll();

            System.out.print(node + " ");

            for(String n : graph.get(node)) {

                if(!visited.contains(n)) {

                    visited.add(n);
                    queue.add(n);
                }
            }
        }
    }

    static void dfs(String node,
                    Set<String> visited) {

        visited.add(node);

        System.out.print(node + " ");

        for(String n : graph.get(node)) {

            if(!visited.contains(n))
                dfs(n,visited);
        }
    }

    public static void main(String[] args) {

        graph.put("ParkingComplex",
                Arrays.asList(
                "GroundFloor",
                "FirstFloor",
                "SecondFloor"));

        graph.put("GroundFloor",
                Collections.emptyList());

        graph.put("FirstFloor",
                Collections.emptyList());

        graph.put("SecondFloor",
                Arrays.asList(
                "ZoneA",
                "ZoneB"));

        graph.put("ZoneA",
                Collections.emptyList());

        graph.put("ZoneB",
                Collections.emptyList());

        System.out.println(
        "===== ParkSmart Navigation =====");

        System.out.println(
        "\nBFS Traversal:");

        bfs("ParkingComplex");

        System.out.println(
        "\n\nDFS Traversal:");

        dfs("ParkingComplex",
            new HashSet<>());
    }
}