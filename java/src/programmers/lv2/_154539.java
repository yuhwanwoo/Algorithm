package programmers.lv2;

import java.util.Stack;

public class _154539 {
    public static void main(String[] args) {
        /*
        정수로 이루어진 배열 numbers가 있습니다.
        배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
        정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을
        차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다
         */
//        int[] numbers = {2, 3, 3, 5}; // 3,5,5,-1
         int[] numbers = {9, 1, 5, 3, 6, 2}; // -1, 5, 6, 6, -1, -1
        solution(numbers);
    }

    public static int[] solution(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];

        Stack<Integer> stk = new Stack<>();

        stk.push(0);

        for (int i = 1; i < length; i++) {
            while (!stk.isEmpty() && numbers[stk.peek()] < numbers[i]) {
                Integer top = stk.pop();
                answer[top] = numbers[i];
            }
            stk.push(i);
        }

        while (!stk.isEmpty()) {
            answer[stk.pop()] = -1;
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }

        return answer;
    }
}
