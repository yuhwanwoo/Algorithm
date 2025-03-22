package programmers.year2023.lv1;

import java.util.Arrays;
import java.util.Collections;

public class _12917 {
    public static void main(String[] args) {
        String s = "bcdefgZ";
        System.out.println(solution(s));

    }

    public static String solution(String s) {
        String[] split = s.split("");
        Arrays.sort(split, Collections.reverseOrder());
        return String.join("", split);
    }
}