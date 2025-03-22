package programmers.year2023.lv1;

import java.util.HashMap;

public class _142068 {
    public static void main(String[] args) {
//        String s = "banana";

        String s = "foobar";

        solution(s);

    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (!map.containsKey(now)) {
                answer[i] = -1;
                map.put(now, i);
            } else {
                answer[i] = i - map.get(now);
                map.put(now, i);
            }
        }
        return answer;
    }
}
