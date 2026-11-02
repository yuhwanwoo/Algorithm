package programmers.year2026.hkr.medium;

public class TimeInWords {
    static void main() {

    }


    public static String timeInWords(int h, int m) {
        String[] numbers = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen",
                "twenty"
        };

        if (m == 0) {
            return numbers[h] + " o' clock";
        }

        if (m == 15) {
            return "quarter past " + numbers[h];
        }

        if (m == 30) {
            return "half past " + numbers[h];
        }

        int nextHour = h == 12 ? 1 : h + 1;

        if (m == 45) {
            return "quarter to " + numbers[nextHour];
        }

        if (m < 30) {
            return minuteToWords(m, numbers)
                    + (m == 1 ? " minute past " : " minutes past ")
                    + numbers[h];
        }

        int remaining = 60 - m;

        return minuteToWords(remaining, numbers)
                + (remaining == 1 ? " minute to " : " minutes to ")
                + numbers[nextHour];
    }

    private static String minuteToWords(int m, String[] numbers) {
        if (m <= 20) {
            return numbers[m];
        }

        return "twenty " + numbers[m - 20];
    }

}
