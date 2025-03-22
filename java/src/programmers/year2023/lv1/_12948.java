package programmers.year2023.lv1;

public class _12948 {
    public static void main(String[] args) {
//        String phone_number = "01033334444";
        String phone_number = "027778888";
        solution(phone_number);
    }

    public static String solution(String phone_number) {
        String answer = "";
        for (int i = 0; i < phone_number.length(); i++) {
            if (i < phone_number.length() - 4) {
                answer += "*";
            } else {
                answer += phone_number.charAt(i);
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
