package leetcode;

public class findFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10}, 8);
        searchRange(new int[]{5,7,7,8,8,10}, 6);
        searchRange(new int[]{}, 0);
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{findLeftBound(nums, target), findRightBound(nums, target)};
    }

    public static int findLeftBound(int[] nums, int target) {
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
        return answer;
    }

    public static int findRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                answer = mid;
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
