package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1368 {
    private static int[] parent;
    private static int[] w;
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> edges = new PriorityQueue<>();

        w = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(br.readLine());
            parent[i] = i;
        }

        StringTokenizer st;
        int p;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                p = Integer.parseInt(st.nextToken());
                if (i != j) {
                    edges.add(new Edge(p, i, j));
                    continue;
                }
                edges.add(new Edge(w[i], i, 0));
            }
        }

        while (!edges.isEmpty()) {
            Edge now = edges.poll();
            int nodeA = now.nodeA;
            int nodeB = now.nodeB;
            if (findParent(nodeA) == findParent(nodeB)) {
                continue;
            }
            unionParent(nodeA, nodeB);
            answer += now.distance;
        }
        System.out.println(answer);
    }

    private static class Edge implements Comparable<Edge> {
        private int distance;
        private int nodeA;
        private int nodeB;

        public Edge(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

    // 특정 원소가 속한 집합을 찾기
    private static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) {
            return x;
        }
        return findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        }
        else parent[a] = b;
    }
}
