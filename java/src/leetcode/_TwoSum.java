package leetcode;

import java.util.*;

public class _TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = nums.length;

        for(int i = 0; i < size; i++) {
            int gap = target - nums[i];
            if(map.containsKey(gap)) {
                return new int[] {map.get(gap), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
