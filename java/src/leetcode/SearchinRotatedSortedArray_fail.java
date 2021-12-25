package leetcode;

public class SearchinRotatedSortedArray_fail {
    public int search(int[] nums, int target) {
        int result = 0;

        int size = nums.length;

        if(size == 1) {
            if(nums[0] == target) {
                return 0;
            }else{
                return -1;
            }
        }

        int start = 0;
        int end = size - 1;

        int idx = 0;

        int val = nums[0];
        int mid = 0;

        // Find Ascending Last Index
        while(start <= end){
            mid = (start + end) / 2;

            if(val <= nums[mid]){
                idx = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        // System.out.println(idx);

        int rot = size - idx - 1;
        start = (idx + 1) % size;
        end = idx;
        System.out.println(start + " " + end + " " + rot);

        while(((start + rot) % size) <= (end + rot) % size) {
            mid = ((end + rot) % size + ((start + rot) % size)) / 2;

            int tm = mid;
            if(tm < rot) {
                tm = size + (tm - rot);
            }else{
                tm -= rot;
            }
            System.out.println(tm + " " + start + " " + end);

            if (nums[tm] == target) {
                // System.out.println(tm);
                return tm;
            } else if (nums[tm] > target) {
                end = tm ;
            } else {
                start = tm + 1;
            }
        }

        return -1;
    }
}
