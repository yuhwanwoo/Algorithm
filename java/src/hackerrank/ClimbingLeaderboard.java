package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClimbingLeaderboard {
    public static void main(String[] args) {
        climbingLeaderboard(List.of(100, 100, 50, 40, 40, 20, 10), List.of(5, 25, 50, 120));
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here

        List<Integer> deduplicatedRanked = new ArrayList<>();

        for (Integer score : ranked) {
            if (deduplicatedRanked.isEmpty() || score != deduplicatedRanked.get(deduplicatedRanked.size() - 1)) {
                deduplicatedRanked.add(score);
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        int size = deduplicatedRanked.size();

        for (int i = 0; i < player.size(); i++) {
            Integer score = player.get(i);
            int start = 0;
            int end = size - 1;
            int idx = size;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (score < deduplicatedRanked.get(mid)) {
                    start = mid + 1;
                } else {
                    idx = mid;
                    end = mid - 1;
                }
            }
            answer.add(idx + 1);
        }
        for (Integer i : answer) {
            System.out.println(i);
        }
        return answer;
    }
}
