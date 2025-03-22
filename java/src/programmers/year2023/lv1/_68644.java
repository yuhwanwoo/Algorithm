package programmers.year2023.lv1;

import java.util.HashSet;

public class _68644 {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};

        solution(numbers);
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> set = new HashSet<>();
        int start = 0;
        int end = numbers.length - 1;

        while (start < numbers.length) {
            if (start >= end) {
                start++;
                end = numbers.length - 1;
                continue;
            }
            set.add(numbers[start] + numbers[end]);
            end--;
        }

        answer = set.stream().mapToInt(Integer::intValue).sorted().toArray();

        return answer;
    }
}
