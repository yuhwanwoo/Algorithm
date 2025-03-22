package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18232 {

    static int[] dirs = { 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        int min = 100000;

        Queue<Pair_18232> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q.offer(new Pair_18232(s, 0));
        visited[s] = true;

        while (!q.isEmpty()) {
            Pair_18232 cn = q.poll();

            if (cn.x == e) {
                min = cn.cnt;
                q.clear();
                break;
            }

            // 텔레포트로 이동하기
            for (int next : arr[cn.x]) {
                if (!visited[next]) {
                    q.offer(new Pair_18232(next, cn.cnt + 1));
                    visited[next] = true;
                }
            }

            // +1, -1로 이동하기
            for (int d = 0; d < 2; d++) {
                int nx = cn.x + dirs[d];

                if (nx < 0 || nx > n) {
                    continue;
                }

                if (!visited[nx]) {
                    q.offer(new Pair_18232(nx, cn.cnt + 1));
                    visited[nx] = true;
                }
            }
        }

        System.out.println(min);


    }

    static class Pair_18232 {
        int x;
        int cnt;

        public Pair_18232(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }


}
