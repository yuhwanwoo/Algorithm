package programmers.lv2;

import java.util.Stack;

public class _131704_2 {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5};
        solution(order);
        int[] order2 = {5, 4, 3, 2, 1};
        solution(order2);
    }

    public static int solution(int[] order) {
        int answer = 0;
        int index = 0;
        Stack<Integer> subConvey = new Stack<>();

        for (int i = 1; i <= order.length; i++) {
            if (i == order[index]) {
                answer++;
                index++;
            } else {
                subConvey.push(i);
            }

            while (!subConvey.isEmpty()) {
                if (subConvey.peek() == order[index]) {
                    subConvey.pop();
                    answer++;
                    index++;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
