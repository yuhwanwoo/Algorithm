package programmers.lv2;

public class _178870 {
    public static void main(String[] args) {
//        int[] sequence = {1, 2, 3, 4, 5};
//        int k = 7;
//        solution(sequence, k); //2,4
//        int[] sequence1 = {1, 1, 1, 2, 3, 4, 5};
//        int k1 = 5;
//        solution(sequence1, k1); // 6,6
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
            System.out.println("==========");
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            System.out.println("sum = " + sum);
            if (sum == k) {
                System.out.println(1);
                if ((answerEnd - answerStart) > (end - start)) {
                    answerEnd = end;
                    answerStart = start;
                }
                if (end == sequence.length) {
                    break;
                }
                sum += sequence[end];
                end++;
            } else if (sum > k) {
                System.out.println(2);
                sum -= sequence[start];
                start++;
            } else {
                System.out.println(3);
                if (end == sequence.length) {
                    break;
                }
                sum += sequence[end];
                end++;
            }

            if (end == sequence.length + 1) {
                System.out.println(4);
                break;
            }
        }
        System.out.println("answerStart = " + answerStart);
        System.out.println("answerEnd = " + answerEnd);

        return new int[]{answerStart, answerEnd - 1};
    }
}
