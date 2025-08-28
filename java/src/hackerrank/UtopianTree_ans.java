package hackerrank;

public class UtopianTree_ans {
    public static int utopianTree(int n) {
        int answer = 1;
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                if (answer % 2 == 1) {
                    answer *= 2;
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }
}
