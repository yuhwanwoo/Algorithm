package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    private static List<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        generateParenthesis(3);
        answer.clear();
        generateParenthesis(1);
    }

    public static List<String> generateParenthesis(int n) {
        dfs(n, "", 0, 0);
        return answer;
    }

    private static void dfs(int n, String now, int leftCount, int rightCount) {
        if (n == rightCount) {
            answer.add(now);
            return;
        }
        if (leftCount > rightCount) {
            if (leftCount < n) {
                dfs(n, now + "(", leftCount + 1, rightCount);
            }
            dfs(n, now + ")", leftCount, rightCount + 1);
        }
        if (leftCount == rightCount) {
            dfs(n, now + "(", leftCount + 1, rightCount);
        }
    }

}
