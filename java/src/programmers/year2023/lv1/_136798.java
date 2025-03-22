package programmers.year2023.lv1;

public class _136798 {
    public static void main(String[] args) {
//        int number = 5;
//        int limit = 3;
//        int power = 2;

        int number = 10;
        int limit = 3;
        int power = 2;

        solution(number, limit, power);
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int cnt = 0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (j != (i / j) ) {
                        cnt++;
                    }
                    cnt++;
                }
            }
            if (cnt > limit) {
                answer += power;
            } else {
                answer += cnt;
            }
        }

        return answer;
    }
}
