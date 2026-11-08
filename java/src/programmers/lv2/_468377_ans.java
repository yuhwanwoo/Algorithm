package programmers.lv2;

public class _468377_ans {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        int bundleCount = n - 1;
        int min = Integer.MAX_VALUE;
        for (int mask = 0; mask < (1 << bundleCount); mask++) {
            int[] cnt = new int[n + 1];
            int price = 0;
            for (int k = 0; k < bundleCount; k++) {
                if ((mask & (1 << k)) == 0) continue;
                price += hint[k][0];
                for (int j = 1; j < hint[k].length; j++) {
                    cnt[hint[k][j]]++;
                }
            }
            int total = price;
            for (int i = 1; i <= n; i++) {
                int used = Math.min(cnt[i], n - 1);
                total += cost[i - 1][used];
            }
            min = Math.min(min, total);
        }
        return min;
    }
}
