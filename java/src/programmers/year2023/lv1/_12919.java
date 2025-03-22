package programmers.year2023.lv1;

public class _12919 {
    public static void main(String[] args) {

    }

    public static String solution(String[] seoul) {
        String answer = "";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                return "김서방은 " + i + "에 있다";
            }
        }
        return answer;
    }
}
