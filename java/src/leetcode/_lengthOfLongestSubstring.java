package leetcode;

import java.util.HashMap;

public class _lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        String[] arr = s.split("");
        int size = s.length();
        int leng = 0;
        int answer = 0;

        int st = 0;
        int end = 0;
        if(size == 0) {
            return 0;
        }

        if(size == 1){
            return 1;
        }

        while(true) {


            if(st == size - 1) {
                break;
            }
            if(end == size) {
                st += 1;
                end = st + 1;
                continue;
            }

            if(map.containsKey(arr[end])) {
                map.remove(arr[st]);
                leng -= 1;
                st += 1;
            }else {
                map.put(arr[end], 1);
                leng += 1;
                end += 1;
            }
            answer = Math.max(answer, leng);
        }


        return answer;
    }
}
