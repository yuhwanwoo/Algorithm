package leetcode;

import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {

    }

    public static int searchInsert(int[] nums, int target) {
        System.out.println("nums = " + nums);findLeftBound(nums, target);
        return Arrays.binarySearch(nums, target);
    }

    private static int findLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                answer = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer == -1 ? left + 1 : answer;
    }
}
