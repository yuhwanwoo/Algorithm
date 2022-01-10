package test.kb;

import java.util.HashMap;
import java.util.Stack;

public class exam02 {

    public static void main(String[] args) {
        String[] arr1 = {"()", "(()", ")()", "()"};
        String[] arr2 = {")()", "()", "(()"};

        solution(arr1, arr2);
    }

    public static long solution(String[] arr1, String[] arr2) {
        long answer = 0;

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            String key = arr1[i];
            if (!map1.containsKey(key)) {
                map1.put(key, 1);
            }else {
                map1.put(key, map1.get(key) + 1);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            String key = arr2[i];
            if (!map2.containsKey(key)) {
                map2.put(key, 1);
            }else {
                map2.put(key, map2.get(key) + 1);
            }
        }

        for (String key1 : map1.keySet()) {
            for (String key2 : map2.keySet()) {
                String combination = key1 + key2;
                if (judge(combination)) {
                    answer += (map1.get(key1) * map2.get(key2));
                }
            }
        }
//
//
//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = 0; j < arr2.length; j++) {
//                String combination = arr1[i] + arr2[j];
//                if (ans.contains(combination)) {
//                    answer += 1;
//                    continue;
//                }
//
//                if (judge(combination)) {
//                    answer += 1;
//                    ans.add(combination);
//                }
//            }
//        }
        System.out.println(answer);
        return answer;
    }

    public static boolean judge(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push('(');
            else{
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty() == true ? true : false;
    }
}
