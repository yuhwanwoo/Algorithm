package programmers.year2023.lv1;

public class _147355 {
    public static void main(String[] args) {
//        String t = "3141592";
//        String p = "271";

//        String t = "500220839878";
//        String p = "7";

//        String t = "10203";
//        String p = "15";

        String t = "12";
        String p = "12";

        solution(t, p);
    }

    public static int solution(String t, String p) {
        int answer = 0;
        Long pLong = Long.parseLong(p);
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String substring = t.substring(i, i + p.length());

            Long subStringInteger = Long.parseLong(substring);
            if (pLong >= subStringInteger) {
                answer += 1;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
