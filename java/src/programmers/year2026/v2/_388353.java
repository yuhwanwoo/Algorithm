package programmers.year2026.v2;

public class _388353 {
    static int total;
    static char[][] map;
    static boolean[][] visited;
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
        map = new char[n][m];
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
        System.out.println("total = " + total);
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
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if(!visited[i][0]) dfs(i, 0, target);
            if(!visited[i][m - 1]) dfs(i, m - 1, target);
        }
        for(int i = 0; i < m; i++){
            if(!visited[0][i]) dfs(0, i, target);
            if(!visited[n - 1][i]) dfs(n - 1, i, target);
        }
    }

    private static void dfs(int x, int y, char target) {
        visited[x][y] = true;
        if (map[x][y] == '-') {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                        !visited[nx][ny]) {
                    dfs(nx, ny, target);
                }
            }
        }

        if (map[x][y] == target) {
            total--;
            map[x][y] = '-';
        }
    }
}
