package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_1 {
    private static HashMap<Character, List<String> > map = new HashMap<>();
    public static void main(String[] args) {
        letterCombinations("23");
        letterCombinations("");
        letterCombinations("2");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));


        dfs(digits, "", answer);
        System.out.println("answer = " + answer);
        return answer;
    }

    private static void dfs(String digits, String now, List<String> answer) {
        if (now.length() == digits.length()) {
            if (now.length() != 0) {
                answer.add(now);
            }
            return;
        }

        List<String> strings = map.get(digits.charAt(now.length()));
        for (int i = 0; i < strings.size(); i++) {
            String nowChar = strings.get(i);
            dfs(digits, now + nowChar, answer);
        }
    }
}
