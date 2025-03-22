package programmers.year2023.lv1;

import java.util.HashMap;

public class _160586 {
    public static void main(String[] args) {
//        String[] keymap = {"ABACD", "BCEFD"};
//        String[] targets = {"ABCD","AABB"};

//        String[] keymap = {"AA"};
//        String[] targets = {"B"};

        String[] keymap = {"AGZ", "BSSS"};
        String[] targets = {"ASA","BGZ"};
        solution(keymap, targets);
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char now = keymap[i].charAt(j);
                if (!map.containsKey(now)) {
                    map.put(now, j + 1);
                }
                if (map.get(now) > j + 1) {
                    map.put(now, j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int cnt = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char targetChar = targets[i].charAt(j);
                if (!map.containsKey(targetChar)) {
                    cnt = -1;
                    break;
                }
                cnt += map.get(targetChar);
            }
            answer[i] = cnt;
        }

        return answer;
    }
}
