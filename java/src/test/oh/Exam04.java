package test.oh;

import java.util.ArrayList;
import java.util.List;

public class Exam04 {
    public static void main(String[] args) {
        solution(new String[]{"BucketPlace"}, "BP");
        solution(new String[]{"BucketPlace"}, "BuPl");
        solution(new String[]{"BucketList"}, "BP");
        solution(new String[]{"Bu"}, "B");
        solution(new String[]{"b"}, "b");
        solution(new String[]{"BB"}, "B");
    }

    public static List<Boolean> solution(String[] inputs, String pattern) {
        List<Boolean> answer = new ArrayList<>();
        for (String input : inputs) {
            answer.add(validatePattern(input, pattern));
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    private static boolean validatePattern(String input, String pattern) {
        String result = "";
        int j = 0;

        for (int i = 0; i < input.length(); i++) {
            char inputNow = input.charAt(i);
            if (result.equals(pattern)) {
                if (Character.isUpperCase(inputNow)) {
                    return false;
                }
            }
            while (j < pattern.length()) {
                char patternNow = pattern.charAt(j);
                if (inputNow == patternNow) {
                    result += inputNow;
                    j++;
                    break;
                } else {
                    if (Character.isUpperCase(inputNow)) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }

        return result.equals(pattern);
    }
}
