package leetcode;

public class SearchinRotatedSortedArray_ans {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[l] < nums[mid]) {
                if(nums[l] <= target && nums[mid] > target) {
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }else if(nums[l] > nums[mid]) {
                if(nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }else{
                l += 1;
            }
        }
        if (nums[l] == target) {
            return l;
        }else{
            return -1;
        }

    }
}
