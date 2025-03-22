package programmers.year2023.lv1;

import java.util.HashMap;

public class _42576 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        solution(participant, completion);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            String now = participant[i];
            if (!map.containsKey(now)) {
                map.put(now, 0);
            }
            map.put(now, map.get(now) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            String clearMember = completion[i];
            map.put(clearMember, map.get(clearMember) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
