package codility.test;

import java.util.HashMap;

public class Test01 {
    private static HashMap<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 4, 1, 2};

        System.out.println("solution(arr) = " + solution(arr));
    }

    private static int solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], true);
        }

        for (int i = 1; i < 1000000; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return 0;
    }
}
