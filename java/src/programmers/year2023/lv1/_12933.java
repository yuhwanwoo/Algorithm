package programmers.year2023.lv1;

import java.util.Arrays;

public class _12933 {
    public static void main(String[] args) {
        long n = 118372;
        solution(n);
    }
    public static long solution(long n) {
        String answerStr = "";
        String[] strings = String.valueOf(n).split("");
        Arrays.sort(strings);

        for (int i = strings.length - 1; i >= 0; i--) {
            answerStr += strings[i];
        }

        return Long.parseLong(answerStr);
    }
}
