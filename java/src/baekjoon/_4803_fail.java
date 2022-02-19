package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _4803_fail {

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

            System.out.println(arr);

            for (int i = 1; i < n + 1; i++) {
                System.out.println(Arrays.toString(visited));
                if (visited[i]) {
                    continue;
                }
                if(dfs(i)) {
                    count += 1;
                    System.out.println("i:" + i +", count:" + count);
                }
            }

            t++;
        }
    }

    public static boolean dfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            visited[start] = true;
            for (int i = 0; i < arr.get(now).size(); i++) {
                int next = arr.get(now).get(i);
                System.out.println("now:" + now + ", next:" + next);
                if (now == next) {
                    continue;
                }
                if (visited[next]) {
                    return false;
                }
                visited[next] = true;
                q.add(next);
            }
        }
        return true;
    }
}
