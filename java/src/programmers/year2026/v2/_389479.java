package programmers.year2026.v2;

public class _389479 {
    static void main() {
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;
        solution(players, m, k);
    }
    public static int solution(int[] players, int m, int k) {
        int answer = 0;
        int limitCount = m;
        int scaleUpCount = 0;
        for (int i = 0; i < players.length; i++) {
            int need = players[i] / m;
            if (need > limitCount) {
                answer += 1;
            }

        }
        return answer;
    }
}
