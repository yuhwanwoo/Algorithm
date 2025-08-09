package hackerrank;

import java.util.Arrays;

public class biggerIsGreater_ans {
    public static void main(String[] args) {
        System.out.println("solve(\"abc\") = " + solve("bac"));
        System.out.println("solve(\"bca\") = " + solve("bca"));
        System.out.println("solve(\"bacaa\") = " + solve("bacaa"));
        System.out.println("solve(\"baacaa\") = " + solve("baacaa"));
    }

    public static String solve(String input) {
        char[] chars = input.toCharArray();
        int lastIdx = chars.length - 1;
        int minVal = Integer.MAX_VALUE;
        int minIdx = Integer.MAX_VALUE;
        int turningPoint = 0;
        String result = input;
        for (int i = lastIdx; i > 0; i--) {
            /** 작아지는 구간을 찾는다. */
            if (chars[i] > chars[i - 1]) {
                turningPoint = i - 1;
                for (int k = i; k <= lastIdx; k++) {
                    if (chars[turningPoint] < chars[k] && minVal > chars[k]) {
                        minVal = chars[k];
                        minIdx = k;
                    }
                }
                swap(chars, turningPoint, minIdx);
                Arrays.sort(chars, turningPoint + 1, lastIdx + 1);
                result = new String(chars);
                break;
            }

        }

        return input.equals(result) ? "no answer" : result;
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
