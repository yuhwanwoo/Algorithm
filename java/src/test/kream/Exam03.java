package test.kream;

import java.util.Arrays;
import java.util.List;

public class Exam03 {
    public static void main(String[] args) {
        System.out.println("maxLength(Arrays.asList(1, 2, 3), 4) = " + maxLength(Arrays.asList(1, 2, 3), 4));

    }

    public static int maxLength(List<Integer> a, int k) {
        int start = 0;
        int end = 1;
        int size = a.size();
        int sum = a.get(0);
        int answer = 0;

        while (start < size) {
            if (sum < k) {
                if (end == size) {
                    break;
                }
                answer = Math.max(answer, end - start);
                sum += a.get(end);
                end++;
            } else if (sum > k) {
                sum -= a.get(start);
                start++;
            } else {
                answer = Math.max(answer, end - start);

                sum -= a.get(start);
                start++;
            }
        }
        return answer;
    }
}
