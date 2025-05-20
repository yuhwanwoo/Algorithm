package leetcode;

import java.util.Arrays;

public class ThreeSumClosest_ans {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int min_diff = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    if (sum - target < min_diff) {
                        min_diff = sum - target;
                        answer = sum;
                    }
                    k--;
                }
                if (sum < target) {
                    if (target - sum < min_diff) {
                        min_diff = target - sum;
                        answer = sum;
                    }
                    j++;
                }
            }
        }
        return answer;
    }
}

