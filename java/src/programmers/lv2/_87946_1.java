package programmers.lv2;

public class _87946_1 {
    private static boolean[] visited;
    private static int answer = -1;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        solution(k, dungeons);
    }

    public static int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);

        return answer;
    }

    private static void dfs(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                k -= dungeons[i][1];
                dfs(k, dungeons, count + 1);
                visited[i] = false;
                k += dungeons[i][1];
            }
        }
    }
}