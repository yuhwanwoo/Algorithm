package programmers.year2026.v2;

import java.util.ArrayList;

public class _388353 {
    static int total;
    static char[][] map;
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

    }

    private static void useTruck(char target) {
        for (int i = 0; i < map.length; i++) {

        }
    }

    private static void dfs(int x, int y, char target) {
        if (map[x][y] == target) {
            total--;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
        }
    }
}
