package test.kream;

public class Exam01 {
    public static void main(String[] args) {
//        String s = "AWAWSSG";
        String s = "AAWSWS";

        solution(s);
    }
    private static String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int index = sb.indexOf("AWS");
        while (index != -1) {
            sb.delete(index, index + 3); // Remove "AWS"
            index = sb.indexOf("AWS");
        }
        return sb.toString();
    }
}
