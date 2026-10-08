package programmers.year2026.v2;

public class _388352 {
    private static int answer = 0;
    static boolean[] visited;
    static void main() {
        int n = 10;
        int[][] q = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {3, 7, 8, 9, 10},
                {2, 5, 7, 9, 10},
                {3, 4, 5, 6, 7}
        };
        int[] ans = {2, 3, 4, 3, 3};
        solution(n, q, ans);
    }

    public static int solution(int n, int[][] q, int[] ans) {
        visited = new boolean[n];

        return answer;
    }

    private static void dfs(int depth, int[][] q, int[] ans) {
        if (depth == q.length) {
            return;
        }
        for (int i = 0; i < q[0].length; i++) {
            int now = q[depth][i];
            if (!visited[now]) {
                visited[now] = true;
            }
        }
    }


}
