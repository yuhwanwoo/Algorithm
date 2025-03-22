package programmers.year2023.lv1;

public class _12934 {
    public static void main(String[] args) {

    }

    public static long solution(long n) {
        long answer = -1;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0 && i == n / i) {
                answer = i;
                return (answer + 1) * (answer + 1);
            }
        }

        return answer;
    }
}
