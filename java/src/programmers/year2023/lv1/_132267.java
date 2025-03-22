package programmers.year2023.lv1;

public class _132267 {
    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int n = 20;

//        int a = 3;
//        int b = 1;
//        int n = 20;

        solution(a, b, n);
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;
        int havingBottle;
        while (a <= n) {
            answer += ((n / a) * b);
            havingBottle = (n % a);
            n = ((n / a) * b) + havingBottle;
        }

        System.out.println("answer = " + answer);

        return answer;
    }
}
