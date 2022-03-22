package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14430_fail {
    static int[][] graph, ans;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                graph[i][j] = input;
                ans[i][j] = input;
            }
        }
        bfs();

        System.out.println(ans[n - 1][m - 1]);
    }

    private static void bfs() {
        Queue<Node_14430> q = new LinkedList<>();
        q.add(new Node_14430(0, 0));

        while (!q.isEmpty()) {
            Node_14430 now = q.poll();
            int cx = now.x;
            int cy = now.y;
            for (int i = 0; i < 2; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= n || ny >= m) {
                    continue;
                }
                ans[nx][ny] = ans[cx][cy] + graph[nx][ny];
                q.add(new Node_14430(nx, ny));
            }
        }
    }

    static class Node_14430 {
        int x;
        int y;

        public Node_14430(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
