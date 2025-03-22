package programmers.lv2;

public class _140107_ans {
    public static void main(String[] args) {
        solution(2, 4);
        solution(1, 5);
    }

    public static long solution(int k, int d) {
        long answer = 0;

        for (int x = 0; x <= d; x += k) {
            int y = (int) Math.sqrt((long) d * d - (long) x * x);
            answer += (y / k + 1);
        }

        return answer;
    }
}
