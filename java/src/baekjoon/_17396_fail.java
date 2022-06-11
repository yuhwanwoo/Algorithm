package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class _17396_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Long[] distance = new Long[n];
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();

        int[] views = new int[n];

        for (int i = 0; i < n; i++) {
            views[i] = Integer.parseInt(st.nextToken());
            distance[i] = 300000L;
        }

        distance[0] = 0L;

        int a;
        int b;
        int t;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(a).add(new Pair(b, t));
            map.get(b).add(new Pair(a, t));
        }

        /**
         * 분기점 수 5 =>
         *      유섭이 챔피언은 0에 있음
         *      상대편 넥서스는 4에 있음
         * 길의 수 7
         * 0 0 0 1 1 => 갈 수 있는 기점 1 2 3
         */

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {

            Integer now = q.poll();

            for (int i = 0; i < map.get(now).size(); i++) {
                Pair next = map.get(now).get(i);
                int nextNode = next.end;
                int cost = next.cost;

                if (distance[nextNode] < cost) {
                    continue;
                }

                if (views[nextNode] == 1 && nextNode != n - 1) {
                    continue;
                }

                if (distance[nextNode] > distance[now] + cost) {
                    distance[nextNode] = distance[now] + cost;
                    q.add(nextNode);
                }
            }
        }
        if (distance[n - 1] == 300000) {
            System.out.println(-1);
        } else {
            System.out.println(distance[n - 1]);
        }
    }

    private static class Pair {
        int end;
        int cost;

        public Pair(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
