package programmers.year2026.v2;

public class _389479_ans {
    static void main() {

    }

    public static int solution(int[] players, int m, int k) {
        int n = players.length;
        int[] shutDownSchedule = new int[n + k]; // t+k 시점에 반납될 서버 수
        int runningServers = 0;   // 지금 돌고 있는 서버 수
        int totalAdded = 0;   // 총 증설된 서버 수(최종 값)

        for (int t = 0; t < n; t++) {
            // k 시간이 지난 후 반납될 서버 제거
            runningServers -= shutDownSchedule[t];

            // 추가 서버 수
            int requiredServers = players[t] / m;


            //부족한 만큼 증설
            if (runningServers < requiredServers) {
                int add = requiredServers - runningServers;
                totalAdded     += add;
                runningServers += add;

                // k 시간 후 서버 반납
                if (t + k < shutDownSchedule.length) {
                    shutDownSchedule[t + k] += add;
                }
            }
        }
        return totalAdded;
    }

}
