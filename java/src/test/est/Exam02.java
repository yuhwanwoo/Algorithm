package test.est;

import java.util.LinkedList;
import java.util.Queue;

public class Exam02 {
    public static void main(String[] args) {
//        int[] queue = {2, 1, 3, 1, 2, 1};
//        int[] queue = {3,3,3,3,3,3};
        int[] queue = {1, 1, 1,1,1,2,3,3,3};
        solution(queue);
    }

    public static int[] solution(int[] queue) {
        int[] answer = {0, 0, 0};
        Queue<Integer> q = new LinkedList<>();
        int one = 0;
        int two = 0;
        int three = 0;
        int target = queue.length / 3;
        System.out.println("target = " + target);

        for (int i = 0; i < queue.length; i++) {
            int input = queue[i];
            if (input == 1) {
                one += 1;
            }
            if (input == 2) {
                two += 1;
            }
            if (input == 3) {
                three += 1;
            }
            q.add(input);
        }

        while (q.size() == queue.length) {
            if (one == two && two == three) {
                break;
            }
            Integer top = q.poll();
            if (top == 1 && one == target) {
                q.add(1);
                answer[0]++;
            } else if (top == 1 && one > target && two < target) {
                one--;
                q.add(2);
                two++;
                answer[1]++;
            } else if (top == 1 && one > target && three < target) {
                one--;
                q.add(3);
                three++;
                answer[2]++;
            } else if (top == 2 && two == target) {
                q.add(2);
                answer[1]++;
            } else if (top == 2 && two > target && one < target) {
                two--;
                q.add(1);
                one++;
                answer[0]++;
            } else if (top == 2 && two > target && three < target) {
                two--;
                q.add(3);
                three++;
                answer[2]++;
            } else if (top == 3 && three == target) {
                q.add(3);
                answer[2]++;
            } else if (top == 3 && three > target && two < target) {
                three--;
                q.add(2);
                two++;
                answer[1]++;
            } else if (top == 3 && three > target && one < target) {
                three--;
                q.add(1);
                one++;
                answer[0]++;
            }
        }
        System.out.println("q = " + q);
        return answer;
    }
}
