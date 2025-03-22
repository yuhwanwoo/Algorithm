package programmers.year2023.lv2;

public class _181187 {
    public static void main(String[] args) {
        int r1 = 999999;
        int r2 = 1000000;
        System.out.println("solution(r1, r2) = " + solution(r1, r2));;
    }

    public static long solution(int r1, int r2) {
        long answer = 0;

        for (int i = 1; i <= r2; i++) {
            int start = (int) Math.ceil(Math.sqrt((long) r1 * r1 - (long) i * i));
            int end = (int) Math.floor(Math.sqrt((long) r2 * r2 - (long) i * i));

            answer += end - start + 1;
        }

        return answer * 4;
    }
}
