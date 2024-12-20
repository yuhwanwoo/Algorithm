package programmers.lv1;

public class _72410 {
    public static void main(String[] args) {
        String input = "...!@BaT#*..y.abcdefghijklm";
        System.out.println("solution(input) = " + solution(input));
        String input1 = "z-+.^.";
        System.out.println("solution(input) = " + solution(input1));

        String input2 = "=.=";
        System.out.println("solution(input) = " + solution(input2));

        String input4 = "123_.def";
        System.out.println("solution(input) = " + solution(input4));
        String input3 = "abcdefghijklmn.p";
        System.out.println("solution(input) = " + solution(input3));


    }

    public static String solution(String new_id) {
        String lowerCase = new_id.toLowerCase();
        String result = lowerCase.replaceAll("[^a-z0-9-_.]", "")
                .replaceAll("\\.{2,}", ".")
                .replaceAll("^\\.|\\.$", "");

        if (result.isEmpty()) {
            result = "a";
        }

        result = result.length() >= 16 ? result.substring(0, 15)
                .replaceAll("^\\.|\\.$", "")
                : result;

        return result.length() > 2 ? result : result + (result.charAt(result.length() - 1) + "").repeat(3 - result.length());
    }
}
