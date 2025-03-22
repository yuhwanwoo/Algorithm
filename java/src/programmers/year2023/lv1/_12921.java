package programmers.year2023.lv1;

public class _12921 {
    public static void main(String[] args) {
        int n = 10;
        solution(n);
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (validateNumber(i)) {
                answer += 1;
            }
        }
        return answer;
    }

    public static boolean validateNumber(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
