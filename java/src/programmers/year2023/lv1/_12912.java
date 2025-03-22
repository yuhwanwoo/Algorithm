package programmers.year2023.lv1;

public class _12912 {
    public static void main(String[] args) {

    }

    public static long solution(int a, int b) {
        long answer = 0;
        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);
        for (int i = smaller; i <= bigger; i++) {
            answer += i;
        }
        return answer;
    }
}
