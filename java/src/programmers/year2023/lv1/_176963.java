package programmers.year2023.lv1;

import java.util.HashMap;

public class _176963 {
    public static void main(String[] args) {

    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (map.containsKey(photo[i][j])) {
                    score += map.get(photo[i][j]);
                }
            }
            answer[i] = score;
        }

        return answer;
    }
}
