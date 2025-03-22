package programmers.year2023.lv1;

public class _12930 {
    public static void main(String[] args) {
        String s = "TrY HeLlO WoRlD";
        System.out.println("solution(s) = " + solution(s));
    }

    public static String solution(String s) {
        String answer = "";
        String[] strings = s.split(" ", -1);
        String[] answerStr = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String tmp = "";
            for (int j = 0; j < strings[i].length(); j++) {
                char now = strings[i].charAt(j);
                if (Character.isAlphabetic(now)) {
                    if (j % 2 == 0) {
                        tmp += Character.toUpperCase(now);
                    } else {
                        tmp += Character.toLowerCase(now);
                    }
                } else {
                    tmp += now;
                }
            }
            answerStr[i] = tmp;
        }
        return String.join(" ", answerStr);
    }
}
