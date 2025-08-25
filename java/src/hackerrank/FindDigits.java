package hackerrank;

public class FindDigits {
    public static void main(String[] args) {

    }

    public static int findDigits(int n) {
        // Write your code here
        int answer = 0;
        int originNum = n;
        while (n != 0) {
            int last = n % 10;
            if (last != 0 && originNum % last == 0) {
                answer++;
            }
            n /= 10;
        }

        return answer;
    }
}
