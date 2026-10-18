package programmers.year2026.hkr.medium;

import java.util.ArrayList;
import java.util.List;

public class ClimbingLeaderboard {
    static void main() {
        climbingLeaderboard(
                List.of(100, 100, 50, 40, 40, 20, 10),
                List.of(5, 25, 50, 120)
        );
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> answer = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        set.add(ranked.get(0));

        for (int i = 1; i < ranked.size(); i++) {
            if (ranked.get(i) != set.get(set.size() - 1)) {
                set.add(ranked.get(i));
            }
        }
        System.out.println("set = " + set);
        System.out.println("player = " + player);

        for (int i = 0; i < player.size(); i++) {
            int start = 0;
            int end = set.size() - 1;
            int score = player.get(i);
            int idx = set.size();
            while (start <= end) {
                int m = (start + end) / 2;
                int now = set.get(m);
                if (now > score) {
                    start = m + 1;
                } else {
                    end = m - 1;
                    idx = m;
                }
            }
            answer.add(idx + 1);
        }

        return player;
    }
}
