package programmers.year2023.lv1;

public class _12903 {
    public static void main(String[] args) {
//        String s = "abcde";
        String s = "qwer";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "";
        int size = s.length();
        int idx = size / 2;
        if (size % 2 == 0) {
            answer = String.valueOf(s.charAt(idx - 1)) + s.charAt(idx) + "";
        } else {
            answer += (char) s.charAt(idx);
        }
        return answer;
    }
}
