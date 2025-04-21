package programmers.lv2;

public class _12923 {
    public static void main(String[] args) {
        solution(1, 10); // 0, 1, 1, 2, 1, 3, 1, 4, 3, 5
    }

    public static int[] solution(long begin, long end) {
        int size = (int) (end - begin + 1);
        int[] answer = new int[size];
        for (int i = 0; i <= (int) (end - begin + 1); i++) {
            if (isPrime((int) begin + i + 1)) {
                answer[i] = 1;
            } else if ((int) begin + i == 0) {
                answer[i] = 1;
            } else {
                answer[i] = getMaxDivisionNum((int) begin + i + 1);
            }

        }
        for (int i : answer) {
            System.out.print(i + " ");
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
        int maxNum = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                maxNum = i;
            }
        }
        return maxNum;
    }
}
