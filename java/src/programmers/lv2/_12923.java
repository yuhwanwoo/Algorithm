package programmers.lv2;

public class _12923 {
    public static void main(String[] args) {
        solution(1, 10); // 0, 1, 1, 2, 1, 3, 1, 4, 3, 5
    }

    public static int[] solution(long begin, long end) {
        int size = (int) (end - begin + 1);
        int[] answer = new int[size];
        int index = 0;
        for (int i = (int) begin; i <= end; i++) {
            if (isPrime(i)) {
                answer[index] = 1;
            } else {
                answer[index] = getMaxDivisor(i);
            }
            index++;
        }
        return answer;
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int getMaxDivisionNum(int number) {
        if (number == 1) {
            return 0;
        }

        int maxNum = 1;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0 && number / i <= 10000000) {
                maxNum = number / i;
                break;
            }
        }
        return maxNum;
    }

    private static int getMaxDivisor(int number) {
        if (number == 1) return 0;

        int result = 0;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                int pair = number / i;
                if (pair <= 10000000) return pair;
                if (i <= 10000000) result = i; // 이건 backup
            }
        }

        return result; // result는 기본 1이므로, 적어도 1은 나옴
    }
}
