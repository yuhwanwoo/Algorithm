package test.oh;

import java.util.HashMap;

public class Exam03 {
    public static void main(String[] args) {
        solution(new int[]{42, 97, 13, 24, 1, 76});
        countMagicPairs(new int[]{42, 97, 13, 24, 1, 76});
        countMagicPairs(new int[]{13, 10, 35, 24, 76});
    }

    private static int solution(int[] numbers) {
        /*
        100 120 140, 140
        100, 110, 130, 150
         */
        return 0;
    }

    public static int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    // 매직 페어의 개수를 찾는 함수
    public static int countMagicPairs(int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : numbers) {
            map.put(num, reverse(num));
        }

        for (int num : numbers) {
            int reversed = map.get(num);
            if (map.containsKey(reversed)) {
                if (map.get(reversed) == num && reversed != num) {
                    count++;
                }
            }
        }
        return count / 2;
    }
}
