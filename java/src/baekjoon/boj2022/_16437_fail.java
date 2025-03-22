package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _16437_fail {

    static int[] amount;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int[] wolves;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1번에서 출발하는 걸로 생각해보자
        amount = new int[n + 1];
        visited = new int[n + 1];
        wolves = new int[n + 1];

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            graph.get(i).add(p);
            graph.get(p).add(i);
            if (t.equals("W")) {
                a = -a;
                wolves[i] = 1;
            }
            amount[i + 2] = a;
        }

        int answer = 0;
        for(int i = 2; i < n + 1; i++) {
            if (visited[i] == 0 && wolves[i] != 1) {
                int tmp = dfs(i, 0);
                System.out.println("test " + tmp);
                answer += tmp;
            }

        }

        System.out.println(answer);
    }

    public static int dfs(int now, int tot) {
        if (now == 1) {
            return 0;
        }
        System.out.println(now);
        visited[now] = 1;

        tot += amount[now];
        if (tot < 0) {
            amount[now] = tot;
            return 0;
        } else{
            amount[now] = 0;
        }


        for(int i = 0; i < graph.get(now).size(); i++) {
            int data = graph.get(now).get(i);
            if (visited[data] == 0) {
                tot += dfs(data, tot);
            }
        }

        return tot;
    }
}
