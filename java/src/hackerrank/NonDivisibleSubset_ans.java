package hackerrank;

import java.io.IOException;
import java.util.List;

public class NonDivisibleSubset_ans {

    public static void main(String[] args) throws IOException {
        nonDivisibleSubset(3, List.of(1, 7, 2, 4));
        nonDivisibleSubset(4, List.of(19, 10, 12, 10, 24, 25, 22));
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int answer = 0;
        int[] divisions = new int[k];

        for (Integer i : s) {
            divisions[i % k]++;
        }

        answer += Math.min(divisions[0], 1);

        for (int i = 1; i <= k / 2; i++) {
            if (i == k - 1) {
                answer++;
            } else {
                answer += Math.max(divisions[i], divisions[k - i]);
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}

