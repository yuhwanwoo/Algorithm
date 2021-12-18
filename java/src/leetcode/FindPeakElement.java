package leetcode;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int leftPoint = 0;
        int rightPoint = nums.length - 1;

        while (leftPoint < rightPoint) {
            int mid = (leftPoint + rightPoint) / 2;
            if (nums[mid] < nums[mid + 1]) {
                leftPoint = mid + 1;
            }
            else {
                rightPoint = mid;
            }
        }

        return leftPoint;
    }

}
