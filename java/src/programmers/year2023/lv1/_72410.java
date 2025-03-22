package programmers.year2023.lv1;

public class _72410 {
    public static void main(String[] args) {
//        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String new_id = "b";
                solution(new_id);
    }

    public static String solution(String new_id) {
        new_id = new_id.toLowerCase();
        String tmp = "";
        for (int i = 0; i < new_id.length(); i++) {
            char now = new_id.charAt(i);
            if (Character.isAlphabetic(now) || Character.isDigit(now) || now == '-'
                    || now == '_' || now == '.') {
                tmp += (char) now;
            }
        }
        new_id = tmp;
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }
        while (new_id.startsWith(".")) {
            new_id = new_id.replaceFirst(".", "");
        }

        while (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        if (new_id.length() == 0) {
            new_id = "a";
        }

        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        while (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        while (new_id.length() <= 2) {
            new_id += (new_id.charAt(new_id.length() - 1) + "").repeat(3 - new_id.length());
        }
        System.out.println("new_id = " + new_id);

        return new_id;
    }
}
