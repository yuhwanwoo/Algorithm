package programmers.year2023.lv1;

public class _82612 {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;

        System.out.println(solution(price, money, count));
    }

    public static long solution(int price, int money, int count) {
        long totalPrice = 0;
        for (int i = 1; i <= count; i++) {
            totalPrice += (price * i);
        }

        return totalPrice - money > 0 ? totalPrice - money : 0;
    }
}
