package programmers.lv2;

public class _12902 {
    public static void main(String[] args) {
        solution(8);
    }

    public static int solution(int n) {
        if (n % 2 == 1) {
            return 0;
        }
        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i < n + 1; i += 2) {
            dp[i] = (dp[i - 2] * 3) % 1000000007;
            for (int j = 4; j <= i; j += 2) {
                dp[i] += (dp[i - j] * 2) % 1000000007;
            }
            dp[i] %= 1000000007;
        }

        return (int) dp[n];
    }
}
