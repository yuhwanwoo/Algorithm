package programmers.lv2;

public class _87946_2 {
    private static boolean[] visited;
    private static int answer;
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        solution(k, dungeons);
    }

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return answer;
    }

    private static void dfs(int[][] dungeons, int restEnergy, int count) {
        answer = Math.max(answer, count);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= restEnergy) {
                visited[i] = true;
                dfs(dungeons, restEnergy - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}
