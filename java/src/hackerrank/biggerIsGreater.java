package hackerrank;

import java.util.Arrays;

public class biggerIsGreater {
    public static void main(String[] args) {
        System.out.println(solve("ab"));
        System.out.println(solve("bb"));
        System.out.println(solve("hefg"));
        System.out.println(solve("dhck"));
        System.out.println(solve("dkhc"));

        System.out.println(solve("lmno"));
        System.out.println(solve("dcba"));
        System.out.println(solve("dcbb"));
        System.out.println(solve("abdc"));
        System.out.println(solve("abcd"));
        System.out.println(solve("fedcbabcd"));

//        solve("bb");
//        solve("hefg");
//        solve("dhck");
//        solve("dkhc"); // 2431 -> 3124
    }

    public static String solve(String input) {
        char[] charArray = input.toCharArray();

        for (int i = charArray.length - 1; i > 0; i--) {
            if (charArray[i] > charArray[i - 1]) {
                char target = charArray[i - 1];
                char maxChar = charArray[i];
                for (int j = i; j < charArray.length; j++) {
                    if (target < charArray[j] && maxChar >= charArray[j]) {
                        maxChar = charArray[j];
                        char tmp = charArray[j];
                        charArray[j] = charArray[i - 1];
                        charArray[i - 1] = tmp;
                    }
                }
                Arrays.sort(charArray, i, charArray.length);
                break;
            }
        }
        String answer = new String(charArray);
        return input.equals(answer) ? "no answer" : answer;
    }
}
