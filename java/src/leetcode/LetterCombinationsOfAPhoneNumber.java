package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    static List<String> characters = new ArrayList<>(10);
    public static void main(String[] args) {

    }

    public static List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if(digits.length() == 0)
            return answer;

        characters.add("");characters.add("");
        characters.add("abc");
        characters.add("def");
        characters.add("ghi");
        characters.add("jkl");
        characters.add("mno");
        characters.add("pqrs");
        characters.add("tuv");
        characters.add("wxyz");
        dfs(digits, "", answer);
        return answer;
    }


    void dfs(String digits, String msg, List<String> answer){
        if(msg.length() == digits.length()){
            answer.add(msg);
            return;
        }

        int nextDigit = Integer.parseInt("" + digits.charAt(msg.length()));
        String nextDigitChars = characters.get(nextDigit);
        for(int i = 0; i < nextDigitChars.length(); ++i){
            char alphabet = nextDigitChars.charAt(i);
            dfs(digits, msg + alphabet, answer);
        }
    }

}
