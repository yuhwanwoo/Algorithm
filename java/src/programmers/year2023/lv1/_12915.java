package programmers.year2023.lv1;

import java.util.Arrays;

public class _12915 {
    public static void main(String[] args) {

    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            }
            return o1.charAt(n) - o2.charAt(n);
        });
        return strings;
    }
}
