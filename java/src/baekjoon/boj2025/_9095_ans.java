package baekjoon.boj2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9095_ans {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // dp[i]는 정수 i를 1, 2, 3의 합으로 나타내는 방법의 수
        int[] dp = new int[11]; // n은 1보다 크거나 같고 11보다 작다 (즉, 1부터 10까지)

        // 초기값 설정
        dp[0] = 1; // 0을 만드는 방법은 1가지 (아무것도 더하지 않는 경우, 점화식을 위해 필요)
        dp[1] = 1; // 1을 만드는 방법: 1

        // dp 배열 채우기
        for (int i = 2; i <= 10; i++) {
            dp[i] += dp[i - 1]; // 1을 더하는 경우
            if (i - 2 >= 0) {
                dp[i] += dp[i - 2]; // 2를 더하는 경우
            }
            if (i - 3 >= 0) {
                dp[i] += dp[i - 3]; // 3을 더하는 경우
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }
}
