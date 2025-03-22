package programmers.year2023.lv1;

import java.util.Stack;

public class _133502 {
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        solution(ingredient);
    }

    public static int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int element : ingredient) {
            stack.push(element);

            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 1) == 1 &&
                        stack.get(size - 2) == 3 &&
                        stack.get(size - 3) == 2 &&
                        stack.get(size - 4) == 1
                ) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer += 1;
                }

            }
        }

        return answer;
    }
}
