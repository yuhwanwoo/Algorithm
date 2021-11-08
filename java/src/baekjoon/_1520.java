package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1520 {
    static int m;
    static int n;
    static int[][] arr;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = -1;
            }
        }

    }

    public static int dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (visited[x][y] !=  -1) {

        }

        return visited[x][y];
    }
}
