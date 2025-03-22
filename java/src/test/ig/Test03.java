package test.ig;

import java.util.Arrays;

public class Test03 {
    public static void main(String[] args) {
        int[] A = {100, 250, 1000, 2000};

        solution(A);
    }

    private static int solution(int[] A) {
        int tempSum = A[0];
        int sum;
        int answer = 0;
        Arrays.sort(A);

        for (int i = 1; i < A.length; i++) {
            sum = A[i] + tempSum;
            answer += sum;
            tempSum = answer;

        }
        System.out.println("answer = " + answer); // 이렇게 했어야 함
        return answer;
    }
}
