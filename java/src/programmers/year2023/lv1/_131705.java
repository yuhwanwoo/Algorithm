package programmers.year2023.lv1;

import java.util.Arrays;

public class _131705 {
    static int[] output = new int[3];
    static int answer = 0;

    public static void main(String[] args) {
//        int[] number = {-2, 3, 0, 2, -5};
        int[] number = {-3, -2, -1, 0, 1, 2, 3};

        solution(number);
        System.out.println("answer = " + answer);
    }

    public static int solution(int[] number) {
        combinations(0, 0, number);
        return answer;
    }

    private static void combinations(int depth, int start, int[] number) {
        if (depth == 3) {
            if (Arrays.stream(output).sum() == 0) {
                answer += 1;
            }
            return;
        }

        for (int i = start; i < number.length; i++) {
            output[depth] = number[i];
            combinations(depth + 1, i + 1, number);
        }
    }
}
