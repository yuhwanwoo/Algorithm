package baekjoon.boj2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _17086 {
    private static int[][] arr;
    private static int n;
    private static int m;
    private static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {

                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    answer = Math.max(bfs(i, j), answer);
                }

            }
        }

        System.out.println(answer);
    }

    private static int bfs(int i, int j) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j, 0});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            for (int direction = 0; direction < 8; direction++) {
                int nx = top[0] + dx[direction];
                int ny = top[1] + dy[direction];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
                    continue;
                }
                if (arr[nx][ny] > 0) {
                    return top[2] + 1;
                }
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, top[2] + 1});
            }
        }
        return 0;
    }
}
