package programmers.year2026.v2;

public class _389479 {
    static void main() {
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;
        solution(players, m, k);

        int[] players1 = {0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0};
        int m1 = 5;
        int k1 = 1;
        solution(players1, m1, k1);
    }
    public static int solution(int[] players, int m, int k) {
        /*
         m 명 늘어날 때마다 1개 증설 필요
         k가 증설된 운영 시간
         */

        int n = players.length;
        int answer = 0;
        int runningServer = 0;
        int[] shutDownSchedule = new int[n + k];
        for (int i = 0; i < n; i++) {
            runningServer -= shutDownSchedule[i];

            int need = players[i] / m;
            if (need > runningServer) {
                int upCount = need - runningServer;
                answer += upCount;
                runningServer += upCount;
                shutDownSchedule[i + k] = upCount;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
