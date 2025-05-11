package leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        longestCommonPrefix(strs);
        String[] strs2 = {"a"};
        longestCommonPrefix(strs2);
    }

    public static String longestCommonPrefix(String[] strs) {
        String answer = "";
        String tmp = "";

        for (int i = 0; i < strs[0].length(); i++) {
            tmp += strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(tmp)) {
                    break;
                }
                if (j == strs.length - 1) {
                    answer = tmp;
                }
            }
        }

        return answer;
    }

}
