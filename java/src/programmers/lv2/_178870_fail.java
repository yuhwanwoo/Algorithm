package programmers.lv2;

public class _178870_fail {
    public static void main(String[] args) {
//        int[] sequence = {1, 2, 3, 4, 5};
//        int k = 7;
//        solution(sequence, k);
//        int[] sequence1 = {1, 1, 1, 2, 3, 4, 5};
//        int k1 = 5;
//        solution(sequence1, k1);
//        int[] sequence2 = {2, 2, 2, 2, 2};
//        int k2 = 6;
//        solution(sequence2, k2);
        int[] sequence3 = {2, 2, 2, 2, 2, 10, 10, 10, 10, 10, 10};
        int k3 = 30;
        solution(sequence3, k3);

    }

    public static int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 1;
        int sum = sequence[start];
        int answerStart = start;
        int answerEnd = sequence.length;

        while (start < sequence.length) {
            if (sum == k) {
                System.out.println(1);
                if ((answerEnd - answerStart) > (end - start)) {
                    answerEnd = end;
                    answerStart = start;
                }
                end++;
            } else if (sum > k) {
                System.out.println(2);
                start++;
                end = start + 1;
                sum = sequence[start];
                continue;
            } else {
                System.out.println(3);
                end++;
            }

            if (end == sequence.length + 1) {
                System.out.println(4);
                start++;
                end = start + 1;
                if (start == sequence.length) {
                    break;
                }
                sum = sequence[start];
            } else {
                System.out.println(5);
                sum += sequence[end - 1];
            }
        }
        System.out.println("answerStart = " + answerStart);
        System.out.println("answerEnd = " + answerEnd);

        return new int[]{answerStart, answerEnd - 1};
    }
}
