package hackerrank;

import java.util.List;

public class DivisibleSumPairs {
    public static void main(String[] args) {

    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        // Write your code here
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar.get(i) + ar.get(j)) % k == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
