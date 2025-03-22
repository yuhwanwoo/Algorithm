package test.forty;

import java.util.ArrayList;
import java.util.HashMap;

public class Test01 {
    private static HashMap<Character, Integer> firstLineMap = new HashMap<>();
    private static HashMap<Character, Integer> secondLineMap = new HashMap<>();
    private static HashMap<Character, Integer> thirdLineMap = new HashMap<>();
    private static boolean[] visited = new boolean[3];
    public static void main(String[] args) {
        String[] card = {"ABACDEFG", "NOPQRSTU", "HIJKLKMM"};
        String[] word = {"GPQM", "GPMZ", "EFU", "MMNA"};

        solution(card, word);
    }

    public static String[] solution(String[] card, String[] word) {
        String[] answer = {};
        ArrayList<String> answerList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            char firstLine = card[0].charAt(i);
            if (!firstLineMap.containsKey(firstLine)) {
                firstLineMap.put(firstLine, 0);
            }
            firstLineMap.put(firstLine, firstLineMap.get(firstLine) + 1);
            char secondLine = card[1].charAt(i);

            if (!secondLineMap.containsKey(secondLine)) {
                secondLineMap.put(secondLine, 0);
            }
            secondLineMap.put(secondLine, secondLineMap.get(secondLine) + 1);
            char thirdLine = card[2].charAt(i);

            if (!thirdLineMap.containsKey(thirdLine)) {
                thirdLineMap.put(thirdLine, 0);
            }
            thirdLineMap.put(thirdLine, thirdLineMap.get(thirdLine) + 1);
        }

        for (int i = 0; i < word.length; i++) {
            if (dfs(word[i], 0)) {
                answerList.add(word[i]);
            }
        }

        return answerList.isEmpty() ? new String[]{"-1"} : answerList.toArray(new String[0]);
    }

    private static boolean dfs(String inputWord, int start) {
        if (start == inputWord.length()) {
            if (visited[0] && visited[1] && visited[2]) {
                return true;
            }
            return false;
        }
        boolean answer;
        char now = inputWord.charAt(start);
        if (firstLineMap.containsKey(now) && firstLineMap.get(now) > 0) {
            firstLineMap.put(now, firstLineMap.get(now) - 1);
            visited[0] = true;
            answer = dfs(inputWord, start + 1);
            firstLineMap.put(now, firstLineMap.get(now) + 1);
            visited[0] = false;
        } else if (secondLineMap.containsKey(now) && secondLineMap.get(now) > 0) {
            secondLineMap.put(now, secondLineMap.get(now) - 1);
            visited[1] = true;
            answer = dfs(inputWord, start + 1);
            secondLineMap.put(now, secondLineMap.get(now) + 1);
            visited[1] = false;
        } else if (thirdLineMap.containsKey(now) && thirdLineMap.get(now) > 0) {
            thirdLineMap.put(now, thirdLineMap.get(now) - 1);
            visited[2] = true;
            answer = dfs(inputWord, start + 1);
            thirdLineMap.put(now, thirdLineMap.get(now) + 1);
            visited[2] = false;
        } else {
            answer = false;
        }
        return answer;
    }
}
