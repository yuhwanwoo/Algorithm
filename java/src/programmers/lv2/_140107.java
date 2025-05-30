package programmers.lv2;

public class _140107 {
    public static void main(String[] args) {
        solution(2, 4);
        solution(1, 5);
    }

    public static long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i += k) {
            answer += (long) (Math.sqrt((long) d * d - (long) i * i) / k + 1);
        }
        return answer;
    }
}
