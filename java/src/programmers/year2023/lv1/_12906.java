package programmers.year2023.lv1;

import java.util.Arrays;
import java.util.Stack;

public class _12906 {
    public static void main(String[] args) {

    }

    public static int[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];
            if (stk.isEmpty()) {
                stk.add(now);
            } else {
                Integer peek = stk.peek();
                if (now != peek) {
                    stk.add(now);
                }
            }
        }
        Integer[] integers = stk.toArray(new Integer[0]);

        return Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
    }
}
