package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1445 {
    private static boolean[][] visited;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        map = new char[n][m];

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char charInput = input.charAt(j);
                map[i][j] = charInput;
                if (charInput == 'S') {
                    pq.add(new Node(i, j, 0, 0));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'g') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                            continue;
                        }
                        if (map[nx][ny] != 'F' && map[nx][ny] != 'S' && map[nx][ny] != 'g') {
                            map[nx][ny] = 'b';
                        }
                    }
                }
            }
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visited[now.x][now.y]) {
                continue;
            }
            visited[now.x][now.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == 'F') {
                    System.out.println(now.cnt + " " + now.sideCnt);
                    return;
                }

                if (map[nx][ny] == 'g') {
                    pq.add(new Node(nx, ny, now.cnt + 1, now.sideCnt));
                    continue;
                }

                if (map[nx][ny] == 'b') {
                    pq.add(new Node(nx, ny, now.cnt, now.sideCnt + 1));
                    continue;
                }

                pq.add(new Node(nx, ny, now.cnt, now.sideCnt));
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt;
        int sideCnt;

        public Node(int x, int y, int cnt, int sideCnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.sideCnt = sideCnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt > o.cnt) {
                return 1;
            } else if (this.cnt == o.cnt) {
                return (this.sideCnt - o.sideCnt);
            }
            return -1;
        }
    }
}
