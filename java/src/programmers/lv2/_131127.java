package programmers.lv2;

import java.util.HashMap;

public class _131127 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        solution(want, number, discount);

        String[] want1 = {"apple"};
        int[] number1 = {10};
        String[] discount1 ={"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        solution(want1, number1, discount1);
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> target = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            target.put(want[i], number[i]);
        }

        HashMap<String, Integer> result = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            if (!result.containsKey(discount[i])) {
                result.put(discount[i], 0);
            }
            result.put(discount[i], result.get(discount[i]) + 1);
        }

        for (int i = 10; i <= discount.length; i++) {
            boolean flag = false;
            for (String item : want) {
                if (target.getOrDefault(item, -1) > result.getOrDefault(item, 0)) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag) {
                answer += 1;
            }
            if (i == discount.length) {
                break;
            }

            result.put(discount[i - 10], result.getOrDefault(discount[i - 10], 0) - 1);
            result.put(discount[i], result.getOrDefault(discount[i], 0) + 1);
        }
        return answer;
    }
}
