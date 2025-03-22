package programmers.year2023.lv1;

import java.util.Arrays;

public class _12935 {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] arr) {

        if (arr.length == 1) {
            return new int[]{-1};
        }

        int minInt = Arrays.stream(arr).min().getAsInt();

        return Arrays.stream(arr).filter(num -> num != minInt)
                .toArray();
    }
}
