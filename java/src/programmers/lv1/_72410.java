package programmers.lv1;

public class _72410 {
    public static void main(String[] args) {
        String input = "...!@BaT#*..y.abcdefghijklm";
        solution(input);
    }

    public static String solution(String new_id) {
        String lowerCase = new_id.toLowerCase();
        System.out.println("lowerCase = " + lowerCase);
        String replaceAll = lowerCase.replaceAll("[^a-z0-9-_]", "");
        System.out.println("replaceAll = " + replaceAll);
        return "";
    }
}
