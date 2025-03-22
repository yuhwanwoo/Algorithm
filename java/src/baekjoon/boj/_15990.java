package baekjoon.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[100001][4];

        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][3] = 1;
        dp[3][2] = 1;
        dp[3][1] = 1;

        for (int i = 4; i < 100001; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
            dp[i][2] = (dp[i - 2][3] + dp[i - 2][1]) % 1000000009;
            dp[i][3] = (dp[i - 3][2] + dp[i - 3][1]) % 1000000009;
        }

        while (t != 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009);
            t--;
        }
    }
}
