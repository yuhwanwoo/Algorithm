package programmers.year2023.lv1;

public class _12940 {
    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        solution(n, m);
    }

    public static int[] solution(int n, int m) {
        return new int[]{gcd(n, m), n * m / gcd(n, m)};
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
