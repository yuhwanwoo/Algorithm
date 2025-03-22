package codility.test;

public class Training01 {
    public static void main(String[] args) {
        int[] A = {3,4,4,6,1,4,4};
        int N = 5;

        solution(N, A);
    }

    // {3,4,4,6,1,4,4}
    public static int[] solution(int N, int[] A) {
        int maxCount = 0;
        int currentMaxCount = 0;
        int[] answer = new int[N];

        for (int i = 0; i < A.length; i++) {
            int idx = A[i] - 1;
            System.out.println("idx = " + idx);
            if (idx >= N) {
                maxCount = currentMaxCount;
                continue;
            }

            if (answer[idx] < maxCount) {
                answer[idx] = maxCount + 1;
            } else {
                answer[idx]++;
            }

            if (answer[idx] > currentMaxCount) {
                 currentMaxCount = answer[idx];
            }
        }


        for (int i = 0; i < answer.length; i++) {
            if (maxCount > answer[i]) {
                answer[i] = maxCount;
            }
        }

        return answer;
    }
}
