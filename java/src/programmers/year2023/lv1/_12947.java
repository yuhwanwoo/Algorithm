package programmers.year2023.lv1;

public class _12947 {
    public static void main(String[] args) {
        int x = 11;
        System.out.println(solution(x));
    }

    public static boolean solution(int x) {
        int divide = 0;
        int updateNum = x;
        while (updateNum != 0) {
            divide += updateNum % 10;
            updateNum /= 10;
        }
        System.out.println("divide = " + divide);
        return (x % divide) == 0;
    }
}
