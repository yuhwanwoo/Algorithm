package programmers.year2023.lv1;

import java.util.HashMap;

public class _133499 {
    public static void main(String[] args) {
//        String[] babbling = {"aya", "yee", "u", "maa"};
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        System.out.println("solution(babbling) = " + solution(babbling));
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        HashMap<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < babbling.length; i++) {
            String now = babbling[i];
            map.put("aya", false);
            map.put("ye", false);
            map.put("woo", false);
            map.put("ma", false);
            while (now.length() != 0) {
                if (now.startsWith("aya")) {
                    if (map.get("aya")) {
                        break;
                    }
                    now = now.replaceFirst("aya", "");
                    map.put("aya", true);
                    map.put("ye", false);
                    map.put("woo", false);
                    map.put("ma", false);
                } else if (now.startsWith("ye")) {
                    if (map.get("ye")) {
                        break;
                    }
                    now = now.replaceFirst("ye", "");
                    map.put("aya", false);
                    map.put("ye", true);
                    map.put("woo", false);
                    map.put("ma", false);
                } else if (now.startsWith("woo")) {
                    if (map.get("woo")) {
                        break;
                    }
                    now = now.replaceFirst("woo", "");
                    map.put("aya", false);
                    map.put("ye", false);
                    map.put("woo", true);
                    map.put("ma", false);
                } else if (now.startsWith("ma")) {
                    if (map.get("ma")) {
                        break;
                    }
                    now = now.replaceFirst("ma", "");
                    map.put("aya", false);
                    map.put("ye", false);
                    map.put("woo", false);
                    map.put("ma", true);
                } else {
                    break;
                }

                if (now.length() == 0) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
