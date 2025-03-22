package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1707 {
    static int v, e, start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int j = 0; j < v; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken()) - 1;
                end = Integer.parseInt(st.nextToken()) - 1;
                graph.get(start).add(end);
                graph.get(end).add(start);
            }

            boolean flag = true;
            int[] visit = new int[v];
            Queue<Integer> q = new LinkedList<>();

            for (int j = 0; j < v; j++) {
                if (visit[i] == 0) {
                    q.offer(i);
                    visit[i] = 1;

                    while (!q.isEmpty() && flag) {
                        int cur = q.poll();
                        for (int next : graph.get(cur)) {
                            if (visit[next] == 0) {
                                q.offer(next);
                                visit[next] = visit[cur] * -1;
                            } else if (visit[next] == visit[cur]) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
            }
            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
}
