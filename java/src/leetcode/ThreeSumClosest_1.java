package leetcode;

import java.util.Arrays;

public class ThreeSumClosest_1 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        threeSumClosest(nums, 1);
        int[] nums2 = {0,0,0};
        threeSumClosest(nums2, 1);

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
