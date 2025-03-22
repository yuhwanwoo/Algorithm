package programmers.year2023.lv1;

import java.util.HashMap;

public class _155652 {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        solution(s, skip, index);
    }

    public static String solution(String s, String skip, int index) {
        String answer = "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < skip.length(); i++) {
            char skipChar = skip.charAt(i);
            map.put(skipChar, 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            int seq = now - 'a';
            int cnt = 0;
            while (cnt < index) {
                seq += 1;
                seq = (seq % 26);
                char tmpChar = (char) ('a' + seq);
                if (!map.containsKey(tmpChar)) {
                    cnt += 1;
                }
            }
            answer += (char) ('a' + seq);
        }

        return answer;
    }
}
