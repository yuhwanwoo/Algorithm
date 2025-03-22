package programmers.year2023.lv1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _159994 {
    public static void main(String[] args) {
//        String[] cards1 = {"i", "drink", "water"};
//        String[] cards2 = {"want", "to"};
//        String[] goal = {"i", "want", "to", "drink", "water"};

        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        solution(cards1, cards2, goal);
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> queue1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> queue2 = new LinkedList<>(Arrays.asList(cards2));

        for (String target : goal) {
            String q1Top = queue1.peek();
            String q2Top = queue2.peek();
            if (q1Top != null && q1Top.equals(target)) {
                queue1.poll();
            } else if (q2Top != null && q2Top.equals(target)) {
                queue2.poll();
            } else {
                answer = "No";
            }
        }

        return answer;
    }
}
