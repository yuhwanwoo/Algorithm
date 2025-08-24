package hackerrank;

public class FindDigits_ans {
    public static void main(String[] args) {

    }

    public static int findDigits(int n) {
        // Write your code here
        int count = 0;
        int original = n;

        while (n > 0) {
            int digit = n % 10;  // 마지막 자리수 추출
            if (digit != 0 && original % digit == 0) {
                count++;
            }
            n /= 10; // 다음 자리수로 이동
        }

        return count;
    }
}
