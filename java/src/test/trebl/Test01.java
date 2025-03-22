package test.trebl;

public class Test01 {
    public static void main(String[] args) {
        /**
         * 41 =
         * 16 + 1 = 17
         * 1 + 49 = 50
         * 25 + 0 = 25
         * 4 + 25 = 29
         * 4 + 81 = 85
         * 64 + 25 = 109
         * 1 + 0 + 81 = 82
         * 64 + 4 = 68
         * 36 + 64 = 100
         * 1 = 1
         *
         * 4 + 1 = 5
         * 25
         * 4 + 25
         */
        solution(21);
    }

    public static int solution(int n) {
        int count = 0;
        while (n >= 10) {
            count += 1;
            n = calculateNum(n);
            System.out.println("n = " + n);
        }
        System.out.println("count = " + count);
        System.out.println("n = " + n);
        return n == 1 ? count : -1;
    }

    private static int calculateNum(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += (digit * digit);
            number /= 10;
        }
        return sum;
    }
}
