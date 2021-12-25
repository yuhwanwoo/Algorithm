package test.ztest;

public class test01 {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(solution(n));
    }

    private static long solution(int n) {
        long answer = 0;
        for (int i = 1; i <= 1000000; i++) {
            int share = i / n;
            int mod = i % n;

            if (share >= n) {
                break;
            } else {
                if (share == mod) {
                    answer += i;
                }
            }

        }
        return answer;
    }
}
