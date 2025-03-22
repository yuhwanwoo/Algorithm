package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18430 {
    static int n;
    static int m;
    static int[][] graph;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count) {
        if (x == n - 1 && y == m) {
            answer = Math.max(answer, count);
            return;
        }
        if (x == n) {
            return;
        }
        if (y == m) {
            dfs(x + 1, 0, count);
            return;
        }

        // 첫 번째
        if (y - 1 >= 0 && x + 1 < n && !visited[x][y] && !visited[x][y - 1] && !visited[x + 1][y]) {
            visited[x][y] = true;
            visited[x][y - 1] = true;
            visited[x + 1][y] = true;
            dfs(x, y + 1, count + graph[x][y] * 2 + graph[x][y - 1] + graph[x + 1][y]);
            visited[x][y] = false;
            visited[x][y - 1] = false;
            visited[x + 1][y] = false;
        }

        // 두 번째
        if (y - 1 >= 0 && x - 1 >= 0 && !visited[x][y] && !visited[x][y - 1] && !visited[x - 1][y]) {
            visited[x][y] = true;
            visited[x][y - 1] = true;
            visited[x - 1][y] = true;
            dfs(x, y + 1, count + graph[x][y] * 2 + graph[x][y - 1] + graph[x - 1][y]);
            visited[x][y] = false;
            visited[x][y - 1] = false;
            visited[x - 1][y] = false;
        }

        // 세 번째
        if (y + 1 < m && x - 1 >= 0 && !visited[x][y] && !visited[x][y + 1] && !visited[x - 1][y]) {
            visited[x][y] = true;
            visited[x][y + 1] = true;
            visited[x - 1][y] = true;
            dfs(x, y + 1, count + graph[x][y] * 2 + graph[x][y + 1] + graph[x - 1][y]);
            visited[x][y] = false;
            visited[x][y + 1] = false;
            visited[x - 1][y] = false;
        }

        // 네 번째
        if (y + 1 < m && x + 1 < n && !visited[x][y] && !visited[x][y + 1] && !visited[x + 1][y]) {
            visited[x][y] = true;
            visited[x][y + 1] = true;
            visited[x + 1][y] = true;
            dfs(x, y + 1, count + graph[x][y] * 2 + graph[x][y + 1] + graph[x + 1][y]);
            visited[x][y] = false;
            visited[x][y + 1] = false;
            visited[x + 1][y] = false;
        }

        dfs(x, y + 1, count);
    }
}
