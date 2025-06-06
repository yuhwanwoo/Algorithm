package programmers.lv2;

public class _12923_ans2 {
    public int[] solution(long begin, long end) {
        int[] result = new int[(int) (end - begin + 1)];
        int index = 0;
        for (int i = (int) begin; i <= end; i++, index++) {
            if (isPrime(i)) {
                result[index] = 1;
            } else {
                result[index] = getMaxDivisor(i);
            }
        }

        return result;
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private int getMaxDivisor(int number) {
        if (number == 1) {
            return 0;
        }

        int result = 1;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0 && number / i <= 10000000) {
                result = number / i;
                break;
            }
        }

        return result;
    }
}
