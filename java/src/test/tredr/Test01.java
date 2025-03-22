package test.tredr;

public class Test01 {
    public static void main(String[] args) {
        solution(1);
        solution(2);
        solution(5);
        solution(6);
        solution(7);
        solution(12);
        solution(13);
    }

    public static long[] solution(long n)
    {
        System.out.println("n = " + n);
        long plusMinDay = n % 7 == 6 ? 1 : 0;
        long plusMaxDay = 0;

        if (n % 7 <= 1) {
            plusMaxDay = n % 7;
        } else {
            plusMaxDay = 2;
        }
        long minDay = ((n / 7) * 2) + plusMinDay;
        long maxDay = ((n / 7) * 2) + plusMaxDay;

        System.out.println("minDay = " + minDay);
        System.out.println("maxDay = " + maxDay);
        System.out.println("===============");

        return new long[]{minDay, maxDay};
    }
}
