package hackerrank;

import java.util.List;

public class TheBirthdayBar_ans {
    public static void main(String[] args) {

    }

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int result = 0;
        int sum = 0;
        for (int i = 0; i < s.size(); i++) {
            sum += s.get(i);
            if (i >= m) {
                sum -= s.get(i - m);
            }
            if (i >= m - 1 && sum == d) {
                result++;
            }
        }
        return result;
    }
}
