package programmers.year2023.lv1;

import java.util.HashMap;

public class _1845 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};

        System.out.println(solution(nums));

    }

    public static int solution(int[] nums) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int now = nums[i];
            if (!map.containsKey(now)) {
                map.put(now, 1);
            }
        }

        answer = map.keySet().size() <= nums.length / 2 ? map.keySet().size() : nums.length / 2;

        return answer;
    }
}
