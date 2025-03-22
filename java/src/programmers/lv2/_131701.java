package programmers.lv2;

import java.util.ArrayList;
import java.util.HashSet;

public class _131701 {
    public static void main(String[] args) {
        solution(new int[]{7, 9, 1, 1, 4});
    }

    private static int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < elements.length * 2 - 1; i++) {
            array.add(elements[i % elements.length]);
        }
        int sum;
        for (int i = 0; i < elements.length; i++) {
            sum = 0;
            for (int j = i; j < i + elements.length; j++) {
                sum += array.get(j);
                set.add(sum);
            }
        }
        return set.size();
    }
}
