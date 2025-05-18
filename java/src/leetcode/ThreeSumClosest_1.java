package leetcode;

public class ThreeSumClosest_1 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        threeSumClosest(nums, 1);
        int[] nums2 = {0,0,0};
        threeSumClosest(nums2, 1);

    }

    public static int threeSumClosest(int[] nums, int target) {
        int answer = nums[0] + nums[1] + nums[2];


        return answer;
    }
}
