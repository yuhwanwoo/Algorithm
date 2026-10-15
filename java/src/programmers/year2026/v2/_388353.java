package programmers.year2026.v2;

import java.util.LinkedList;
import java.util.Queue;

public class _388353 {
    static int total;
    static char[][] map;
    static char[][] visited;
    static Queue<Integer> xList = new LinkedList<>();
    static Queue<Integer> yList = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n;
    static int m;

    static void main() {
        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = {"A", "BB", "A"};
        solution(storage, requests);
    }

    public static int solution(String[] storage, String[] requests) {
        total = storage[0].length() * storage.length;
        n = storage.length;
        m = storage[0].length();
        for (int i = 0; i < storage.length; i++) {
            map[i] = storage[i].toCharArray();
        }

        for (int i = 0; i < requests.length; i++) {
            if (requests[i].length() == 2) {
                useCrane(requests[i].charAt(0));
            } else {
                useTruck(requests[i].charAt(0));
            }
        }
        return total;
    }
    private static void useCrane(char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == target) {
                    total--;
                    map[i][j] = '-';
                }
            }
        }


    }

    private static void useTruck(char target) {
        visited = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, target);
            }
        }
        for (int i = 0; i < xList.size(); i++) {
            Integer x = xList.poll();
            Integer y = xList.poll();
            total--;
            map[x][y] = '-';
        }
    }

    private static void dfs(int x, int y, char target) {
        if (map[x][y] == target) {
            xList.add(x);
            yList.add(y);
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ()

        }
    }
}
