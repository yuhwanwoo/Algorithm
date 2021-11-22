package test.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class pra001 {

    public static final int INF = (int) 1e9;

    public static int n, m, start;

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        d = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(dest, dis));
        }

        Arrays.fill(d, INF);


        dijkstra(start);


    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        d[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if (d[now] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = graph.get(now).get(i).getDistance() + d[now];
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {

    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}
