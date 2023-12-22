package programmers.lv2;

public class _154539_fail {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5};
        solution(numbers);
    }

    public static int[] solution(int[] numbers) {
        int length = numbers.length;
        int start = 0;
        int end = start + 1;
        int[] answer = new int[length];
        int idx = 0;


        while (start < end) {
            if (end == length) {
                answer[idx] = -1;
                start += 1;
                end = start + 1;
                idx += 1;
                continue;
            }

            if (start == length) {
                answer[start - 1] = -1;
                break;
            }
            if (numbers[start] < numbers[end]) {
                answer[idx] = numbers[end];
                start += 1;
                end = start + 1;
                idx += 1;
            } else {
                end += 1;
            }
        }


        return answer;
    }
}
