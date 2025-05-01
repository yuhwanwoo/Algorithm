package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ClimbingLeaderboard_ans {
    public static void main(String[] args) {
        List<Integer> result = climbingLeaderboard(List.of(100, 100, 50, 40, 40, 20, 10), List.of(5, 25, 50, 120));
        System.out.println(result);
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here

        List<Integer> scores = new ArrayList<>();
        for (int score : ranked) {
            if (scores.isEmpty() || score != scores.get(scores.size() - 1)) {
                scores.add(score);
            }
        }

        List<Integer> result = new ArrayList<>();
        int n = scores.size();

        for (int p : player) {
            int low = 0, high = n - 1, idx = n;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (p < scores.get(mid)) {
                    low = mid + 1;
                } else {
                    idx = mid;
                    high = mid - 1;
                }
            }
            result.add(idx + 1);
        }

        for (Integer i : result) {
            System.out.println(i);
        }

        return result;
    }
}
