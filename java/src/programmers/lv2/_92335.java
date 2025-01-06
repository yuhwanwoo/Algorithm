package programmers.lv2;

public class _92335 {
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        solution(n, k);
        n = 110011;
        k = 10;
        solution(n, k);

    }

    public static int solution(int n, int k) {
        int answer = 0;
        String radixNumber = Integer.toString(n, k);
        System.out.println("radixNumber = " + radixNumber);
        String[] targets = radixNumber.split("0");
        for (String target : targets) {
            if (target.equals("")) {
                continue;
            }
            if (isPrime(Long.parseLong(target))) {
                answer += 1;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
