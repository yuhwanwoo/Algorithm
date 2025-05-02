package leetcode;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "III";
        romanToInt(s);
    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put("I", 1);
        romanToIntMap.put("V", 5);
        romanToIntMap.put("X", 10);
        romanToIntMap.put("L", 50);
        romanToIntMap.put("C", 100);
        romanToIntMap.put("D", 500);
        romanToIntMap.put("M", 1000);

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String now = s.substring(i, i + 1);

            if (i == s.length() - 1) {
                answer += romanToIntMap.get(now);
                break;
            }

            String next = s.substring(i + 1, i + 2);

            if (romanToIntMap.get(now) < romanToIntMap.get(next)) {
                answer -= romanToIntMap.get(now);
            } else{
                answer += romanToIntMap.get(now);
            }

        }

        return answer;
    }
}
