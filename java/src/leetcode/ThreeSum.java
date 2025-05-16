package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
        int[] nums2 = {0,1,1};
        threeSum(nums2);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                list.add(num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        list.sort(Comparator.comparingInt(Integer::intValue));

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                Integer iValue = list.get(i);
                if (i == j && !(map.get(iValue) > 1)) {
                    continue;
                }
                Integer jValue = list.get(j);
                int sum =  iValue + jValue;
                if (iValue > jValue || jValue > -sum) {
                    continue;
                }
                map.put(iValue, map.get(iValue) - 1);
                map.put(jValue, map.get(jValue) - 1);

                if (map.containsKey(-sum) && map.get(-sum) > 0) {
                    answer.add(List.of(iValue, jValue, -sum));
                }
                map.put(iValue, map.get(iValue) + 1);
                map.put(jValue, map.get(jValue) + 1);
            }
        }

        return answer;
    }
}
