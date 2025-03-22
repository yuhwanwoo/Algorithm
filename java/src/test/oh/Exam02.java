package test.oh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Exam02 {
    public static void main(String[] args) {
        solution("bu");
    }

    private static String solution(String str) {
        HashMap<String, Boolean> keyMap = new HashMap<>();
        keyMap.put("a", true);
        keyMap.put("e", true);
        keyMap.put("i", true);
        keyMap.put("o", true);
        keyMap.put("u", true);

        Stack<String> vowels = new Stack<>();
        String[] splitStr = str.split("");
        for (String input : splitStr) {
            if (keyMap.containsKey(input)) {
                vowels.add(input);
            }
        }
        ArrayList<String> answer = new ArrayList<>();

        for (String input : splitStr) {
            if (keyMap.containsKey(input)) {
                answer.add(vowels.pop());
            } else {
                answer.add(input);
            }
        }
        return String.join("", answer);
    }
}
