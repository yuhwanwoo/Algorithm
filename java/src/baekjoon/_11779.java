package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11779 {
    public static final int INF = (int) 1e9;

    public static int n, m, start, end;

    public static ArrayList<ArrayList<Nodes>> graph = new ArrayList<>();

    public static int[] d;

    static ArrayList<Integer> routes = new ArrayList<>();
    static int[] route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());


        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Nodes>());
        }

        d = new int[n + 1];
        route = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Nodes(dest, dis));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        Arrays.fill(d, INF);


        dijkstra(start);

        System.out.println(d[end]);
        System.out.println(routes.size());
        for (int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }

    }

    private static void dijkstra(int start) {
        PriorityQueue<Nodes> pq = new PriorityQueue<>();

        d[start] = 0;
        pq.offer(new Nodes(start, 0));

        while (!pq.isEmpty()) {
            Nodes node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if (d[now] < dist) {
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = graph.get(now).get(i).getDistance() + d[now];
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Nodes(graph.get(now).get(i).getIndex(), cost));
                    route[graph.get(now).get(i).getIndex()] = now;
                }
            }
        }

        int node = end;
        while (node != 0) {
            routes.add(node);
            node = route[node];
        }
    }
}

class Nodes implements Comparable<Nodes> {

    int index;
    int distance;

    public Nodes(int index, int distance) {
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
    public int compareTo(Nodes o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}
