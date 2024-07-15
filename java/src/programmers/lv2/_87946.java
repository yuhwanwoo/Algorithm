package programmers.lv2;

public class _87946 {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
    }

    public static int solution(int k, int[][] dungeons) {
        int answer = -1;

        return answer;
    }

    private static int dfs(int depth, int[][] dungeons, int count) {
        if (depth == dungeons.length) {
            return count;
        }

        return dfs(depth + 1, dungeons, count);
    }
}
