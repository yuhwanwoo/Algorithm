package programmers.lv2;

public class _181187 {
    public static void main(String[] args) {
        solution(2, 3);
    }

    public static long solution(int r1, int r2) {
        long answer = 0;
        /*
        x^2 + y^2 = r1^2
        y = (r1^2 - x^2)^0.5
         */
        for (int i = 1; i <= r2; i++) {
            long maxPoint = (long) Math.floor(Math.sqrt(((double) r2 * r2) - ((double)i * i)));
            long minPoint = (long) Math.ceil(Math.sqrt(((double)r1 * r1) - ((double)i * i)));

            answer += (maxPoint - minPoint + 1);
        }

        return answer * 4;
    }
}
