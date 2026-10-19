package programmers.year2026.hkr.medium;

import java.util.Arrays;

public class BiggerIsGreater {
    static void main() {
        System.out.println("biggerIsGreater() = " + biggerIsGreater("ab"));
        System.out.println("answer = " + "ba");
        System.out.println("biggerIsGreater() = " + biggerIsGreater("bb"));
        System.out.println("answer = " + "no ans");
        System.out.println("biggerIsGreater() = " + biggerIsGreater("hefg"));
        System.out.println("answer = " + "hegf");
        System.out.println("biggerIsGreater() = " + biggerIsGreater("dhck"));
        System.out.println("answer = " + "dhkc");
        System.out.println("biggerIsGreater() = " + biggerIsGreater("dkhc"));
        System.out.println("answer = " + "hcdk");
    }

    public static String biggerIsGreater(String w) {
        // Write your code here
        char[] array = w.toCharArray();
        int n = w.length() - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (array[i] < array[i + 1]) {
                char maxChar = array[i + 1];
                int targetIdx = i + 1;
                n = i;
                for (int j = i + 1; j < w.length(); j++) {
                    if (maxChar > array[j] && array[i] < array[j]) {
                        targetIdx = j;
                    }
                }
                char tmp = array[i];
                array[i] = array[targetIdx];
                array[targetIdx] = tmp;
                break;
            }
        }

        if (n == w.length() - 1) {
            return "no answer";
        }

        Arrays.sort(array, n + 1, array.length);

        return new String(array);
    }
}
