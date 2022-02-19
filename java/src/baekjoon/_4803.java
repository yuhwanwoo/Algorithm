package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4803 {

    static ArrayList<ArrayList<Integer>> arr;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int count = 0;
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            visited = new boolean[n + 1];

            arr = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                arr.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr.get(a).add(b);
                arr.get(b).add(a);
            }

            for (int i = 1; i < n + 1; i++) {
                if (visited[i]) {
                    continue;
                }
                dfs(i);
            }




            t++;
        }
    }

    public static boolean dfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < arr.get(now).size(); i++) {
                int next = arr.get(now).get(i);
                if (visited[next]) {
                    return false;
                }
            }
        }
        return true;
    }
}
