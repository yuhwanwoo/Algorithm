package programmers.year2023.lv1;

import java.util.Arrays;
import java.util.Collections;

public class _12910 {
    public static void main(String[] args) {
        int[] arr = {5,9,7,10};
        int divisor = 5;
        solution(arr, divisor);
    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(num -> num % divisor == 0)
                .sorted().toArray();
        return answer.length != 0 ? answer : new int[]{-1};
    }
}
