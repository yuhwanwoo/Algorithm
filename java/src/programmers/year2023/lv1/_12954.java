package programmers.year2023.lv1;

public class _12954 {
    public static void main(String[] args) {

    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 1; i <= n; i++) {
            answer[i - 1] = (long) x * i;
        }
        return answer;
    }
}