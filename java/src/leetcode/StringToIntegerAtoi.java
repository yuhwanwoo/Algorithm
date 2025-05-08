package leetcode;

public class StringToIntegerAtoi {
    //https://leetcode.com/problems/string-to-integer-atoi/
    public static void main(String[] args) {
        String s = "1337c0d3";
        System.out.println("myAtoi() = " + myAtoi(s));
    }

    public static int myAtoi(String s) {
        String str = s.trim();

        if (str.length() == 0) {
            return 0;
        }
        if (str.charAt(0) == '+') {
            return convert(str.substring(1), false);
        }
        if (str.charAt(0) == '-') {
            return convert(str.substring(1), true);
        }

        if (Character.isDigit(str.charAt(0))) {
            return convert(str, false);
        }
        return 0;
    }

    private static int convert(String s, boolean isNegative) {
        long value = 0;

        for (int idx = 0; idx < s.length(); idx++) {
            if (!Character.isDigit(s.charAt(idx))) {
                break;
            }
            value = value * 10 + Character.getNumericValue(s.charAt(idx));

            if (value > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        return (int) (isNegative ? -value : value);
    }
}
