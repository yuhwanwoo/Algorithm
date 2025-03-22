package programmers.year2023.lv2;

public class _178870 {
    public static void main(String[] args) {
//        int[] sequence = {1, 2, 3, 4, 5};
//        int k = 7;
        int[] sequence = {1,1,1,2,3,4,5};
        int k = 5;
        solution(sequence, k);
    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int length = Integer.MAX_VALUE;
        int start = 0;
        int end = 1;
        int sum = sequence[0];
        while (start < sequence.length) {
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            System.out.println("sum = " + sum);
            System.out.println("===================");
            if (sum < k) {
                if (end == sequence.length) {
                    break;
                }
                sum += sequence[end];
                end++;
            } else if (sum > k) {
                sum -= sequence[start];
                start++;
            } else {
                if (end - start < length) {
                    length = end - start;
                    answer = new int[]{start, end - 1};
                }
                sum -= sequence[start];
                start++;
            }
        }
        System.out.println("answer = " + answer[0]);
        System.out.println("answer = " + answer[1]);
        return answer;
    }
}
