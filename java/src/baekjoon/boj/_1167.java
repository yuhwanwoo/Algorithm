package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1167 {
    private static HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
    private static boolean[] visited;
    private static int maxDistance;
    private static int maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());

        visited = new boolean[v + 1];

        StringTokenizer st;

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int nextNode = Integer.parseInt(st.nextToken());
                if (nextNode == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                if (!map.containsKey(node)) {
                    map.put(node, new ArrayList<>());
                }
                map.get(node).add(new Node(node, nextNode, distance));
            }
        }

        visited[1] = true;
        dfs(1, 0);

        maxDistance = 0;
        visited = new boolean[v + 1];
        visited[maxNode] = true;
        dfs(maxNode, 0);
        System.out.println(maxDistance);
    }

    private static void dfs(int now, int distance) {
        if (distance > maxDistance) {
            maxDistance = distance;
            maxNode = now;
        }

        for (int i = 0; i < map.get(now).size(); i++) {
            Node nextNode = map.get(now).get(i);
            if (visited[nextNode.end]) {
                continue;
            }
            visited[nextNode.end] = true;
            dfs(nextNode.end, distance + nextNode.distance);
            visited[nextNode.end] = false;
        }
    }

    private static class Node {
        private int start;
        private int end;
        private int distance;

        public Node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}
