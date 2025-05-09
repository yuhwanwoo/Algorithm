package leetcode;

import java.util.HashMap;

public class IntegerToRoman {
    public static void main(String[] args) {
        /*
        1 -> I
        2 -> II
        3 -> III
        4 -> IV
        5 ->
         */
        intToRoman(3749);
        intToRoman(1994);
    }
    public static String intToRoman(int num) {
        String answer = "";

        if (num % 10 == 4) {
            answer = "IV" + answer;
        } else if (num % 10 >= 5 && num % 10 < 9){
            answer = "I".repeat(num % 10 - 5) + answer;
            answer = "V" + answer;
        } else if (num % 10 == 9){
            answer = "IX" + answer;
        } else {
            answer = "I".repeat(num % 10) + answer;
        }

        num = num / 10;

        if (num % 10 == 4) {
            answer = "XL" + answer;
        } else if (num % 10 >= 5 && num % 10 < 9){
            answer = "X".repeat(num % 10 - 5) + answer;
            answer = "L" + answer;
        } else if (num % 10 == 9){
            answer = "XC" + answer;
        } else {
            answer = "X".repeat(num % 10) + answer;
        }

        num = num / 10;

        if (num % 10 == 4) {
            answer = "CD" + answer;
        } else if (num % 10 >= 5 && num % 10 < 9){
            answer = "C".repeat(num % 10 - 5) + answer;
            answer = "D" + answer;
        } else if (num % 10 == 9){
            answer = "CM" + answer;
        } else {
            answer = "C".repeat(num % 10) + answer;
        }

        num = num / 10;
        answer = "M".repeat(num % 10) + answer;
        System.out.println("answer = " + answer);

        return answer;
    }
}
