package programmers.year2023.lv1;

public class _77884 {
    public static void main(String[] args) {
//        int left = 13;
//        int right = 17;

        int left = 24;
        int right = 27;

        solution(left, right);
    }

    public static int solution(int left, int right) {
        int evenCnt = 0;
        int oddCnt = 0;

        for (int i = left; i <= right; i++) {
            if (checkCnt(i)) {
                evenCnt += i;
            } else {
                oddCnt += i;
            }
        }

        return evenCnt - oddCnt;
    }

    private static boolean checkCnt(int number) {
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (i != number / i) {
                    cnt++;
                }
                cnt++;
            }
        }
        return cnt % 2 == 0;
    }
}
