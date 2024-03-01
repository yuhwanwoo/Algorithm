package programmers.lv2;

public class _178870 {
    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        solution(sequence, k);
        int[] sequence1 = {1, 1, 1, 2, 3, 4, 5};
        int k1 = 5;
        solution(sequence1, k1);
        int[] sequence2 = {2, 2, 2, 2, 2};
        int k2 = 6;
        solution(sequence2, k2);
    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int start = 0;
        int end = 1;
        int sum = sequence[start];
        int answerStart = start;
        int answerEnd = sequence.length;

        while (start < sequence.length) {
//            System.out.println("start = " + start);
//            System.out.println("end = " + end);
//            System.out.println("sum = " + sum);
            if (sum == k) {
                if ((answerEnd - answerStart) > (end - start)) {
                    answerEnd = end;
                    answerStart = start;
                }
                end++;
            } else if (sum > k) {
                sum -= sequence[start];
                start++;
            } else {
                if (end == sequence.length - 1) {
                    end++;
                } else {
                    sum += sequence[++end];
                }
            }

            if (end >= sequence.length) {
                start++;
                end = start + 1;
            }
        }
        System.out.println("answerStart = " + answerStart);
        System.out.println("answerEnd = " + answerEnd);

        return answer;
    }
}
