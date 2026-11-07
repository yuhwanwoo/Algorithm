package programmers.year2026.hkr.medium;

public class Encryption_ans {
    static void main() {

    }


    public static String encryption(String s) {
        s = s.replace(" ", "");

        int length = s.length();

        int rows = (int) Math.floor(Math.sqrt(length));
        int cols = (int) Math.ceil(Math.sqrt(length));

        if (rows * cols < length) {
            rows++;
        }

        StringBuilder result = new StringBuilder();

        for (int col = 0; col < cols; col++) {
            for (int row = col; row < length; row += cols) {
                result.append(s.charAt(row));
            }

            if (col < cols - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

}
