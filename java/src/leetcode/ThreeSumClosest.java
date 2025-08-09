package leetcode;

import java.util.List;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        threeSumClosest(nums, 1);
        int[] nums2 = {0,0,0};
        threeSumClosest(nums2, 1);

    }

    public static int threeSumClosest(int[] nums, int target) {
        int answer = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sum - target) < Math.abs(answer - target)) {
                        answer = sum;
                    }
                }
            }
        }
        return answer;
    }
}
