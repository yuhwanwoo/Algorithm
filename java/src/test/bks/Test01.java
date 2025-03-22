package test.bks;

public class Test01 {
    public static void main(String[] args) {
        solution(100,300);
    }

    public static int solution(int n , int m) {
        int answer = 0;
        for (int i = n; i <= m; i++) {
            if (isPalindrome(i)) {
                answer += 1;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    private static boolean isPalindrome(int num) {
        String[] splitNum = String.valueOf(num).split("");
        int size = splitNum.length;

        for (int i = 0; i < size / 2; i++) {
            if (!splitNum[i].equals(splitNum[size - 1 - i])) {
                return false;
            }
        }
        return true;
    }
}
