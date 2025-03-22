package programmers.year2023.lv1;

import java.util.Arrays;

public class _86051 {
    public static void main(String[] args) {

    }

    public static int solution(int[] numbers) {
        int answer = 0;
        int[] chk = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            chk[number] = 1;
        }

        for (int i = 0; i < 10; i++) {
            if (chk[i] == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
