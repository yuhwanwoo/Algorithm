package programmers.year2023.lv1;

import java.util.Arrays;

public class _12944 {
    public static void main(String[] args) {

    }

    public static double solution(int[] arr) {
        return Arrays.stream(arr).sum() / (double) arr.length;
    }
}
