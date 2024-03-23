package programmers.lv2;

public class _154538 {
    public static void main(String[] args) {
        solution(10, 40, 5);
    }

    public static int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y + 1];

        for (int i = 0; i <= y; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = x; i <= y; i++) {
            if (i + n <= y) {

            }

            if (i * 2 <= y) {

            }

            if (i * 3 <= y) {

            }
        }

        return answer;
    }
}
