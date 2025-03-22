package programmers.year2023.lv1;

public class _134240 {
    public static void main(String[] args) {
//        int[] food = {1,3,4,6};
        int[] food = {1,7,1,2};

        System.out.println("solution(food) = " + solution(food));
    }

    public static String solution(int[] food) {
        String answer = "";
        String right = "";
        for (int i = 1; i <= food.length - 1; i++) {
            int now = food[i];
            for (int j = 0; j < now / 2; j++) {
                answer += String.valueOf(i);
                right = i + right;
            }
        }
        return answer + 0 + right;
    }
}
