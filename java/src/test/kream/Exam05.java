package test.kream;

import java.util.*;

public class Exam05 {
    public static void main(String[] args) {
        int n = 5; // Number of nodes in the tree
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(3, 5));
        List<Integer> visitNodes = Arrays.asList(2,4);

        int minPath = minimumTreePath(n, edges, visitNodes);
        System.out.println("Minimum Path Length: " + minPath);
    }

    public static int minimumTreePath(int n, List<List<Integer>> edges, List<Integer> visitNodes) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int[] shortestPath = new int[n + 1];
        Arrays.fill(shortestPath, -1);
        shortestPath[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("current = " + current);

            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (shortestPath[neighbor] == -1) {
                    shortestPath[neighbor] = shortestPath[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        int minPath = Integer.MAX_VALUE;
        for (int node : visitNodes) {
            if (shortestPath[node] == -1) {
                return -1; // If any visitNode is not reachable, return -1
            }
            minPath = Math.min(minPath, shortestPath[node]);
        }

        return minPath;
    }
}
