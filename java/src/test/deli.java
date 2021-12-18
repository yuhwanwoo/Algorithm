package test;

public class deli {
    public static void main(String[] args) {
        int n = 16;

        int[] dp = new int[n + 8];

        dp[0] = -1;
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;

        for(int i = 6; i < n + 1; i++) {
            int tmp = 1000000000;
            if(dp[i - 5] == -1 && dp[i - 3] == -1) {
                dp[i] = -1;
                continue;
            }
            if(dp[i - 5] != -1) {
                tmp = Math.min(tmp, dp[i - 5] + dp[5]);
            }
            if(dp[i - 3] != -1) {
                tmp = Math.min(tmp, dp[i - 3] + dp[3]);
            }
            dp[i] = tmp;
        }

        System.out.println(dp[n]);
    }
}
